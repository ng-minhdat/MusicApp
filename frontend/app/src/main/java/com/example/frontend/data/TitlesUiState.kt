package com.example.frontend.data

import com.example.frontend.model.Title

sealed interface TitlesUiState {
    data class Success(val titles: List<Title>) : TitlesUiState
    object Loading : TitlesUiState
    object Error : TitlesUiState
}