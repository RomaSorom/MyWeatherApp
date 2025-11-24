package com.example.myweatherapp.currentScr.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myweatherapp.ui.theme.MyWeatherAppTheme
import com.example.myweatherapp.R

@Composable
fun CurrentWeatherScr(modifier: Modifier = Modifier) {
    val backColors: List<Color> = listOf(Color(color = 0xFF57D2FF),
                                        Color(color = 0xFFFFFFFF))
    Box(modifier = Modifier.fillMaxSize()
        .background(brush = Brush.verticalGradient(colors = backColors))) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            MainWeatherInfo(weatherTypeIcon = R.drawable.cloudy,
                            temp = 12,
                            weatherTypeName = "Cloudy",
                            modifier = Modifier.padding(top = 108.dp))
            Spacer(modifier = Modifier.height(height = 20.dp))
            Surface(shape = MaterialTheme.shapes.large,
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 18.dp)
                        .height(height = 480.dp)) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    TempRange(tempMin = 11,
                              tempMax = 15,
                              modifier = Modifier.padding(horizontal = 30.dp)
                                  .padding(top = 25.dp))
                    HorizontalDivider(modifier = Modifier.padding(horizontal = 30.dp))
                    Spacer(modifier = Modifier.height(height = 25.dp))
                    InfoRow(column1 = { WeatherParameter(parameterName = "Pressure",
                                                         parameterValue = "1031",
                                                         parameterUnit = "hPa") },
                            column2 = { WeatherParameter(parameterName = "Humidity",
                                                         parameterValue = "74",
                                                         parameterUnit = "%") },
                            backColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
                            modifier = Modifier.padding(horizontal = 30.dp))
                    Spacer(modifier = Modifier.height(height = 20.dp))
                    InfoRow(column1 = { WeatherParameter(parameterName = "Pressure",
                                                         parameterValue = "1031",
                                                         parameterUnit = "hPa") },
                            column2 = { WeatherParameter(parameterName = "Humidity",
                                                         parameterValue = "74",
                                                         parameterUnit = "%") },
                            backColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
                            modifier = Modifier.padding(horizontal = 30.dp))
                    Spacer(modifier = Modifier.height(height = 20.dp))
                    InfoRow(column1 = { WeatherParameter(parameterName = "Pressure",
                                                         parameterValue = "1031",
                                                         parameterUnit = "hPa") },
                            column2 = { WeatherParameter(parameterName = "Humidity",
                                                         parameterValue = "74",
                                                         parameterUnit = "%") },
                            backColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                            modifier = Modifier.padding(horizontal = 30.dp))
                    Spacer(modifier = Modifier.height(height = 30.dp))
                    ForecastButton()
                }
            }
        }
    }
}

@Preview()
@Composable
fun CurrentWeatherScrPreview() {
    MyWeatherAppTheme {
        CurrentWeatherScr()
    }
}