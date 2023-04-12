package com.example.chess.data.piece

import com.example.chess.R
import com.example.chess.data.piece.PieceColor.LIGHT
import com.example.chess.data.piece.PieceType.*


data class Piece(
    val type: PieceType,
    val color: PieceColor
) {
    val asset: Int get() = when(type) {
        ROOK -> if (color == LIGHT) R.drawable.rook_light else R.drawable.rook_dark
        KNIGHT -> if (color == LIGHT) R.drawable.knight_light else R.drawable.knight_dark
        BISHOP -> if (color == LIGHT) R.drawable.bishop_light else R.drawable.bishop_dark
        QUEEN -> if (color == LIGHT) R.drawable.queen_light else R.drawable.queen_dark
        KING -> if (color == LIGHT) R.drawable.king_light else R.drawable.king_dark
        PAWN -> if (color == LIGHT) R.drawable.pawn_light else R.drawable.pawn_dark
    }
}


