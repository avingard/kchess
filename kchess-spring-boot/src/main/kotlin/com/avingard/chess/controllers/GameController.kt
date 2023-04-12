package com.avingard.chess.controllers

import com.avingard.chess.data.Games
import com.avingard.chess.game.board.Position
import com.avingard.chess.game.moves.AppliedMove
import com.avingard.chess.game.moves.MoveEffect
import com.avingard.chess.game.piece.Piece
import com.avingard.chess.game.piece.PieceColor
import com.avingard.echo.server.annotations.Data
import com.avingard.echo.server.annotations.MessageMapping
import com.avingard.echo.server.mapper.annotations.PathVariable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import org.springframework.stereotype.Controller
import java.util.concurrent.ConcurrentMap


@Controller
class GameController(
    private val games: Games,
    private val moves: ConcurrentMap<String, MutableSharedFlow<AppliedPlayerMove>>
) {

    @MessageMapping("/chess/{game}/move")
    suspend fun playerMove(@Data move: PlayerMove, @PathVariable("game") gameId: String) {
        val game = games[gameId] ?: return
        val appliedMove = game.applyMove(move.playerId, move.from, move.to) ?: return

        moves[gameId]?.emit(appliedMove.toAppliedPlayerMove())
    }

    @MessageMapping("/chess/{game}/moves")
    fun gameMoves(@PathVariable("game") gameId: String): Flow<AppliedPlayerMove> {
        return moves.getOrPut(gameId) { MutableSharedFlow(replay = Int.MAX_VALUE) }
    }

    private fun AppliedMove.toAppliedPlayerMove() = AppliedPlayerMove(
        pieceColor = move.piece.pieceColor,
        pieceType = move.piece.type,
        from = move.from,
        to = move.to,
        moveEffect = effect
    )
}

data class PlayerMove(
    val from: Position,
    val to: Position,
    val playerId: Int
)

data class AppliedPlayerMove(
    val from: Position,
    val to: Position,
    val pieceType: Piece.Type,
    val pieceColor: PieceColor,
    val moveEffect: MoveEffect
)