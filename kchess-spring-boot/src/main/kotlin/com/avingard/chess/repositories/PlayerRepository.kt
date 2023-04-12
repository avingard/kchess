package com.avingard.chess.repositories

import com.avingard.chess.player.Player
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepository : CoroutineCrudRepository<Player, Int> {
    suspend fun findByName(name: String): Player?
}