package com.avingard.chess.game.piece

import com.avingard.chess.game.GameState
import com.avingard.chess.game.moves.BoardMove


interface Piece {
    val type: Type
    val pieceColor: PieceColor

    fun legalMoves(gameState: GameState, checkCheck: Boolean): List<BoardMove>

    enum class Type {
        ROOK, KNIGHT, BISHOP, QUEEN, KING, PAWN
    }
}
