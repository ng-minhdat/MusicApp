package com.example.frontend.data

import com.example.frontend.model.Genre

sealed interface GenresUiState {
    data class Success(val genres: List<Genre>) : GenresUiState
    object Error : GenresUiState
    object Loading : GenresUiState
}