package com.example.frontend.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.frontend.data.ArtistsUiState
import com.example.frontend.repository.NetworkArtistsRepository
import kotlinx.coroutines.launch

class ArtistsViewModel : ViewModel() {
    var artistsUiState: ArtistsUiState by mutableStateOf(ArtistsUiState.Loading)
        private set

    private fun getAllArtists() {
        viewModelScope.launch {
            try {
                val artistsRepository = NetworkArtistsRepository()
                val listResult = artistsRepository.getAllArtists()
                artistsUiState = ArtistsUiState.Success(listResult)
            } catch (e: Exception) {
                e.printStackTrace()
                artistsUiState = ArtistsUiState.Error
            }
        }
    }

    init {
        getAllArtists()
    }
}