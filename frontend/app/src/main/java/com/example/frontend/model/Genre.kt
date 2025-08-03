package com.example.frontend.model

import kotlinx.serialization.Serializable

@Serializable
data class Genre(
    val genreId: Long? = null,
    val genreName: String
)