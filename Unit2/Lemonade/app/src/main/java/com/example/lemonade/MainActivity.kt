package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}

@Composable
fun LemonApp() {
    // Current step the app is displaying (remember allows the state to be retained
    // across recompositions).
    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }
    var squeezeLimit = (2..4).random()

    // A surface container using the 'background' color from the theme
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        when (currentStep) {

            1 -> {
                Image(
                    painter = painterResource(id = R.drawable.lemon_tree),
                    contentDescription = "Lemon tree",
                    modifier = Modifier
                        .clip(RoundedCornerShape(40.dp))
                        .clickable { currentStep = 2 }
                        .size(200.dp)
                        .background(Color(0xFFC3ECD2))
                )
                Text(
                    text = "Tap the lemon tree to pick a lemon",
                    modifier = Modifier.padding(16.dp)
                )
            }
            2 -> {
                Image(
                    painter = painterResource(id = R.drawable.lemon_squeeze),
                    contentDescription = "Squeezing lemon",
                    modifier = Modifier
                        .clip(RoundedCornerShape(40.dp))
                        .clickable {
                            squeezeCount++
                            if (squeezeCount == squeezeLimit) {
                                currentStep = 3
                                squeezeCount = 0
                            }
                        }
                        .size(200.dp)
                        .background(Color(0xFFC3ECD2))
                )
                Text(
                    text = "Keep tapping the lemon to squeeze it",
                    modifier = Modifier.padding(16.dp)
                )
            }
            3 -> {
                Image(
                    painter = painterResource(id = R.drawable.lemon_drink),
                    contentDescription = "Glass of lemonade",
                    modifier = Modifier
                        .clip(RoundedCornerShape(40.dp))
                        .clickable { currentStep = 4 }
                        .size(200.dp)
                        .background(Color(0xFFC3ECD2))
                )
                Text(
                    text = "Tap the lemonade to drink it",
                    modifier = Modifier.padding(16.dp)
                )
            }
            4 -> {
                Image(
                    painter = painterResource(id = R.drawable.lemon_restart),
                    contentDescription = "Empty glass",
                    modifier = Modifier
                        .clip(RoundedCornerShape(40.dp))
                        .clickable { currentStep = 1 }
                        .size(200.dp)
                        .background(Color(0xFFC3ECD2))
                )
                Text(
                    text = "Tap the empty glass to start again",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}