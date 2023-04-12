package com.avingard.chess.game.moves

import com.avingard.chess.game.Square
import com.avingard.chess.game.board.Board
import com.avingard.chess.game.piece.Piece


fun Piece.singleCaptureMove(
    board: Board,
    deltaFile: Int,
    deltaRank: Int
): BoardMove? {
    val square = board.find(this) ?: return null
    val target = board[square.file + deltaFile, square.rank + deltaRank] ?: return null

    return when {
        target.hasPiece(pieceColor) -> null
        else -> BoardMove(
            move = Move(
                piece = this,
                intent = MoveIntention(
                    from = square.position, to = target.position
                )
            ),
            preMove = when {
                target.isNotEmpty -> Capture(target.piece!!, target.position)
                else -> null
            }
        )
    }
}

fun Piece.lineMoves(
    board: Board,
    directions: List<Pair<Int, Int>>
) : List<BoardMove> {
    val moves = mutableListOf<BoardMove>()
    val square = board.find(this) ?: return emptyList()

    for ((deltaFile, deltaRank) in directions) {
        moves += lineMoves(board, square, deltaFile, deltaRank)
    }

    return moves
}

private fun lineMoves(
    board: Board,
    square: Square,
    deltaFile: Int,
    deltaRank: Int
): List<BoardMove> {
    requireNotNull(square.piece)
    val color = square.piece.pieceColor
    val moves = mutableListOf<BoardMove>()

    var i = 0

    while (true) {
        i++
        val target = board[square.file + deltaFile * i, square.rank + deltaRank * i] ?: break
        if (target.hasPiece(color)) {
            break
        }

        val move = Move(from = square.position, to = target.position, piece = square.piece)
        if (target.isEmpty) {
            moves += BoardMove(move)
            continue
        }

        if (target.hasPiece(color.opposite())) {
            moves += BoardMove(
                move = move,
                preMove = Capture(target.piece!!, target.position)
            )
        }

        i++
    }

    return moves
}