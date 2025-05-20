package com.example.secondproject

import retrofit2.Response
import retrofit2.http.GET

interface BtcturkApi {
    @GET("ticker")
    suspend fun getTicker(): Response<TickerResponse>
}
