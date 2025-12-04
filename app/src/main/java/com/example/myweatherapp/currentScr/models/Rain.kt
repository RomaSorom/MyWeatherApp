package com.example.myweatherapp.currentScr.models

import com.google.gson.annotations.SerializedName

data class Rain(
    @SerializedName(value = "1h")
    val h1: Float
)