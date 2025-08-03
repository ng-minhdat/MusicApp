package com.example.frontend.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.frontend.model.Genre

@Composable
fun GenresGrid(
    genres: List<Genre>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(genres, key = { item: Genre -> item!!.genreId!! }) { item: Genre ->
            Text(
                text = item.genreName,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}