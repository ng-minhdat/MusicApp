package com.example.frontend.network

import com.example.frontend.model.Song
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "http://10.0.2.2:8080/api/song/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface SongsApiService {
    @GET("getByTitle")
    suspend fun getSongsByTitle(@Query("title") title: String): List<Song>
}

object SongsApi {
    val retrofitService: SongsApiService by lazy {
        retrofit.create(SongsApiService::class.java)
    }
}