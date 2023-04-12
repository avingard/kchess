package com.example.chess.data.moves

import com.example.chess.data.Position
import com.example.chess.data.piece.Piece

data class BoardMove(
    val move: PrimaryMove,
    val preMove: PreMove? = null,
    val consequence: Consequence? = null,
) {
    val from: Position = move.from

    val to: Position = move.to

    val piece: Piece = move.piece
}
