package com.example.frontend.data

import com.example.frontend.model.Artist

sealed interface ArtistsUiState {
    data class Success(val artists: List<Artist>) : ArtistsUiState
    object Loading : ArtistsUiState
    object Error : ArtistsUiState
}