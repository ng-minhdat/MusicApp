package com.example.frontend.network

import com.example.frontend.model.Title
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "http://10.0.2.2:8080/api/title/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface TitlesApiService {
    @GET("getAll")
    suspend fun getAllTitles(): List<Title>
}

object TitlesApi {
    val retrofitService : TitlesApiService by lazy {
        retrofit.create(TitlesApiService::class.java)
    }
}