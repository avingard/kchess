package com.example.chess.data.player

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerRepository @Inject constructor(
    private val playerDataStore: PlayerDataStore,
    private val scope: CoroutineScope,
    private val playerApi: PlayerApi
) {
    private val _player = MutableStateFlow<Player?>(null)

    fun getCurrentPlayer(): Player? {
        return _player.value
    }

    suspend fun setCurrentPlayer(player: Player?) {
        this._player.update { player }

        if (player != null) {
            playerDataStore.save(player)
        } else {
            playerDataStore.clear()
        }
    }

    suspend fun loadPlayer(): Player? {
        val playerName = playerDataStore.getSavedPlayerName()
        if (playerName != null) {
            return registerPlayer(playerName)
        }
        return null
    }

    suspend fun registerPlayer(playerName: String): Player? {
        return playerApi.getPlayer(playerName).also { player ->
            _player.update { player }
            player?.let { playerDataStore.save(it) }
        }
    }
}