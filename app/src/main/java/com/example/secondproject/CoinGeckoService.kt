package com.example.secondproject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CoinGeckoService {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.coingecko.com/api/v3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: CoinGeckoApi = retrofit.create(CoinGeckoApi::class.java)
}
