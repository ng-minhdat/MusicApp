package com.example.frontend.model

import kotlinx.serialization.Serializable

@Serializable
data class Song(
    val songId: Long,
    val titleId: Long,
    val releaseDate: String,
    val artistId: Long,
    val length: Int,
    val userId: Long,
    val path: String
)
