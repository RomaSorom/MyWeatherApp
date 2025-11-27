package com.example.myweatherapp.currentScr.views

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import com.example.myweatherapp.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myweatherapp.forecastScr.views.Placeholder
import com.example.myweatherapp.ui.theme.MyWeatherAppTheme

@Composable
fun MainWeatherInfo(@DrawableRes weatherTypeIcon: Int?,
                    temp: Int?,
                    weatherTypeName: String?,
                    modifier: Modifier = Modifier) {
    Column(modifier = modifier,
           horizontalAlignment = Alignment.CenterHorizontally) {
        if (weatherTypeIcon == null) {
            Placeholder(modifier = Modifier.width(width = 57.dp)
                        .height(height = 48.dp))
        } else {
            Image(painter = painterResource(id = weatherTypeIcon),
                  contentDescription = null)
        }
        Spacer(modifier = Modifier.height(height = 20.dp))
        if (temp == null) {
            Placeholder(modifier = Modifier.width(width = 85.dp)
                        .height(height = 67.dp))
        } else {
            Text(text = "$temp°",
                 style = MaterialTheme.typography.displayLarge)
        }
        Spacer(modifier = Modifier.height(height = 10.dp))
        if (weatherTypeName == null) {
            Placeholder(modifier = Modifier.width(width = 66.dp)
                        .height(height = 28.dp))
        } else {
            Text(text = weatherTypeName,
                 style = MaterialTheme.typography.titleLarge)
        }
    }
}

@Preview
@Composable
fun MainWeatherInfoPreview() {
    MyWeatherAppTheme {
        MainWeatherInfo(weatherTypeIcon = null,
                        temp = null,
                        weatherTypeName = null)
    }
}