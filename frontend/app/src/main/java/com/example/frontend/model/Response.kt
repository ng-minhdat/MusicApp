package com.example.frontend.model

import kotlinx.serialization.Serializable

@Serializable
data class Response(
    val statusCode: String,
    val statusMsg: String
)
