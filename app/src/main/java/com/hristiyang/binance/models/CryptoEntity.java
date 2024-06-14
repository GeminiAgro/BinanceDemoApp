package com.hristiyang.binance.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cryptos")
public class CryptoEntity implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String symbol;
    public String priceChange;
    public String priceChangePercent;
    public String weightedAvgPrice;
    public String prevClosePrice;
    public String lastPrice;
    public String lastQty;
    public String bidPrice;
    public String bidQty;
    public String askPrice;
    public String askQty;
    public String openPrice;
    public String highPrice;
    public String lowPrice;
    public String volume;
    public String quoteVolume;
    public long openTime;
    public long closeTime;
    public long firstId;
    public long lastId;
    public long count;

    public CryptoEntity() {
        // Default constructor
    }

    protected CryptoEntity(Parcel in) {
        id = in.readInt();
        symbol = in.readString();
        priceChange = in.readString();
        priceChangePercent = in.readString();
        weightedAvgPrice = in.readString();
        prevClosePrice = in.readString();
        lastPrice = in.readString();
        lastQty = in.readString();
        bidPrice = in.readString();
        bidQty = in.readString();
        askPrice = in.readString();
        askQty = in.readString();
        openPrice = in.readString();
        highPrice = in.readString();
        lowPrice = in.readString();
        volume = in.readString();
        quoteVolume = in.readString();
        openTime = in.readLong();
        closeTime = in.readLong();
        firstId = in.readLong();
        lastId = in.readLong();
        count = in.readLong();
    }

    public static final Creator<CryptoEntity> CREATOR = new Creator<CryptoEntity>() {
        @Override
        public CryptoEntity createFromParcel(Parcel in) {
            return new CryptoEntity(in);
        }

        @Override
        public CryptoEntity[] newArray(int size) {
            return new CryptoEntity[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(symbol);
        dest.writeString(priceChange);
        dest.writeString(priceChangePercent);
        dest.writeString(weightedAvgPrice);
        dest.writeString(prevClosePrice);
        dest.writeString(lastPrice);
        dest.writeString(lastQty);
        dest.writeString(bidPrice);
        dest.writeString(bidQty);
        dest.writeString(askPrice);
        dest.writeString(askQty);
        dest.writeString(openPrice);
        dest.writeString(highPrice);
        dest.writeString(lowPrice);
        dest.writeString(volume);
        dest.writeString(quoteVolume);
        dest.writeLong(openTime);
        dest.writeLong(closeTime);
        dest.writeLong(firstId);
        dest.writeLong(lastId);
        dest.writeLong(count);
    }
}
