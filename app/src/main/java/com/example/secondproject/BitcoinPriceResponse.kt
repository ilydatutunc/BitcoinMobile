package com.example.secondproject

data class BitcoinPriceResponse(
    val bitcoin: Bitcoin
)

data class Bitcoin(
    val usd: Double
)
