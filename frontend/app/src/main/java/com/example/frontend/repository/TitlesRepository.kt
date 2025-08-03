package com.example.frontend.repository

import com.example.frontend.model.Title
import com.example.frontend.network.TitlesApi

interface TitlesRepository {
    suspend fun getAllTitles(): List<Title>
}

class NetworkTitlesRepository() : TitlesRepository {
    override suspend fun getAllTitles(): List<Title> {
        return TitlesApi.retrofitService.getAllTitles()
    }
}