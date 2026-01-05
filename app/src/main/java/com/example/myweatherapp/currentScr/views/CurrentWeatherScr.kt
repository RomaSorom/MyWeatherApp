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
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myweatherapp.ui.theme.MyWeatherAppTheme
import com.example.myweatherapp.R
import com.example.myweatherapp.currentScr.CurrentVM
//import com.example.myweatherapp.currentScr.MainWeatherData
import com.example.myweatherapp.currentScr.models.CurrentWeather
import kotlinx.coroutines.flow.StateFlow

@Composable
fun CurrentWeatherScr(navController: NavHostController,
                      modifier: Modifier = Modifier,
                      currentVM: CurrentVM = viewModel()
) {
    val backColors: List<Color> = listOf(Color(color = 0xFF57D2FF),
                                        Color(color = 0xFFFFFFFF))
    val currentWeather: State<CurrentWeather?> = currentVM.currentWeather.collectAsState()

    Box(modifier = Modifier.fillMaxSize()
        .background(brush = Brush.verticalGradient(colors = backColors))) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            MainWeatherInfo(weatherTypeIcon = currentWeather
                                              .value
                                              ?.mainInfoList?.first()
                                              ?.icon
                                              ?.iconId,
                            temp = currentWeather
                                .value
                                ?.parameters
                                ?.temp
                                ?.toInt(),
                            weatherTypeName = currentWeather
                                              .value
                                              ?.mainInfoList?.first()
                                              ?.description,
                            modifier = Modifier.padding(top = 108.dp))
            Spacer(modifier = Modifier.height(height = 20.dp))
            Surface(shape = MaterialTheme.shapes.large,
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 18.dp)
                        .height(height = 480.dp)) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    TempRange(tempMin = currentWeather
                                        .value
                                        ?.parameters
                                        ?.tempMin
                                        ?.toInt(),
                              tempMax = currentWeather
                                        .value
                                        ?.parameters
                                        ?.tempMax
                                        ?.toInt(),
                              modifier = Modifier.padding(horizontal = 30.dp)
                                  .padding(top = 25.dp))
                    HorizontalDivider(modifier = Modifier.padding(horizontal = 30.dp)
                                      .padding(top = 4.dp))
                    Spacer(modifier = Modifier.height(height = 25.dp))
                    InfoRow(column1 = { WeatherParameter(parameterName = "Pressure",
                                                         parameterValue = currentWeather
                                                                          .value
                                                                          ?.parameters
                                                                          ?.pressure
                                                                          ?.toString(),
                                                         parameterUnit = "hPa") },
                            column2 = { WeatherParameter(parameterName = "Humidity",
                                                         parameterValue = currentWeather
                                                                          .value
                                                                          ?.parameters
                                                                          ?.humidity
                                                                          ?.toString(),
                                                         parameterUnit = "%") },
                            backColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
                            modifier = Modifier.padding(horizontal = 30.dp))
                    Spacer(modifier = Modifier.height(height = 20.dp))
                    InfoRow(column1 = { WeatherParameter(parameterName = "Wind",
                                                         parameterValue = currentWeather
                                                             .value
                                                             ?.wind
                                                             ?.speed
                                                             ?.toString(),
                                                         parameterUnit = "m/s") },
                            column2 = { WeatherParameter(parameterName = "Rain (1h)",
                                                         parameterValue = currentWeather
                                                                          .value
                                                                          ?.rain
                                                                          ?.h1
                                                                          ?.toString(),
                                                         parameterUnit = "mm") },
                            backColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
                            modifier = Modifier.padding(horizontal = 30.dp))
                    Spacer(modifier = Modifier.height(height = 20.dp))
                    InfoRow(column1 = { WeatherParameter(parameterName = "Clouds",
                                                         parameterValue = currentWeather
                                                                          .value
                                                                          ?.clouds
                                                                          ?.all
                                                                          ?.toString(),
                                                         parameterUnit = "%") },
                            column2 = { WeatherParameter(parameterName = "Sunrise/Sunset",
                                                         parameterValue = currentVM.getSunParameter()) },
                            backColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                            modifier = Modifier.padding(horizontal = 30.dp))
                    Spacer(modifier = Modifier.height(height = 30.dp))
                    ForecastButton(navController = navController)
                }
            }
        }
    }
}

@Preview()
@Composable
fun CurrentWeatherScrPreview() {
    val navController = rememberNavController()
    MyWeatherAppTheme {
        CurrentWeatherScr(navController = navController)
    }
}