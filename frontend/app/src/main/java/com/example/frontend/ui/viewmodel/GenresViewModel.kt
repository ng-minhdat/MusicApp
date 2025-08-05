package com.example.frontend.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.frontend.data.CreateGenreUiState
import com.example.frontend.data.GenresUiState
import com.example.frontend.model.Genre
import com.example.frontend.model.Response
import com.example.frontend.repository.NetworkGenresRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GenresViewModel : ViewModel() {
    private val _genresUiState: MutableStateFlow<GenresUiState> =
        MutableStateFlow(GenresUiState.Loading)
    val genresUiState: StateFlow<GenresUiState> = _genresUiState.asStateFlow()

    private val _createGenreUiState: MutableStateFlow<CreateGenreUiState> =
        MutableStateFlow(CreateGenreUiState())
    val createGenreUiState: StateFlow<CreateGenreUiState> = _createGenreUiState.asStateFlow()

    private fun getAllGenres() {
        viewModelScope.launch {
            try {
                val genresRepository = NetworkGenresRepository()
                val listResult = genresRepository.getAllGenres()
                _genresUiState.value = GenresUiState.Success(listResult)
            } catch (e: Exception) {
                e.printStackTrace()
                _genresUiState.value = GenresUiState.Error
            }
        }
    }

    fun createGenre(genre: Genre) {
        viewModelScope.launch {
            try {
                val genresRepository = NetworkGenresRepository()
                val response = genresRepository.createGenre(genre)
                updateResponse(response)
                getAllGenres()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun updateGenreName(genreName: String) {
        _createGenreUiState.update { currentState -> currentState.copy(genreName = genreName) }
    }

    private fun updateResponse(response: Response) {
        _createGenreUiState.update { currentState -> currentState.copy(response = response) }
    }

    init {
        getAllGenres()
    }
}