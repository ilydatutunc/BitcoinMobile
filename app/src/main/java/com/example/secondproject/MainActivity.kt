package com.example.secondproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.secondproject.ui.theme.SecondProjectTheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<BitcoinViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BitcoinGraphScreen(viewModel)
                }
            }
        }
    }
}

@Composable
fun BitcoinPriceListScreen(viewModel: BitcoinViewModel) {
    val prices = viewModel.priceList.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Bitcoin Fiyatları (Son 10 saniye)",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        prices.forEach { price ->
            Text(text = "$price ₺", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
