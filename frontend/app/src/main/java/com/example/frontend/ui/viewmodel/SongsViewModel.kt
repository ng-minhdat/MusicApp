package com.example.frontend.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.frontend.data.SongsUiState
import com.example.frontend.repository.NetworkSongsRepository
import kotlinx.coroutines.launch

class SongsViewModel : ViewModel() {
    var songsUiState: SongsUiState by mutableStateOf(SongsUiState.Loading)
        private set

    fun getSongsByTitle(title: String) {
        viewModelScope.launch {
            try {
                val songsRepository = NetworkSongsRepository()
                val listResult = songsRepository.getSongsByTitle(title)
                songsUiState = SongsUiState.Success(listResult)
            } catch (e: Exception) {
                e.printStackTrace()
                songsUiState = SongsUiState.Error
            }
        }
    }
}