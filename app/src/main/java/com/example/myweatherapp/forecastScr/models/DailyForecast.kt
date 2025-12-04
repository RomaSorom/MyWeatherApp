package com.example.myweatherapp.forecastScr.models

import com.google.gson.annotations.SerializedName

data class DailyForecast(
    @SerializedName(value = "dt")
    val dataTime: Long,
    val temp: DailyTemp,
    @SerializedName(value = "weather")
    val icon: List<WeatherIcon>
)