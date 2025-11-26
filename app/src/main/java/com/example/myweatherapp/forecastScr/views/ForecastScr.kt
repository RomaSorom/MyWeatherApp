package com.example.myweatherapp.forecastScr.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myweatherapp.ui.theme.MyWeatherAppTheme
import com.example.myweatherapp.R

@Composable
fun ForecastScr(modifier: Modifier = Modifier,
                paddingValues: PaddingValues) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(contentPadding = paddingValues) {
            items(9) { item ->
                DayForecast(modifier = Modifier.padding(vertical = 6.dp, horizontal = 20.dp),
                            weekDay = "Tue",
                            monthNum = 9,
                            weatherIcon = R.drawable.cloudy,
                            minTemp = 14,
                            maxTemp = 21,
                            proportion = 3f to 7f
                )
            }
        }
    }
}

@Preview
@Composable
fun ForecastScrPreview() {
    MyWeatherAppTheme {
        ForecastScr(paddingValues = PaddingValues(vertical = 20.dp))
    }
}