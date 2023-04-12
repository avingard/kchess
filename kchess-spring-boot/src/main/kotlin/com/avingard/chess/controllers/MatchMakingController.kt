package com.avingard.chess.controllers

import com.avingard.chess.data.MatchFound
import com.avingard.chess.player.Player
import com.avingard.chess.player.PlayerQueue
import com.avingard.echo.server.annotations.Data
import com.avingard.echo.server.annotations.MessageMapping
import org.springframework.stereotype.Controller

@Controller
class MatchMakingController(
    private val playerQueue: PlayerQueue
) {

    @MessageMapping("/chess/game/enqueue")
    suspend fun findOpponent(@Data player: Player): MatchFound {
        return playerQueue.enqueue(player)
    }

    @MessageMapping("/chess/game/dequeue")
    suspend fun exitQueue(@Data player: Player) {
        playerQueue.dequeue(player)
    }
}
