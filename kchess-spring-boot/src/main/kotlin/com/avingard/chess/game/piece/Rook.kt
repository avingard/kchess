package com.avingard.chess.game.piece

import com.avingard.chess.game.GameState
import com.avingard.chess.game.moves.BoardMove
import com.avingard.chess.game.moves.lineMoves
import com.avingard.chess.game.piece.Piece.Type
import com.avingard.chess.game.piece.Piece.Type.ROOK

class Rook(override val pieceColor: PieceColor) : Piece {
    override val type: Type = ROOK

    override fun legalMoves(gameState: GameState, checkCheck: Boolean): List<BoardMove> {
        val board = gameState.board
        return lineMoves(board, directions)
    }

    companion object {
        val directions = listOf(
            0 to -1,
            0 to 1,
            -1 to 0,
            1 to 0,
        )
    }
}