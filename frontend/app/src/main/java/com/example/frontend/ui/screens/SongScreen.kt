package com.example.frontend.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.frontend.data.SongsUiState

@Composable
fun SongScreen(
    title: String,
    songsUiState: SongsUiState,
    currentUrl: String?,
    isPlaying: Boolean,
    togglePlayback: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    when (songsUiState) {
        is SongsUiState.Success -> SongsList(
            title,
            songsUiState.songs,
            currentUrl,
            isPlaying = isPlaying,
            togglePlayback,
            modifier = modifier
        )
        is SongsUiState.Loading -> Text("Loading...")
        is SongsUiState.Error -> Text("Error")
    }
}