package com.example.myweatherapp.forecastScr.views

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myweatherapp.ui.theme.MyWeatherAppTheme

@Composable
fun Placeholder(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(initialValue = MaterialTheme.colorScheme.primary,
                                                 targetValue = MaterialTheme.colorScheme.secondary,
                                                 animationSpec = infiniteRepeatable(animation = tween(durationMillis = 1000),
                                                                                    repeatMode = RepeatMode.Reverse)
    )
    Box(modifier = modifier
        .clip(shape = RoundedCornerShape(size = 2.dp))
        .background(color = color))
}

@Preview
@Composable
fun PlaceholderPreview() {
    MyWeatherAppTheme {
        Placeholder(modifier = Modifier.height(height = 10.dp)
            .width(width = 50.dp))
    }
}