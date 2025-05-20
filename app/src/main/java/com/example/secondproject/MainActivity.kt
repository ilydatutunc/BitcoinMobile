package com.example.secondproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
                    BitcoinPriceScreen(viewModel)
                }
            }
        }
    }
}
@Composable
fun BitcoinPriceScreen(viewModel: BitcoinViewModel) {
    val price by viewModel.price.collectAsState()

    Surface {
        Text(
            text = "Bitcoin Fiyatı: $price",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}
