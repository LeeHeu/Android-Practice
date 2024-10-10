package com.example.bookshelf.repository

import com.example.bookshelf.model.Book
import com.example.bookshelf.network.BooksApi

class BookRepository(private val api: BooksApi) {

    suspend fun searchBooks(query: String): List<Book> {
        val response = api.getBooks(query)
        return if (response.isSuccessful) {
            response.body()?.items ?: emptyList()
        } else {
            emptyList()
        }
    }

    suspend fun getBookDetails(volumeId: String): Book? {
        val response = api.getBookDetails(volumeId)
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }
}
