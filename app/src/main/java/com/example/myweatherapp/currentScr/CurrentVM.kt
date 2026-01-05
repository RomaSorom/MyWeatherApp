package com.example.myweatherapp.currentScr

import android.os.Build
import androidx.annotation.DrawableRes
import androidx.compose.ui.res.painterResource

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myweatherapp.currentScr.models.CurrentWeather
import com.example.myweatherapp.jsonProcessing.RetrofitInstance
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.myweatherapp.R

import java.time.Instant
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class CurrentVM : ViewModel() {
    private val _currentWeather: MutableStateFlow<CurrentWeather?> = MutableStateFlow(value = null)
    val currentWeather: StateFlow<CurrentWeather?> = _currentWeather

    init {
        getCurrentWeather()
    }

    fun getCurrentWeather() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getCurrentWeather(lat = 44.34f, lon = 10.99f)
                if (response.isSuccessful && response.body() != null) {
                    println("Current weather: ${response.body()}")
                    _currentWeather.value = response.body()
                }
            } catch (e: Exception) {
                println("Json processing error: ${e.message}")
            }

        }
    }

    fun getSunParameter(): String? {
        val sunrise: Int? = _currentWeather.value?.sun?.sunrise
        val sunset: Int? = _currentWeather.value?.sun?.sunset
        return if (sunrise == null || sunset == null) {
            null
        } else {
            toRegTimeFormat(timeStamp = sunrise) + "/" + toRegTimeFormat(timeStamp = sunset)
        }
    }

    fun toRegTimeFormat(timeStamp: Int): String {
        val tSInSec = timeStamp * 1000L
        val date: Date = Date(tSInSec.toLong())
        val formatter: SimpleDateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        return formatter.format(date)
    }
}