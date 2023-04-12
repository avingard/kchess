package com.example.chess.data.game

import android.util.Log
import com.avingard.echo.client.GrpcClient
import com.example.chess.data.Position
import com.example.chess.data.moves.AppliedPlayerMove
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GameApi @Inject constructor(
    private val grpcClient: GrpcClient
) {

    suspend fun boardMoves(gameId: String): Flow<AppliedPlayerMove> {
        return grpcClient.requestStream("/chess/$gameId/moves")
    }

    suspend fun move(gameId: String, playerId: Int, from: Position, to: Position): Result<Unit> {
        return try {
            grpcClient.requestResponse<Unit>("/chess/$gameId/move") {
                setData(PlayerMove(from, to, playerId))
            }
            Result.success(Unit)
        } catch (e: Exception) {
            Log.d("GameApi", "Move failed due to: ${e.stackTraceToString()}")
            Result.failure(e)
        }
    }

    data class PlayerMove(
        val from: Position,
        val to: Position,
        val playerId: Int
    )
}