package com.hristiyang.binance.db;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;


import com.hristiyang.binance.models.CryptoEntity;
import com.hristiyang.binance.utils.NetworkUtil;
import com.hristiyang.binance.api.ApiClient;
import com.hristiyang.binance.api.ApiService;

import java.util.List;

public class CryptoRepository {
    private CryptoDao cryptoDao;
    private LiveData<List<CryptoEntity>> allCryptos;
    private ApiService apiService;
    private Context context;

    public CryptoRepository(Application application) {
        CryptoDatabase db = CryptoDatabase.getDatabase(application);
        cryptoDao = db.cryptoDao();
        allCryptos = cryptoDao.getAllCryptos();
        apiService = ApiClient.getClient().create(ApiService.class);
        this.context = application.getApplicationContext();
    }

    public LiveData<List<CryptoEntity>> getAllCryptos() {
        return allCryptos;
    }

    public void fetchAndStoreCryptos() {
        if (NetworkUtil.isNetworkAvailable(context)) {
            new FetchCryptosTask(cryptoDao, apiService).execute();
        }
    }

    private static class FetchCryptosTask extends AsyncTask<Void, Void, Void> {
        private CryptoDao cryptoDao;
        private ApiService apiService;

        FetchCryptosTask(CryptoDao cryptoDao, ApiService apiService) {
            this.cryptoDao = cryptoDao;
            this.apiService = apiService;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                List<CryptoEntity> cryptos = apiService.getCryptos().execute().body();
                if (cryptos != null) {
                    cryptoDao.insertCryptos(cryptos);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}