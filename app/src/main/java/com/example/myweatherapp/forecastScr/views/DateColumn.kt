package com.example.myweatherapp.forecastScr.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.myweatherapp.ui.theme.MyWeatherAppTheme

@Composable
fun DateColumn(weekDay: String,
               monthNum: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = weekDay,
            style = MaterialTheme.typography.headlineSmall)
        Text(text = "$monthNum",
            style = MaterialTheme.typography.headlineSmall)
    }
}

@Preview
@Composable
fun DataColumnPreview() {
    MyWeatherAppTheme {
        DateColumn("Tue", 12)
    }
}