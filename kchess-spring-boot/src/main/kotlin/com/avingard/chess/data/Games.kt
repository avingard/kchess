package com.avingard.chess.data

import com.avingard.chess.game.Game
import com.avingard.chess.game.PlayerSet
import com.avingard.chess.player.Player
import com.avingard.uuid
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.util.UUID
import java.util.concurrent.ConcurrentMap

class Games(private val games: ConcurrentMap<String, Game>) {
    private val mutex = Mutex()

    operator fun get(gameId: String): Game? {
        return games[gameId]
    }

    fun removeGame(gameId: String) {
        games.remove(gameId)
    }

    fun create(players: PlayerSet): String {
        val gameId = uuid()
        games.getOrPut(gameId) { Game(players) }
        return gameId
    }
}