package com.example.amphibians.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AmphibianApi {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://android-kotlin-fun-mars-server.appspot.com/")  // Thay bằng URL API thật
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitService: AmphibianApiService by lazy {
        retrofit.create(AmphibianApiService::class.java)
    }
}