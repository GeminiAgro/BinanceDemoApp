package com.hristiyang.binance.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hristiyang.binance.adapters.CryptoAdapter;
import com.hristiyang.binance.models.CryptoEntity;
import com.hristiyang.binance.viewmodel.CryptoViewModel;
import com.hristiyang.binance.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CryptoViewModel cryptoViewModel;
    private ActivityMainBinding binding;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RecyclerView recyclerView = binding.recyclerView;
        final CryptoAdapter adapter = new CryptoAdapter(crypto -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("crypto", crypto);
            startActivity(intent);
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressBar = binding.progressBar;

        cryptoViewModel = new ViewModelProvider(this).get(CryptoViewModel.class);
        cryptoViewModel.getAllCryptos().observe(this, new Observer<List<CryptoEntity>>() {
            @Override
            public void onChanged(List<CryptoEntity> cryptos) {
                Log.d("MainActivity", "Cryptos observed: " + (cryptos != null ? cryptos.size() : 0));
                adapter.setCryptos(cryptos);
                progressBar.setVisibility(View.GONE);
            }
        });

        // Show the progress bar before fetching data
        progressBar.setVisibility(View.VISIBLE);
        cryptoViewModel.fetchAndStoreCryptos();

        binding.swipeRefreshLayout.setOnRefreshListener(() -> {
            cryptoViewModel.fetchAndStoreCryptos();
            binding.swipeRefreshLayout.setRefreshing(false);
        });
    }
}
