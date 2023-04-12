package com.avingard.chess.services

import com.avingard.chess.player.Player
import com.avingard.chess.repositories.PlayerRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PlayerService(
    private val playerRepository: PlayerRepository
) {

    @Transactional
    suspend fun findPlayerByName(name: String): Player {
        val player = playerRepository.findByName(name)
        if (player != null) return player

        val newPlayer = Player(name = name)
        return playerRepository.save(newPlayer)
    }

    suspend fun findPlayerById(id: Int): Player? {
        return playerRepository.findById(id)
    }
}