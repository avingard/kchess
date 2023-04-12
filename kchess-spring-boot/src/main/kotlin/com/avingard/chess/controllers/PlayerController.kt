package com.avingard.chess.controllers

import com.avingard.chess.player.Player
import com.avingard.chess.services.PlayerService
import com.avingard.echo.server.annotations.MessageMapping
import com.avingard.echo.server.mapper.annotations.PathVariable
import org.springframework.stereotype.Controller

@Controller
class PlayerController(
    private val playerService: PlayerService
) {

    @MessageMapping("/chess/players/{name}")
    suspend fun getPlayer(@PathVariable("name") playerName: String): Player {
        return playerService.findPlayerByName(playerName)
    }

}