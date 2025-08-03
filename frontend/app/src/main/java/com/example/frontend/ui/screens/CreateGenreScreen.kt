package com.example.frontend.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.frontend.model.Response

@Composable
fun CreateGenreScreen(
    genreName: String,
    response: Response?,
    onGenreNameChanged: (String) -> Unit,
    onCreateButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        TextField(
            value = genreName,
            label = { Text("Genre Name") },
            onValueChange = onGenreNameChanged
        )
        Button(
            onClick = onCreateButtonClicked
        ) {
            Text("Create")
        }
        if (response != null) {
            Text("Status code: ${response.statusCode}")
            Text("Status message: ${response.statusMsg}")
        }
    }
}