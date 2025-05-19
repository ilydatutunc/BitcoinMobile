package com.example.secondproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.secondproject.ui.theme.SecondProjectTheme
import androidx.compose.material3.Button
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SecondProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ilos (modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}



@Composable
fun ilos (modifier: Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Row {
           Image (painterResource(R.drawable.profilephoto), contentDescription = " ")
            Text(modifier = Modifier.padding(horizontal =  32.dp, vertical = 32.dp) , text = "Hello İlos")
            Button(modifier = modifier, onClick = {
                Log.d("Button", "Butona Tıklandı")

            }) {
                Text(text = "Butona Tıkla")

            }

        }

        Text( modifier = Modifier.fillMaxWidth().background(Color.Red) , textAlign = TextAlign.Center, text = "Hello İlos")

        LazyRow( modifier = Modifier.fillMaxSize().background(Color.Blue)) {


        }
    }

}
