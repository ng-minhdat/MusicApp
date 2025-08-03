package com.example.frontend

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.frontend.model.Genre
import com.example.frontend.ui.ArtistsViewModel
import com.example.frontend.ui.GenresViewModel
import com.example.frontend.ui.MediaPlayerViewModel
import com.example.frontend.ui.SongsViewModel
import com.example.frontend.ui.screens.AppScreen
import com.example.frontend.ui.screens.CreateGenreScreen
import com.example.frontend.ui.screens.HomeScreen
import com.example.frontend.ui.TitlesViewModel
import com.example.frontend.ui.screens.SongScreen

@Composable
fun App(
    genresViewModel: GenresViewModel = viewModel(),
    artistsViewModel: ArtistsViewModel = viewModel(),
    titlesViewModel: TitlesViewModel = viewModel(),
    songsViewModel: SongsViewModel = viewModel(),
    mediaPlayerViewModel: MediaPlayerViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val genresUiState by genresViewModel.genresUiState.collectAsState()
    val createGenreUiState by genresViewModel.createGenreUiState.collectAsState()
    val artistsUiState = artistsViewModel.artistsUiState
    val titlesUiState = titlesViewModel.titlesUiState
    val titleSelectionUiState by titlesViewModel.titleSelectionUiState.collectAsState()
    val songsUiState = songsViewModel.songsUiState
    val currentUrl by mediaPlayerViewModel.currentUrl.collectAsState()
    val isPlaying by mediaPlayerViewModel.isPlaying.collectAsState()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppScreen.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = AppScreen.Home.name) {
                HomeScreen(
                    genresUiState = genresUiState,
                    onCreateGenreButtonClicked = {
                        navController.navigate(AppScreen.CreateGenre.name)
                    },
                    artistsUiState = artistsUiState,
                    titlesUiState = titlesUiState,
                    onTitleClicked = {
                        titlesViewModel.updateTitleSelection(it)
                        navController.navigate(AppScreen.Song.name)
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }
            composable(route = AppScreen.CreateGenre.name) {
                CreateGenreScreen(
                    genreName = createGenreUiState.genreName,
                    response = createGenreUiState.response,
                    onGenreNameChanged = {
                        genresViewModel.updateGenreName(it)
                    },
                    onCreateButtonClicked = {
                        genresViewModel.createGenre(Genre(genreId = null, genreName = createGenreUiState.genreName))
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }
            composable(route = AppScreen.Song.name) {
                songsViewModel.getSongsByTitle(titleSelectionUiState.title)
                SongScreen(
                    title = titleSelectionUiState.title,
                    songsUiState = songsUiState,
                    currentUrl = currentUrl,
                    isPlaying = isPlaying,
                    togglePlayback = { mediaPlayerViewModel.togglePlayback(it) },
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}