package com.hristiyang.binance.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hristiyang.binance.models.CryptoEntity;
import com.hristiyang.binance.R;

import java.util.List;

public class CryptoAdapter extends RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder> {
    private List<CryptoEntity> cryptos;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(CryptoEntity crypto);
    }

    public CryptoAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public CryptoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_crypto, parent, false);
        return new CryptoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CryptoViewHolder holder, int position) {
        if (cryptos != null) {
            CryptoEntity current = cryptos.get(position);
            holder.bind(current, listener);
        }
    }

    @Override
    public int getItemCount() {
        if (cryptos != null) {
            return cryptos.size();
        } else {
            return 0;
        }
    }

    public void setCryptos(List<CryptoEntity> cryptos) {
        this.cryptos = cryptos;
        notifyDataSetChanged();
    }

    static class CryptoViewHolder extends RecyclerView.ViewHolder {

        private final TextView symbol;
        private final TextView priceChangePercent;
        private final TextView bidAskPrice;

        public CryptoViewHolder(@NonNull View itemView) {
            super(itemView);
            symbol = itemView.findViewById(R.id.symbol);
            priceChangePercent = itemView.findViewById(R.id.priceChangePercent);
            bidAskPrice = itemView.findViewById(R.id.bidAskPrice);
        }

        public void bind(CryptoEntity crypto, OnItemClickListener onItemClickListener) {
            symbol.setText(crypto.symbol + " (" + crypto.priceChangePercent + "%)");
            bidAskPrice.setText("bid/ask: " + crypto.bidPrice + "/" + crypto.askPrice);
            itemView.setOnClickListener(v -> onItemClickListener.onItemClick(crypto));
        }
    }
}

