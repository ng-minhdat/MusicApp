package com.example.frontend.model

import kotlinx.serialization.Serializable

@Serializable
data class Artist(
    val artistId: Long,
    val name: String,
    val dateOfBirth: String,
    val country: String,
    val imagePath: String
)
