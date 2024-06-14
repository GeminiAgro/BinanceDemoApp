package com.hristiyang.binance.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.hristiyang.binance.db.CryptoRepository;
import com.hristiyang.binance.models.CryptoEntity;

import java.util.List;

public class CryptoViewModel extends AndroidViewModel {
    private CryptoRepository repository;
    private LiveData<List<CryptoEntity>> allCryptos;

    public CryptoViewModel(Application application) {
        super(application);
        repository = new CryptoRepository(application);
        allCryptos = repository.getAllCryptos();
    }

    public LiveData<List<CryptoEntity>> getAllCryptos() {
        return allCryptos;
    }

    public void fetchAndStoreCryptos() {
        repository.fetchAndStoreCryptos();
    }
}
