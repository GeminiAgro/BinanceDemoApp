package com.hristiyang.binance.db;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.hristiyang.binance.models.CryptoEntity;

import java.util.List;

@Dao
public interface CryptoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCryptos(List<CryptoEntity> cryptos);

    @Query("SELECT * FROM cryptos")
    LiveData<List<CryptoEntity>> getAllCryptos();



}
