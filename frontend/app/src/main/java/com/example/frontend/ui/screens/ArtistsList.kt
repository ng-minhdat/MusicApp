package com.example.frontend.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.frontend.data.ArtistsUiState

@Composable
fun ArtistsList(
    artistsUiState: ArtistsUiState,
    modifier: Modifier = Modifier
) {
    when (artistsUiState) {
        is ArtistsUiState.Success -> ArtistsGrid(artistsUiState.artists, modifier)
        is ArtistsUiState.Loading -> LoadingScreen(modifier)
        is ArtistsUiState.Error -> ErrorScreen(modifier)
    }
}