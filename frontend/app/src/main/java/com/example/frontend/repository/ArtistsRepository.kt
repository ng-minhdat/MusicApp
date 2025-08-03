package com.example.frontend.repository

import com.example.frontend.model.Artist
import com.example.frontend.network.ArtistsApi

interface ArtistsRepository {
    suspend fun getAllArtists(): List<Artist>
}

class NetworkArtistsRepository() : ArtistsRepository {
    override suspend fun getAllArtists(): List<Artist> {
        return ArtistsApi.retrofitService.getAllArtists()
    }
}