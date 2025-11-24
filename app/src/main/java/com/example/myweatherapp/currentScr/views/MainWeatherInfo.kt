package com.example.myweatherapp.currentScr.views

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import com.example.myweatherapp.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myweatherapp.ui.theme.MyWeatherAppTheme

@Composable
fun MainWeatherInfo(@DrawableRes weatherTypeIcon: Int,
                    temp: Int,
                    weatherTypeName: String,
                    modifier: Modifier = Modifier) {
    Column(modifier = modifier,
           horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = weatherTypeIcon),
              contentDescription = null)
        Spacer(modifier = Modifier.height(height = 20.dp))
        Text(text = "$temp°",
             style = MaterialTheme.typography.displayLarge)
        Spacer(modifier = Modifier.height(height = 10.dp))
        Text(text = weatherTypeName,
             style = MaterialTheme.typography.titleLarge)
    }
}

@Preview
@Composable
fun MainWeatherInfoPreview() {
    MyWeatherAppTheme {
        MainWeatherInfo(weatherTypeIcon = R.drawable.cloudy,
                        temp = 12,
                        weatherTypeName = "Cloudy")
    }
}