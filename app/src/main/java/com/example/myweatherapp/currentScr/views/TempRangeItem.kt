package com.example.myweatherapp.currentScr.views

import android.text.Layout
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myweatherapp.forecastScr.views.Placeholder
import com.example.myweatherapp.ui.theme.MyWeatherAppTheme

@Composable
fun TempRangeItem(tempLabel: String,
                  temp: Int?) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = tempLabel,
             style = MaterialTheme.typography.bodySmall)
        if (temp != null) {
            Text(text = "$temp°",
                style = MaterialTheme.typography.headlineLarge)
        } else {
            Placeholder(modifier = Modifier.width(width = 47.dp)
                        .height(height = 40.dp))
        }
    }
}

@Preview
@Composable
fun TempRangeItemPreview() {
    MyWeatherAppTheme {
        TempRangeItem("min", null)
    }
}