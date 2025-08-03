package com.example.frontend.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.frontend.data.TitlesUiState
import com.example.frontend.model.Title

@Composable
fun TitlesGrid(
    titles: List<Title>,
    onTitleClicked: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(8.dp)
    ) {
        items(titles, key = { item: Title -> item.titleId }) { item: Title ->
            Text(
                item.title,
                modifier = Modifier.clickable {
                    onTitleClicked(item.title)
                }
            )
        }
    }
}