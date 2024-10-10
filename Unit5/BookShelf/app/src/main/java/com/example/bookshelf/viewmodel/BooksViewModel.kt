package com.example.bookshelf.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookshelf.model.Book
import com.example.bookshelf.network.RetrofitInstance
import kotlinx.coroutines.launch

class BooksViewModel : ViewModel() {
    var bookList: List<Book> = listOf()
        private set

    fun getBooks(query: String) {
        viewModelScope.launch {
            val response = RetrofitInstance.api.getBooks(query)
            if (response.isSuccessful) {
                bookList = response.body()?.items ?: listOf()
            }
        }
    }
}