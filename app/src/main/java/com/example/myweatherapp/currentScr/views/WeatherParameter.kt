package com.example.myweatherapp.currentScr.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myweatherapp.forecastScr.views.Placeholder
import com.example.myweatherapp.ui.theme.MyWeatherAppTheme

@Composable
fun WeatherParameter(parameterName: String,
                     parameterValue: String?,
                     modifier: Modifier = Modifier,
                     parameterUnit: String? = null) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
           modifier = modifier) {
        Text(text = parameterName,
             style = MaterialTheme.typography.bodySmall)
        Spacer(modifier = Modifier.height(height = 5.dp))
        if (parameterValue != null) {
            Text(text = if (parameterUnit != null) "$parameterValue $parameterUnit" else parameterValue,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.W500)
        } else {
            Placeholder(modifier = Modifier.width(width = 35.dp)
                        .height(height = 18.dp))
        }
    }
}

@Preview
@Composable
fun WeatherParameterPreview() {
    MyWeatherAppTheme {
        Surface {
            WeatherParameter(parameterValue = null,
                             parameterName = "Pressure",
                             parameterUnit = "hPa",
                             modifier = Modifier.padding(20.dp))
        }
    }
}