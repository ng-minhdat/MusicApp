package com.example.frontend.ui

import android.media.MediaPlayer
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MediaPlayerViewModel : ViewModel() {
    private var mediaPlayer: MediaPlayer? = null

    private val _currentUrl = MutableStateFlow<String?>(null)
    val currentUrl: StateFlow<String?> = _currentUrl.asStateFlow()

    private val _isPlaying = MutableStateFlow<Boolean>(false)
    val isPlaying: StateFlow<Boolean> = _isPlaying.asStateFlow()

    fun togglePlayback(url: String) {
        when {
            mediaPlayer == null -> {
                startNewPlayer(url)
            }

            _currentUrl.value == url && mediaPlayer!!.isPlaying -> {
                // Same song is playing -> Pause it
                mediaPlayer?.pause()
                _isPlaying.value = false
            }

            _currentUrl.value == url && !(mediaPlayer!!.isPlaying) -> {
                // Same song is paused -> Resume it
                mediaPlayer?.start()
                _isPlaying.value = true
            }

            _currentUrl.value != url -> {
                // Different song → Release old and start new
                mediaPlayer?.release()
                startNewPlayer(url)
            }
        }
    }

    private fun startNewPlayer(url: String) {
        _currentUrl.value = url

        mediaPlayer = MediaPlayer().apply {
            setDataSource(url)
            setOnPreparedListener {
                it.start()
                _isPlaying.value = true
            }
            setOnCompletionListener {
                _isPlaying.value = false
                _currentUrl.value = null
            }
            prepareAsync()
        }
    }

    override fun onCleared() {
        super.onCleared()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}