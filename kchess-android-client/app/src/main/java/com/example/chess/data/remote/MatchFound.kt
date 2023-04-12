package com.example.chess.data.remote

import com.example.chess.data.piece.PieceColor

data class MatchFound(
    val gameId: String,
    val opponent: Opponent
)

data class Opponent(
    val color: PieceColor,
    val name: String
)