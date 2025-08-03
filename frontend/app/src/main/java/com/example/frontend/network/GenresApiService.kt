package com.example.frontend.network

import com.example.frontend.model.Genre
import com.example.frontend.model.Response
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

private const val BASE_URL = "http://10.0.2.2:8080/api/genre/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface GenresApiService {
    @GET("getAll")
    suspend fun getAllGenres(): List<Genre>

    @POST("create")
    suspend fun createGenre(@Body genre: Genre): Response
}

object GenresApi {
    val retrofitService: GenresApiService by lazy {
        retrofit.create(GenresApiService::class.java)
    }
}