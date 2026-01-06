package com.example.myweatherapp.forecastScr

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myweatherapp.forecastScr.models.Forecast
import com.example.myweatherapp.jsonProcessing.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ForecastVM : ViewModel() {
    private val _forecast: MutableStateFlow<Forecast?> = MutableStateFlow(value = null)
    val forecast: StateFlow<Forecast?> = _forecast

    init {
        getForecast()
    }

    fun getForecast() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getForecast(lat = 44.34f, lon = 10.99f)
                if (response.isSuccessful && response.body() != null) {
                    println("Forecast: ${response.body()}")
                    _forecast.value = response.body()
                }
            } catch (e: Exception) {
                println("Json processing error: ${e.message}")
            }
        }
    }

    fun getDayAndNum(i: Int): Pair<String?, String?> {
        val dateTp: Long? = _forecast.value?.forecastList[i]?.dataTime
        if (dateTp == null) {
            return null to null
        } else {
            val dateTpInSec = dateTp * 1000L
            val date: Date = Date(dateTpInSec)
            val dayFormatter: SimpleDateFormat = SimpleDateFormat("EEE", Locale.getDefault())
            val numFormatter: SimpleDateFormat = SimpleDateFormat("dd", Locale.getDefault())
            return dayFormatter.format(date) to numFormatter.format(date)
        }
    }

    fun getProportion(i: Int): Pair<Float, Float>? {
        val curr: Float? = _forecast.value?.forecastList[i]?.temp?.day
        val min: Float? = _forecast.value?.forecastList[i]?.temp?.min
        val max: Float? = _forecast.value?.forecastList[i]?.temp?.max
        return if (curr == null || min == null || max == null) {
            null
        } else {
            (curr - min) to (max - curr)
        }
    }
}