package com.example.myweatherapp.forecastScr.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myweatherapp.ui.theme.MyWeatherAppTheme

@Composable
fun DateColumn(weekDay: String?,
               monthNum: Int?) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        if (weekDay != null) {
            Text(text = weekDay,
                style = MaterialTheme.typography.headlineSmall)
        } else {
            Placeholder(modifier = Modifier.height(height = 32.dp)
                        .width(width = 39.dp)
                        .padding(bottom = 2.dp))
        }
        if (monthNum != null) {
            Text(text = "$monthNum",
                 style = MaterialTheme.typography.headlineSmall)
        } else {
            Placeholder(modifier = Modifier.height(height = 32.dp)
                        .width(width = 39.dp)
                        .padding(top = 2.dp))
        }
    }
}

@Preview
@Composable
fun DataColumnPreview() {
    MyWeatherAppTheme {
        DateColumn(null, null)
    }
}