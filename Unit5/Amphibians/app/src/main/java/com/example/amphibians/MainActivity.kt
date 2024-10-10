package com.example.amphibians

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.amphibians.model.Amphibian
import com.example.amphibians.viewmodel.AmphibiansViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmphibiansApp()
        }
    }
}

@Composable
fun AmphibiansApp(viewModel: AmphibiansViewModel = viewModel()) {
    val amphibians = viewModel.amphibians.observeAsState(emptyList())
    val status = viewModel.status.observeAsState("")

    Column {
        Text(text = status.value)
        AmphibiansList(amphibians = amphibians.value)
    }
}

@Composable
fun AmphibiansList(amphibians: List<Amphibian>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(amphibians) { amphibian ->
            AmphibianItem(amphibian)
        }
    }
}

@Composable
fun AmphibianItem(amphibian: Amphibian) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = amphibian.name, style = MaterialTheme.typography.headlineSmall)
        Text(text = amphibian.description, style = MaterialTheme.typography.bodyLarge)
        Image(
            painter = rememberAsyncImagePainter(model = amphibian.imgSrc),
            contentDescription = null,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AmphibianItem(Amphibian("Frog", "A small amphibian", ""))
}
