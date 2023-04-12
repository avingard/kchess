package com.avingard.chess.game

import com.avingard.chess.game.board.Board
import com.avingard.chess.game.board.Position
import com.avingard.chess.game.moves.AppliedMove
import com.avingard.chess.game.moves.Capture
import com.avingard.chess.game.piece.King
import com.avingard.chess.game.piece.PieceColor
import com.avingard.chess.game.piece.PieceColor.*

data class GameState(
    val board: Board = Board(),
    val lastMove: AppliedMove? = null,
    val castlingInfo: CastlingInfo = CastlingInfo(),
    val activePlayer: PieceColor = LIGHT
) {

    fun hasCheck(): Boolean {
        return hasCheckFor(activePlayer)
    }

    fun hasCheckFor(pieceColor: PieceColor): Boolean {
        val kingsPosition: Position = board.find<King>(pieceColor).firstOrNull()?.position ?: return false
        return hasCheckFor(kingsPosition)
    }

    fun hasCheckFor(position: Position): Boolean {
        return board.pieces.any { (_, piece) ->
            val otherPieceCaptures: List<Position> = piece.legalMoves(this, true)
                .filter { it.preMove is Capture }.map { it.to }

            position in otherPieceCaptures
        }
    }
}