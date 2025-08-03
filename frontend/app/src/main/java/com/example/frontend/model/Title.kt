package com.example.frontend.model

import kotlinx.serialization.Serializable

@Serializable
data class Title(
    val titleId: Long,
    val title: String,
    val year: Int,
    val genreId: Long,
    val country: String
)
