package com.avingard.chess.game.piece

import com.avingard.chess.game.GameState
import com.avingard.chess.game.moves.BoardMove
import com.avingard.chess.game.moves.lineMoves
import com.avingard.chess.game.piece.Piece.Type
import com.avingard.chess.game.piece.Piece.Type.BISHOP

class Bishop(override val pieceColor: PieceColor) : Piece {

    override val type: Type = BISHOP

    override fun legalMoves(gameState: GameState, checkCheck: Boolean): List<BoardMove> {
        return lineMoves(gameState.board, directions)
    }

    companion object {
        val directions = listOf(
            -1 to -1,
            -1 to 1,
            1 to -1,
            1 to 1,
        )
    }
}