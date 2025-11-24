package com.example.myweatherapp.currentScr.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myweatherapp.ui.theme.MyWeatherAppTheme

@Composable
fun ForecastButton(modifier: Modifier = Modifier) {
    Button(onClick = {  },
           modifier = modifier.width(width = 220.dp)
               .height(height = 45.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.weight(weight = 1f))
            Text(text = "Forecast")
            Box(modifier = Modifier.weight(weight = 1f),
                contentAlignment = Alignment.CenterEnd) {
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                     contentDescription = null)
            }
        }
    }
}

@Preview
@Composable
fun ForecastButtonPreview() {
    MyWeatherAppTheme {
        ForecastButton()
    }
}