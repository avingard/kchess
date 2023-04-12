package com.example.chess.data

import com.example.chess.data.piece.Piece
import com.example.chess.data.piece.PieceColor

data class Square(
    val piece: Piece? = null,
    val position: Position
) {
    val file: Int = position.file
    val rank: Int = position.rank

    fun hasPiece(color: PieceColor): Boolean {
        return piece?.color == color
    }

    val isEmpty: Boolean
        get() = piece == null

    val isNotEmpty: Boolean
        get() = !isEmpty
}

