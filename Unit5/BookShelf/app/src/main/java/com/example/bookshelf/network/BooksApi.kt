package com.example.bookshelf.network

import com.example.bookshelf.model.Book
import com.example.bookshelf.model.BookResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BooksApi {
    @GET("volumes")
    suspend fun getBooks(@Query("q") query: String): Response<BookResponse>

    @GET("volumes/{volumeId}")
    suspend fun getBookDetails(@Path("volumeId") volumeId: String): Response<Book>
}