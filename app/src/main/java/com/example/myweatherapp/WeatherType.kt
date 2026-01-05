package com.example.myweatherapp

import com.google.gson.annotations.SerializedName

enum class WeatherType(val iconId: Int) {
    @SerializedName(value = "01d", alternate = ["01n"]) CLEAR_SKY(iconId = R.drawable.i01d),
    @SerializedName(value = "02d", alternate = ["02n"]) FEW_CLOUDS(iconId = R.drawable.i02d),
    @SerializedName(value = "03d", alternate = ["03n"]) SCATTERED_CLOUDS(iconId = R.drawable.i03d),
    @SerializedName(value = "04d", alternate = ["04n"]) BROKEN_CLOUDS(iconId = R.drawable.i04d),
    @SerializedName(value = "09d", alternate = ["09n"]) SHOWER_RAIN(iconId = R.drawable.i09d),
    @SerializedName(value = "10d", alternate = ["10n"]) RAIN(iconId = R.drawable.i10d),
    @SerializedName(value = "11d", alternate = ["11n"]) THUNDERSTORM(iconId = R.drawable.i11d),
    @SerializedName(value = "13d", alternate = ["13n"]) SNOW(iconId = R.drawable.i13d),
    @SerializedName(value = "50d", alternate = ["50n"]) MIST(iconId = R.drawable.i50d),
}