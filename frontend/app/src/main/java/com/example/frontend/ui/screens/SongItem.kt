package com.example.frontend.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SongItem(
    name: String,
    url: String,
    currentUrl: String?,
    isPlaying: Boolean,
    togglePlayback: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        Text(
            text = name,
            modifier = modifier
        )
        Button(
            onClick = {
                togglePlayback(url)
            }
        ) {
            Text(if (url == currentUrl && isPlaying) "Pause" else "Play")
        }
    }
}