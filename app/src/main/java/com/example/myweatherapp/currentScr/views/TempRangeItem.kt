package com.example.myweatherapp.currentScr.views

import android.text.Layout
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.myweatherapp.ui.theme.MyWeatherAppTheme

@Composable
fun TempRangeItem(tempLabel: String,
                  temp: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = tempLabel,
             style = MaterialTheme.typography.bodySmall)
        Text(text = "$temp°",
             style = MaterialTheme.typography.headlineLarge)
    }
}

@Preview
@Composable
fun TempRangeItemPreview() {
    MyWeatherAppTheme {
        TempRangeItem("min", 12)
    }
}