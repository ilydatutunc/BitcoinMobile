package com.example.secondproject

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BtcturkService {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.btcturk.com/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: BtcturkApi = retrofit.create(BtcturkApi::class.java)
}
