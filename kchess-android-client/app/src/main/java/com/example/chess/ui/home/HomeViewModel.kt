package com.example.chess.ui.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chess.data.player.Player
import com.example.chess.data.player.PlayerRepository
import com.example.chess.data.remote.GameBroker
import com.example.chess.data.remote.MatchMakingQueue
import com.example.chess.uuid
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val matchMakingQueue: MatchMakingQueue,
    private val gameBroker: GameBroker
): ViewModel() {
    val uiState = mutableStateOf(UiState())

    private var searchJob: Job? = null

    fun play() {
        searchJob = viewModelScope.launch {
            setUiState { it.copy(loading = true) }

            val matchFound = matchMakingQueue.enqueue()
            if (matchFound == null) {
                setUiState { it.copy(loading = false) }
                return@launch
            }

            gameBroker.startNewGame(matchFound)
            setUiState { it.copy(loading = false, gameId = matchFound.gameId) }
        }
    }

    fun cancelSearch() {
        viewModelScope.launch {
            searchJob?.cancel()
            setUiState { it.copy(loading = false) }
            matchMakingQueue.dequeue()
        }
    }

    fun forgetGame() {
        setUiState { it.copy(gameId = null) }
    }

    private fun setUiState(block: (UiState) -> UiState) {
        uiState.value = block(uiState.value)
    }
}