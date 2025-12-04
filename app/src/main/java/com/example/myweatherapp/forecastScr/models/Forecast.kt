package com.example.myweatherapp.forecastScr.models

import com.google.gson.annotations.SerializedName

data class Forecast(
    @SerializedName(value = "list")
    val forecastList: List<DailyForecast>
)