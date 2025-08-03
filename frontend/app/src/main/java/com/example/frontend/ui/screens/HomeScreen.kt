package com.example.frontend.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.frontend.data.ArtistsUiState
import com.example.frontend.data.GenresUiState
import com.example.frontend.data.TitlesUiState

@Composable
fun HomeScreen(
    genresUiState: GenresUiState,
    onCreateGenreButtonClicked: () -> Unit,
    artistsUiState: ArtistsUiState,
    titlesUiState: TitlesUiState,
    onTitleClicked: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = modifier.weight(1F),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Buttons
            Button(
                onClick = onCreateGenreButtonClicked
            ) {
                Text("Create Genre")
            }
        }
        Row(
            modifier = modifier.weight(1F),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text("Genres", fontWeight = FontWeight.Bold)
                GenresList(
                    genresUiState = genresUiState,
                    modifier = modifier
                )
            }
        }
        Row(
            modifier = modifier.weight(1F),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text("Artists", fontWeight = FontWeight.Bold)
                ArtistsList(
                    artistsUiState = artistsUiState,
                    modifier = modifier
                )
            }
        }
        Row(
            modifier = modifier.weight(1F),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text("Songs", fontWeight = FontWeight.Bold)
                TitlesList(
                    titlesUiState = titlesUiState,
                    onTitleClicked = onTitleClicked,
                    modifier = modifier
                )
            }
        }
    }
}