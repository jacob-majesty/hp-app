package com.majesty.hpapp.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://hp-api.onrender.com/api/" // URL da API com a parte '/api/'
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiService: HpApiService by lazy {
        retrofit.create(HpApiService::class.java)
    }
}