package com.example.myweatherapp.currentScr.models

import com.google.gson.annotations.SerializedName

data class Parameters(
    val temp: Float,
    @SerializedName(value = "temp_min")
    val tempMin: Float,
    @SerializedName(value = "temp_max")
    val tempMax: Float,
    val pressure: Int,
    val humidity: Int
)