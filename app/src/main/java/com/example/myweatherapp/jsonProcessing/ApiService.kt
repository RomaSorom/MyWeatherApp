package com.example.myweatherapp.jsonProcessing

import com.example.myweatherapp.currentScr.models.CurrentWeather
import com.example.myweatherapp.doNotPush.key
import com.example.myweatherapp.forecastScr.models.Forecast
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET(value = "weather")
    suspend fun getCurrentWeather(@Query(value = "lat") lat: Float,
                                  @Query(value = "lon") lon: Float,
                                  @Query(value = "appid") appid: String = key): Response<CurrentWeather>

    @GET(value = "forecast/daily")
    suspend fun getForecast(@Query(value = "lat") lat: Float,
                            @Query(value = "lon") lon: Float,
                            @Query(value = "appid") appid: String = key): Response<Forecast>
}