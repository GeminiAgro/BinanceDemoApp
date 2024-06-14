package com.hristiyang.binance.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.hristiyang.binance.models.CryptoEntity;


@Database(entities = {CryptoEntity.class}, version = 1, exportSchema = false)
public abstract class CryptoDatabase extends RoomDatabase {

    public abstract CryptoDao cryptoDao();

    private static volatile CryptoDatabase INSTANCE;

    public static CryptoDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CryptoDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    CryptoDatabase.class, "crypto_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}