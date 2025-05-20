package com.example.secondproject

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinGeckoApi {
    @GET("simple/price")
    suspend fun getBitcoinPrice(
        @Query("ids") ids: String = "bitcoin",
        @Query("vs_currencies") currency: String = "usd"
    ): Response<BitcoinPriceResponse>
}
//https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=usd