package com.avingard.chess.game.moves

import com.avingard.chess.game.board.Position


data class MoveIntention(
    val from: Position,
    val to: Position
)