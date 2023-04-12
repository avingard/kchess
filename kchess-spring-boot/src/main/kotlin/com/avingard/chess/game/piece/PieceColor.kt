package com.avingard.chess.game.piece

enum class PieceColor {
    LIGHT, DARK;

    fun opposite(): PieceColor {
        return when(this) {
            LIGHT -> DARK
            DARK -> LIGHT
        }
    }
}