package com.example.frontend.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.frontend.data.TitlesUiState

@Composable
fun TitlesList(
    titlesUiState: TitlesUiState,
    onTitleClicked: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    when (titlesUiState) {
        is TitlesUiState.Success -> TitlesGrid(
            titles = titlesUiState.titles,
            onTitleClicked = onTitleClicked,
            modifier = modifier
        )
        is TitlesUiState.Loading -> Text(
            "Loading..."
        )
        is TitlesUiState.Error -> Text(
            "Error"
        )
    }
}