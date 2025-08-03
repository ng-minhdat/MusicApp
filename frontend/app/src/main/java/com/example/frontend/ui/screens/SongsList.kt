package com.example.frontend.ui.screens

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.frontend.model.Song

@Composable
fun SongsList(
    title: String,
    songs: List<Song>,
    currentUrl: String?,
    isPlaying: Boolean,
    togglePlayback: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1)
    ) {
        itemsIndexed(songs, key = { index: Int, item: Song -> item.songId }) { index: Int, item: Song ->
            SongItem(
                name = "$title (${index + 1})",
                url = item.path,
                currentUrl = currentUrl,
                isPlaying = isPlaying,
                togglePlayback = togglePlayback,
                modifier = modifier
            )
        }
    }
}