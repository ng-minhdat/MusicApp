package com.example.frontend.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.frontend.data.TitleSelectionUiState
import com.example.frontend.data.TitlesUiState
import com.example.frontend.repository.NetworkTitlesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TitlesViewModel : ViewModel() {
    var titlesUiState: TitlesUiState by mutableStateOf(TitlesUiState.Loading)
        private set

    private val _titleSelectionUiState: MutableStateFlow<TitleSelectionUiState> = MutableStateFlow(
        TitleSelectionUiState()
    )
    val titleSelectionUiState: StateFlow<TitleSelectionUiState> = _titleSelectionUiState.asStateFlow()

    private fun getAllTitles() {
        viewModelScope.launch {
            try {
                val titlesRepository = NetworkTitlesRepository()
                val listResult = titlesRepository.getAllTitles()
                titlesUiState = TitlesUiState.Success(listResult)
            } catch (e: Exception) {
                e.printStackTrace()
                titlesUiState = TitlesUiState.Error
            }
        }
    }

    fun updateTitleSelection(title: String) {
        _titleSelectionUiState.update { currentState -> currentState.copy(title = title) }
    }

    init {
        getAllTitles()
    }
}