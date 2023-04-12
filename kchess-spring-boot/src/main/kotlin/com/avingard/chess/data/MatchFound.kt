package com.avingard.chess.data

import com.avingard.chess.game.piece.PieceColor

data class MatchFound(
    val gameId: String,
    val opponent: Opponent
)

data class Opponent(
    val color: PieceColor,
    val name: String
)
