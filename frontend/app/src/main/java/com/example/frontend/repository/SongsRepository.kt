package com.example.frontend.repository

import com.example.frontend.model.Song
import com.example.frontend.network.SongsApi

interface SongsRepository {
    suspend fun getSongsByTitle(title: String): List<Song>
}

class NetworkSongsRepository() : SongsRepository {
    override suspend fun getSongsByTitle(title: String): List<Song> {
        return SongsApi.retrofitService.getSongsByTitle(title)
    }
}