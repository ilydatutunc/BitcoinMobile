package com.example.secondproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BitcoinViewModel : ViewModel() {

    private val _priceList = MutableStateFlow<List<Double>>(emptyList())
    val priceList: StateFlow<List<Double>> = _priceList

    private val api: BtcturkApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.btcturk.com/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(BtcturkApi::class.java)

        startPriceUpdates()
    }

    private fun startPriceUpdates() {
        viewModelScope.launch {
            while (true) {
                try {
                    val response = api.getTicker()
                    if (response.isSuccessful) {
                        val bitcoinTicker = response.body()?.data?.find { it.pair == "BTCTRY" }
                        bitcoinTicker?.let {
                            val currentPrices = _priceList.value.toMutableList()
                            currentPrices.add(it.last)
                            if (currentPrices.size > 10) {
                                currentPrices.removeAt(0)  // Sadece son 10 fiyatı tut
                            }
                            _priceList.value = currentPrices
                        }
                    }
                } catch (e: Exception) {
                    // Hata durumunda istersen log yazabilirsin
                }
                delay(10000) // 10 saniyede bir yenile
            }
        }
    }
}
