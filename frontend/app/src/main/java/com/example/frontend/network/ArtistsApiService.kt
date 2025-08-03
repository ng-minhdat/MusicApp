package com.example.frontend.network

import com.example.frontend.model.Artist
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "http://10.0.2.2:8080/api/artist/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface ArtistsApiService {
    @GET("getAll")
    suspend fun getAllArtists(): List<Artist>
}

object ArtistsApi {
    val retrofitService: ArtistsApiService by lazy {
        retrofit.create(ArtistsApiService::class.java)
    }
}