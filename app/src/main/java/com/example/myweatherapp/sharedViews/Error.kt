package com.example.myweatherapp.sharedViews

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myweatherapp.R
import com.example.myweatherapp.ui.theme.MyWeatherAppTheme

@Composable
fun Error(modifier: Modifier = Modifier,
          onClick: () -> Unit) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.error),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(height = 10.dp))
        Text(text = "Something went wrong...")
        Spacer(modifier = Modifier.height(height = 10.dp))
        Button(onClick = onClick) {
            Text(text = "Retry")
        }
    }
}

@Preview
@Composable
fun ErrorPreview() {
    MyWeatherAppTheme {
        Error() {

        }
    }
}