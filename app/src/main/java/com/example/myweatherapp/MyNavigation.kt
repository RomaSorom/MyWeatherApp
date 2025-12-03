package com.example.myweatherapp

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myweatherapp.currentScr.views.CurrentWeatherScr
import com.example.myweatherapp.forecastScr.views.ForecastScr

@Composable
fun MyNavigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController,
            startDestination = "current") {
        composable(route = "current") {
            CurrentWeatherScr(navController = navController)
        }
        composable(route = "forecast") {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                ForecastScr(paddingValues = innerPadding,
                    navController = navController)
            }
        }
    }
}