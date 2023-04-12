package com.example.chess.ui.start

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chess.data.player.Player
import com.example.chess.data.player.PlayerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(
    private val playerRepository: PlayerRepository
): ViewModel() {

    val uiState = mutableStateOf(UiState())
    val playerName = mutableStateOf("")

    fun loadPlayer() {
        viewModelScope.launch {
            setUiState { it.copy(loading = true) }
            val player = playerRepository.loadPlayer()
            handleReturnPlayer(player)
        }
    }

    fun registerPlayer(playerName: String) {
        viewModelScope.launch {
            setUiState { it.copy(loading = true) }
            val player = playerRepository.registerPlayer(playerName)
            handleReturnPlayer(player)
        }
    }

    private fun handleReturnPlayer(player: Player?) {
        if (player != null) {
            setUiState { it.copy(playerName = player.name, loading = false) }
            return
        }
        setUiState { it.copy(loading = false) }
    }

    private fun setUiState(block: (UiState) -> UiState) {
        uiState.value = block(uiState.value)
    }
}