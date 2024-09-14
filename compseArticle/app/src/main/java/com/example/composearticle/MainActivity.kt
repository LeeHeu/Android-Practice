package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    articalApp(
                        title = "Jetpack Compose tutorial",
                        paragraph1 = stringResource(R.string.para1),
                        paragraph2 = stringResource(R.string.para2),

                    )
                }
            }
        }
    }
}
/*
@Composable
fun ConceptText(title: String, paragraph1: String, paragraph2: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = paragraph1,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = paragraph2,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify

        )
    }
}*/


@Composable
fun articalApp(title: String, paragraph1: String, paragraph2: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.bg_compose_background)//get the image
    Column(
        modifier = modifier
    ) {
        Image(
            painter = image,
            contentDescription = null,
        )
        Text(
            text = title,
            fontSize = 27.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = paragraph1,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = paragraph2,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify

        )
    }
}


@Preview(showBackground = true)
@Composable
fun ComposeArticlePreview() {
    ComposeArticleTheme {
        articalApp(
            title = "Jetpack Compose tutorial",
            paragraph1 = "Jetpack compose is a modern toolkit for building native Android UI. " +
                    "Compose simplifies and accelerates UI development on Android with less code, " +
                    "powerful tool, and intuitive Kotlin APIs.",
            paragraph2 = "In this tutorial, you build a simple UI component with declarative functions" +
                    ". You call Compose functions to say what elements you want and the Compose " +
                    "compiler does the rest. Compose is built around Composable functions. These " +
                    "functions let you define your app's UI programmatically because they let you" +
                    " describe how it should look and provide data dependencies, rather than foucs" +
                    " on the process of the UI's construction, such as initializing an element and" +
                    " and then attaching it to a parent. To create a Composable function, you add " +
                    "the @Composable annotation to the function name."
        )
    }
}