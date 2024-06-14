package com.hristiyang.binance.activities;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.hristiyang.binance.models.CryptoEntity;
import com.hristiyang.binance.databinding.ActivityCryptoDetailBinding;

public class DetailActivity extends AppCompatActivity {
    private ActivityCryptoDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCryptoDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CryptoEntity crypto = getIntent().getParcelableExtra("crypto");
        if (crypto != null) {
            bindDetails(crypto);
        }
    }

    private void bindDetails(CryptoEntity crypto) {
        binding.detailSymbol.setText("Symbol: " + crypto.symbol);
        binding.detailPriceChange.setText("Price Change: " + crypto.priceChange);
        binding.detailPriceChangePercent.setText("Price Change Percent: " +crypto.priceChangePercent);
        binding.detailWeightedAvgPrice.setText("Weighted Avg Price: " +crypto.weightedAvgPrice);
        binding.detailPrevClosePrice.setText("Prev Close Price: " +crypto.prevClosePrice);
        binding.detailLastPrice.setText("Last Price: " +crypto.lastPrice);
        binding.detailLastQty.setText("Last Qty: " +crypto.lastQty);
        binding.detailBidPrice.setText("Bid Price: " +crypto.bidPrice);
        binding.detailBidQty.setText("Bid Qty: " +crypto.bidQty);
        binding.detailAskPrice.setText("Ask Price: " +crypto.askPrice);
        binding.detailAskQty.setText("Ask Qty: " +crypto.askQty);
        binding.detailOpenPrice.setText("Open Price: " +crypto.openPrice);
        binding.detailHighPrice.setText("High Price: " +crypto.highPrice);
        binding.detailLowPrice.setText("Low Price: " +crypto.lowPrice);
        binding.detailVolume.setText("Volume: " +crypto.volume);
        binding.detailQuoteVolume.setText("Quote Volume: " +crypto.quoteVolume);
        binding.detailOpenTime.setText("Open Time: " +String.valueOf(crypto.openTime));
        binding.detailCloseTime.setText("Close Time: " +String.valueOf(crypto.closeTime));
        binding.detailFirstId.setText("FirstId: " +String.valueOf(crypto.firstId));
        binding.detailLastId.setText("LastId: " +String.valueOf(crypto.lastId));
        binding.detailCount.setText("Count: " +String.valueOf(crypto.count));
    }
}
