package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    val artworks = listOf(
        Artwork("Starry Night", "Vincent van Gogh", R.drawable.van_gogh_starry_night),
        Artwork("Mona Lisa", "Leonardo da Vinci", R.drawable.mona_lisa),
        Artwork("Sasuke the Polyhistor", "Reddit", R.drawable.sasuke)
    )

    var currentArtWorkIndex by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Hiển thị hình ảnh
        Image(
            painter = painterResource(id = artworks[currentArtWorkIndex].imageRes),
            contentDescription = artworks[currentArtWorkIndex].title,
            modifier = Modifier
                .size(300.dp)
                .border(2.dp, Color.Gray)
        )

        Spacer(modifier = Modifier.height(80.dp))

        // Hiển thị tiêu đề và tác giả
        Text(text = artworks[currentArtWorkIndex].title, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = "by ${artworks[currentArtWorkIndex].artist}", fontSize = 16.sp)

        Spacer(modifier = Modifier.height(32.dp))

        // Nút điều hướng tác phẩm
        Row {
            Button(onClick = {
                currentArtWorkIndex = (currentArtWorkIndex - 1 + artworks.size) % artworks.size
            }) {
                Text("Previous")
            }

            Spacer(modifier = Modifier.width(10.dp))

            Button(onClick = {
                currentArtWorkIndex = (currentArtWorkIndex + 1) % artworks.size
            }) {
                Text("Next")
            }
        }
    }
}

data class Artwork(val title: String, val artist: String, val imageRes: Int)

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}