package com.example.myweatherapp.currentScr.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myweatherapp.ui.theme.MyWeatherAppTheme

@Composable
fun TempRange(tempMin: Int,
              tempMax: Int,
              modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth()
        .height(intrinsicSize = IntrinsicSize.Min),
        horizontalArrangement = Arrangement.SpaceEvenly) {
        TempRangeItem(tempLabel = "min",
                      temp = tempMin)
        VerticalDivider(color = MaterialTheme.colorScheme.outlineVariant,
                        modifier = Modifier.padding(vertical = 5.dp))
        TempRangeItem(tempLabel = "max",
                      temp = tempMax)
    }
}

@Preview()
@Composable
fun TempRangePreview() {
    MyWeatherAppTheme {
        Surface {
            TempRange(12, 19, Modifier.padding(20.dp))
        }
    }
}