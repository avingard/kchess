package com.example.chess.data.piece

enum class PieceColor {
    LIGHT, DARK;

    fun opposite(): PieceColor {
        return when(this) {
            LIGHT -> DARK
            DARK -> LIGHT
        }
    }

    fun formattedName(): String {
        return when(this) {
            LIGHT -> "Light"
            DARK -> "Dark"
        }
    }
}