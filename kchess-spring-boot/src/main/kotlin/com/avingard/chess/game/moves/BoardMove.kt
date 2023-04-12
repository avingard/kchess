package com.avingard.chess.game.moves

import com.avingard.chess.game.board.Position
import com.avingard.chess.game.piece.Piece


data class BoardMove(
    val move: PrimaryMove,
    val preMove: PreMove? = null,
    val consequence: Consequence? = null,
) {
    val from: Position = move.from

    val to: Position = move.to

    val piece: Piece = move.piece
}
