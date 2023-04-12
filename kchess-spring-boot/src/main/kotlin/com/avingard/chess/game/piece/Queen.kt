package com.avingard.chess.game.piece

import com.avingard.chess.game.GameState
import com.avingard.chess.game.moves.BoardMove
import com.avingard.chess.game.moves.lineMoves
import com.avingard.chess.game.piece.Piece.Type
import com.avingard.chess.game.piece.Piece.Type.QUEEN

class Queen(override val pieceColor: PieceColor) : Piece {
    override val type: Type = QUEEN

    override fun legalMoves(gameState: GameState, checkCheck: Boolean): List<BoardMove> {
        val board = gameState.board
        return lineMoves(board, Rook.directions + Bishop.directions)
    }
}