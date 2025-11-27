package com.example.myweatherapp.forecastScr.views

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myweatherapp.ui.theme.MyWeatherAppTheme
import com.example.myweatherapp.R

@Composable
fun DayForecast(weekDay: String?,
                monthNum: Int?,
                @DrawableRes weatherIcon: Int?,
                minTemp: Int?,
                maxTemp: Int?,
                proportion: Pair<Float, Float>?,
                modifier: Modifier = Modifier) {
    Surface(color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
            shape = MaterialTheme.shapes.large,
            modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth()
            .padding(all = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            DateColumn(weekDay = weekDay,
                       monthNum = monthNum)
            if (weatherIcon != null) {
                Image(painter = painterResource(id = weatherIcon),
                      contentDescription = null)
            } else {
                Placeholder(modifier = Modifier.height(height = 48.dp)
                            .width(width = 57.dp))
            }
            CurrentTempBar(proportion = proportion)
            if (minTemp == null || maxTemp == null) {
                Placeholder(modifier = Modifier.height(height = 36.dp)
                            .width(width = 80.dp))
            } else {
                Text(text = "$minTemp-$maxTemp°",
                     style = MaterialTheme.typography.headlineMedium)
            }
        }
    }
}

@Preview
@Composable
fun DayForecastPreview() {
    MyWeatherAppTheme {
        DayForecast(null, null, null, null, 10, proportion = null)
    }
}