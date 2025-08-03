package com.example.frontend.data

import com.example.frontend.model.Song

sealed interface SongsUiState {
    data class Success(val songs: List<Song>) : SongsUiState
    object Loading : SongsUiState
    object Error : SongsUiState
}