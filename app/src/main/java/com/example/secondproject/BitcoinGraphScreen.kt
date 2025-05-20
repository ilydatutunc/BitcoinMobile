package com.example.secondproject

import android.graphics.Color
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.text
import androidx.compose.ui.viewinterop.AndroidView
// Bu doğru import, global viewModel() fonksiyonu için
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

@Composable
fun BitcoinGraphScreen(
    // Parametre adını değiştirin, örneğin 'bitcoinVM' veya 'graphViewModel'
    bitcoinVM: BitcoinViewModel = viewModel() // Şimdi buradaki viewModel() global olanı çağırır
) {
    val context = LocalContext.current
    // 'bitcoinVM' parametresini kullanın
    val priceHistory by bitcoinVM.priceList.collectAsState()

    AndroidView(
        factory = {
            LineChart(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    600
                )
                description.text = "Bitcoin (BTCTRY)"
                setTouchEnabled(true)
                setPinchZoom(true)
            }
        },
        update = { chart ->
            val entries = priceHistory.mapIndexed { index, price ->
                Entry(index.toFloat(), price.toFloat())
            }

            val dataSet = LineDataSet(entries, "BTC Fiyatı").apply {
                color = Color.BLUE
                valueTextColor = Color.BLACK
                lineWidth = 2f
                setDrawCircles(false)
            }

            chart.data = LineData(dataSet)
            chart.invalidate()
        }
    )
}