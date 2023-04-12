package com.avingard.chess.game

import com.avingard.chess.game.board.Position
import com.avingard.chess.game.piece.PieceColor
import com.avingard.chess.game.piece.Piece

data class Square(
    val piece: Piece? = null,
    val position: Position
) {
    val file: Int = position.file
    val rank: Int = position.rank

    fun hasPiece(pieceColor: PieceColor): Boolean {
        return piece?.pieceColor == pieceColor
    }

    val isEmpty: Boolean
        get() = piece == null

    val isNotEmpty: Boolean
        get() = !isEmpty
}

