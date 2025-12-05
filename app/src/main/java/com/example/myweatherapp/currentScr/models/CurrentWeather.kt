package com.example.myweatherapp.currentScr.models

import com.google.gson.annotations.SerializedName

data class CurrentWeather(
    @SerializedName(value = "weather")
    val mainInfoList: List<MainInfo>,
    @SerializedName(value = "main")
    val parameters: Parameters,
    val wind: Wind,
    val rain: Rain?,
    val clouds: Clouds,
    @SerializedName(value = "sys")
    val sun: Sun
)