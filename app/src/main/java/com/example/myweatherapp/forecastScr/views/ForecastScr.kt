package com.example.myweatherapp.forecastScr.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myweatherapp.ui.theme.MyWeatherAppTheme
import com.example.myweatherapp.R
import com.example.myweatherapp.forecastScr.ForecastVM
import com.example.myweatherapp.forecastScr.models.Forecast
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun ForecastScr(modifier: Modifier = Modifier,
                paddingValues: PaddingValues,
                navController: NavHostController,
                forecastVM: ForecastVM = viewModel()
) {
    val forecast: State<Forecast?> = forecastVM.forecast.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(contentPadding = paddingValues) {
            items(count = forecast.value?.forecastList?.size ?: 16) { item ->
//                DayForecast(modifier = Modifier.padding(vertical = 6.dp, horizontal = 20.dp),
//                            weekDay = "Tue",
//                            monthNum = 9,
//                            weatherIcon = R.drawable.cloudy,
//                            minTemp = 14,
//                            maxTemp = 21,
//                            proportion = 3f to 7f
//                )
                val dayAndNum: Pair<String?, String?> = forecastVM.getDayAndNum(item)
                DayForecast(modifier = Modifier.padding(vertical = 6.dp, horizontal = 20.dp),
                    weekDay = dayAndNum.first,
                    monthNum = dayAndNum.second?.toInt(),
                    weatherIcon = forecast.value?.forecastList[item]?.icon[0]?.icon?.iconId,
                    minTemp = forecast.value?.forecastList[item]?.temp?.min?.toInt(),
                    maxTemp = forecast.value?.forecastList[item]?.temp?.max?.toInt(),
                    proportion = forecastVM.getProportion(i = item)
                )
            }
        }
    }
}

@Preview
@Composable
fun ForecastScrPreview() {
    val navController = rememberNavController()
    MyWeatherAppTheme {
        ForecastScr(paddingValues = PaddingValues(vertical = 20.dp),
                    navController = navController)
    }
}