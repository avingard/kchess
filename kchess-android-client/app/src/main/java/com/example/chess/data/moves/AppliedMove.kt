package com.example.chess.data.moves

import com.example.chess.data.Position
import com.example.chess.data.piece.Piece

data class AppliedMove(
    val boardMove: BoardMove,
    val effect: MoveEffect? = null
)  {

    val move: PrimaryMove = boardMove.move
    val from: Position = move.from
    val to: Position = move.to
    val piece: Piece = move.piece
}