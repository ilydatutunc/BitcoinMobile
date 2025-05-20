package com.example.secondproject

data class TickerResponse(
    val data: List<Ticker>
)

data class Ticker(
    val pair: String,
    val last: Double
)
