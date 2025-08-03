package com.example.frontend.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.frontend.data.GenresUiState

@Composable
fun GenresList(
    genresUiState: GenresUiState,
    modifier: Modifier = Modifier
) {
    when (genresUiState) {
        is GenresUiState.Success -> GenresGrid(genresUiState.genres, modifier)
        is GenresUiState.Loading -> LoadingScreen(modifier)
        is GenresUiState.Error -> ErrorScreen(modifier)
    }
}