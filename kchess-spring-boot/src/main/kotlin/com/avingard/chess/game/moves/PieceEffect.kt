package com.avingard.chess.game.moves

import com.avingard.chess.game.board.Board
import com.avingard.chess.game.board.Position
import com.avingard.chess.game.piece.Piece

interface PieceEffect {

    val piece: Piece

    fun applyOn(board: Board): Board
}

interface PreMove : PieceEffect

interface Consequence : PieceEffect

interface PrimaryMove : PieceEffect {

    val from: Position

    val to: Position
}

data class Move(
    override val piece: Piece,
    override val from: Position,
    override val to: Position
): PrimaryMove, Consequence {
    constructor(
        piece: Piece,
        intent: MoveIntention,
    ) : this(
        piece = piece,
        from = intent.from,
        to = intent.to
    )

    override fun applyOn(board: Board): Board {
        return board.copy(
            pieces = board.pieces
                .minus(from)
                .plus(to to piece)
        )
    }
}

data class KingSideCastle(
    override val piece: Piece,
    override val from: Position,
    override val to: Position
) : PrimaryMove {
    override fun applyOn(board: Board): Board =
        board.copy(
            pieces = board.pieces
                .minus(from)
                .plus(to to piece)
        )
}

data class QueenSideCastle(
    override val piece: Piece,
    override val from: Position,
    override val to: Position
) : PrimaryMove {

    override fun applyOn(board: Board): Board =
        board.copy(
            pieces = board.pieces
                .minus(from)
                .plus(to to piece)
        )
}

data class Capture(
    override val piece: Piece,
    val position: Position,
) : PreMove {

    override fun applyOn(board: Board): Board =
        board.copy(
            pieces = board.pieces.minus(position)
        )
}

data class Promotion(
    val position: Position,
    override val piece: Piece,
) : Consequence {

    override fun applyOn(board: Board): Board =
        board.copy(
            pieces = board.pieces
                .minus(position)
                .plus(position to piece)
        )
}
