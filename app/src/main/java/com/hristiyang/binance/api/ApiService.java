package com.hristiyang.binance.api;



import com.hristiyang.binance.models.CryptoEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("api/v3/ticker/24hr")
    Call<List<CryptoEntity>> getCryptos();
}