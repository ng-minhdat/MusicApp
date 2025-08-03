package com.example.frontend.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.frontend.data.ArtistsUiState
import com.example.frontend.model.Artist

@Composable
fun ArtistsGrid(
    artists: List<Artist>,
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        contentPadding = PaddingValues(2.dp),
    ) {
        items(artists, key = { item: Artist -> item.artistId }) { item: Artist ->
            ArtistCard(item)
        }
    }
}