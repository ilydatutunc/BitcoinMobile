// BitcoinViewModel.kt
package com.example.secondproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BitcoinViewModel : ViewModel() {

    private val _price = MutableStateFlow<String>("Yükleniyor...")
    val price: StateFlow<String> = _price

    init {
        getPrice()
    }

    private fun getPrice() {
        viewModelScope.launch {
            try {
                val response = CoinGeckoService.api.getBitcoinPrice()
                if (response.isSuccessful) {
                    val body = response.body()
                    val bitcoinPrice = body?.bitcoin?.usd
                    _price.value = "$bitcoinPrice USD"
                } else {
                    _price.value = "Hata: ${response.code()}"
                }
            } catch (e: Exception) {
                _price.value = "Hata: ${e.message}"
            }
        }
    }
}


