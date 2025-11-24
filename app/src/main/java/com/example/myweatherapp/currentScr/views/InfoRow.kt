package com.example.myweatherapp.currentScr.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myweatherapp.ui.theme.MyWeatherAppTheme

@Composable
fun InfoRow(column1: @Composable () -> Unit,
            column2: @Composable () -> Unit,
            backColor: Color,
            modifier: Modifier = Modifier
) {
    Surface(shape = MaterialTheme.shapes.large,
            color = backColor,
            modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth()
            .height(intrinsicSize = IntrinsicSize.Min)
            .padding(vertical = 20.dp),
            horizontalArrangement = Arrangement.Center) {
            Box(modifier = Modifier.weight(weight = 1f),
                contentAlignment = Alignment.Center) {
                column1()
            }
            VerticalDivider()
            Box(modifier = Modifier.weight(weight = 1f),
                contentAlignment = Alignment.Center) {
                column2()
            }
        }
    }
}

@Preview
@Composable
fun InfoRowPreview() {
    MyWeatherAppTheme {
        InfoRow(column1 = { WeatherParameter(parameterName = "Pressure",
                                             parameterValue = "1031",
                                             parameterUnit = "hPa") },
                column2 = { WeatherParameter(parameterName = "Humidity",
                                             parameterValue = "75",
                                             parameterUnit = "%") },
                backColor = MaterialTheme.colorScheme.primary,
                modifier = Modifier)
    }
}