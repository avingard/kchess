package com.avingard.chess.game.board

enum class File {
    A, B, C, D, E, F, G, H
}

operator fun File.get(rank: Int): Position =
    Position.values()[this.ordinal * 8 + (rank - 1)]