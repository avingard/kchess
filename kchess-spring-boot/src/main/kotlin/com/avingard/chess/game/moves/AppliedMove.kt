package com.avingard.chess.game.moves

import com.avingard.chess.game.board.Position
import com.avingard.chess.game.piece.Piece


data class AppliedMove(
    val boardMove: BoardMove,
    val effect: MoveEffect = MoveEffect.NONE
)  {

    val move: PrimaryMove = boardMove.move
    val from: Position = move.from
    val to: Position = move.to
    val piece: Piece = move.piece

    val hasEffect: Boolean
        get() = effect != MoveEffect.NONE
}