package com.example.frontend.repository

import com.example.frontend.model.Genre
import com.example.frontend.model.Response
import com.example.frontend.network.GenresApi

interface GenresRepository {
    suspend fun getAllGenres(): List<Genre>
    suspend fun createGenre(genre: Genre): Response
}

class NetworkGenresRepository() : GenresRepository {
    override suspend fun getAllGenres(): List<Genre> {
        return GenresApi.retrofitService.getAllGenres()
    }

    override suspend fun createGenre(genre: Genre): Response {
        return GenresApi.retrofitService.createGenre(genre)
    }
}
