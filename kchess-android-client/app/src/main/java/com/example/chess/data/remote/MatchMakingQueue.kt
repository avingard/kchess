package com.example.chess.data.remote

import com.avingard.echo.client.GrpcClient
import com.example.chess.data.player.Player
import com.example.chess.data.player.PlayerRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MatchMakingQueue @Inject constructor(
    private val grpcClient: GrpcClient,
    private val playerRepository: PlayerRepository
) {
    suspend fun enqueue(): MatchFound? {
        return try {
            grpcClient.requestResponse("/chess/game/enqueue") {
                setData(getCurrentPlayer())
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    suspend fun dequeue() {
        try {
            grpcClient.requestResponse<Unit>("/chess/game/dequeue") {
                setData(getCurrentPlayer())
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun getCurrentPlayer(): Player {
        return playerRepository.getCurrentPlayer() ?: throw RuntimeException("Current player must be set before sending any game requests")
    }
}