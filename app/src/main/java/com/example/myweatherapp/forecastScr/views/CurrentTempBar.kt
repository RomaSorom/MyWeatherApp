package com.example.myweatherapp.forecastScr.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myweatherapp.sharedViews.Placeholder
import com.example.myweatherapp.ui.theme.MyWeatherAppTheme

@Composable
fun CurrentTempBar(modifier: Modifier = Modifier,
                   proportion: Pair<Float, Float>?) {
    if (proportion != null) {
        val gradColors: List<Color> = listOf(Color(color = 0xFF0877FF),
                                             Color(color = 0xFFFF8234))
        Box(modifier = modifier.height(height = 10.dp)
            .width(width = 100.dp)
            .clip(shape = RoundedCornerShape(size = 16.dp))
            .background(brush = Brush.horizontalGradient(colors = gradColors))) {
            Row(modifier = Modifier.fillMaxSize()) {
                if (proportion.first != 0f) Box(modifier = Modifier.weight(weight = proportion.first))
                Box(modifier = Modifier.size(size = 10.dp)
                    .clip(shape = CircleShape)
                    .background(color = Color.White))
                if (proportion.second != 0f) Box(modifier = Modifier.weight(weight = proportion.second))
            }
        }
    } else {
        Placeholder(modifier = Modifier.height(height = 9.dp)
                    .width(width = 100.dp))
    }
}

// before = curr - min
// after = max - curr

@Preview
@Composable
fun CurrentTempBarPreview() {
    MyWeatherAppTheme {
        CurrentTempBar(proportion = null)
    }
}
