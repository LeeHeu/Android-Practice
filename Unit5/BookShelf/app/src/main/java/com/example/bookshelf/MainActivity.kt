package com.example.bookshelf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.bookshelf.model.Book
import com.example.bookshelf.viewmodel.BooksViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookshelfApp()
        }
    }
}

@Composable
fun BookshelfApp(viewModel: BooksViewModel = viewModel()) {
    var query by remember { mutableStateOf("Android") }

    Column {
        TextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Search Books") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = { viewModel.getBooks(query) }) {
            Text("Search")
        }

        BookList(books = viewModel.bookList)
    }
}

@Composable
fun BookList(books: List<Book>) {
    LazyColumn {
        items(books.size) { index ->
            val book = books[index]
            BookItem(book)
        }
    }
}

@Composable
fun BookItem(book: Book) {
    Row(modifier = Modifier.padding(16.dp)) {
        Image(
            painter = rememberAsyncImagePainter(book.volumeInfo.imageLinks?.thumbnail),
            contentDescription = null,
            modifier = Modifier.size(100.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(text = book.volumeInfo.title, style = MaterialTheme.typography.h6)
            Text(text = book.volumeInfo.authors?.joinToString(", ") ?: "Unknown Author")
        }
    }
}
