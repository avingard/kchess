package com.avingard.chess.game.piece

import com.avingard.chess.game.GameState
import com.avingard.chess.game.Square
import com.avingard.chess.game.board.Board
import com.avingard.chess.game.moves.*
import com.avingard.chess.game.piece.Piece.Type
import com.avingard.chess.game.piece.Piece.Type.PAWN
import com.avingard.chess.game.piece.PieceColor.*

class Pawn(override val pieceColor: PieceColor) : Piece {
    override val type: Type = PAWN

    override fun legalMoves(gameState: GameState, checkCheck: Boolean): List<BoardMove> {
        val board = gameState.board
        val square = board.find(this) ?: return emptyList()
        val moves = mutableListOf<BoardMove>()

        advanceSingle(board, square)?.let { moves += it }
        advanceTwoSquares(board, square)?.let { moves += it }
        captureDiagonalLeft(board, square)?.let { moves += it }
        captureDiagonalRight(board, square)?.let { moves += it }
        enPassantCaptureLeft(gameState, board, square)?.let { moves += it }
        enPassantCaptureRight(gameState, board, square)?.let { moves += it }

        return moves.flatMap {
            it.checkForPromotion()
        }
    }

    private fun advanceSingle(board: Board, square: Square): BoardMove? {
        val deltaRank = if (pieceColor == LIGHT) 1 else -1
        val target = board[square.file, square.rank + deltaRank]
        return if (target?.isEmpty == true) BoardMove(
            move = Move(this, square.position, target.position)
        ) else null
    }

    private fun advanceTwoSquares(board: Board, square: Square): BoardMove? {
        if ((pieceColor == LIGHT && square.rank == 2) || (pieceColor == DARK && square.rank == 7)) {
            val deltaRank1 = if (pieceColor == LIGHT) 1 else -1
            val deltaRank2 = if (pieceColor == LIGHT) 2 else -2
            val target1 = board[square.file, square.rank + deltaRank1]
            val target2 = board[square.file, square.rank + deltaRank2]
            return if (target1?.isEmpty == true && target2?.isEmpty == true) BoardMove(
                move = Move(this, square.position, target2.position)
            ) else null
        }
        return null
    }


    private fun captureDiagonalLeft(board: Board, square: Square): BoardMove? {
        return captureDiagonal(board, square, -1)
    }

    private fun captureDiagonalRight(board: Board, square: Square): BoardMove? {
        return captureDiagonal(board, square, 1)
    }

    private fun captureDiagonal(board: Board, square: Square, deltaFile: Int): BoardMove? {
        val deltaRank = if (pieceColor == LIGHT) 1 else -1
        val target = board[square.file + deltaFile, square.rank + deltaRank]
        return if (target?.hasPiece(pieceColor.opposite()) == true) BoardMove(
            move = Move(this, square.position, target.position),
            preMove = Capture(target.piece!!, target.position)
        ) else null
    }


    private fun enPassantCaptureLeft(gameState: GameState, board: Board, square: Square): BoardMove? {
        return enPassantDiagonal(gameState, board, square, -1)
    }

    private fun enPassantCaptureRight(gameState: GameState, board: Board, square: Square): BoardMove? {
        return enPassantDiagonal(gameState, board, square, 1)
    }

    private fun enPassantDiagonal(gameState: GameState, board: Board, square: Square, deltaFile: Int): BoardMove? {
        if (square.position.rank != if (pieceColor == LIGHT) 5 else 4) return null
        val lastMove = gameState.lastMove ?: return null
        if (lastMove.piece !is Pawn) return null
        val fromInitialSquare = (lastMove.from.rank == if (pieceColor == LIGHT) 7 else 2)
        val twoSquareMove = (lastMove.to.rank == square.position.rank)
        val isOnNextFile = lastMove.to.file == square.file + deltaFile

        return if (fromInitialSquare && twoSquareMove && isOnNextFile) {
            val deltaRank = if (pieceColor == LIGHT) 1 else -1
            val enPassantTarget = board[square.file + deltaFile, square.rank + deltaRank]
            val capturedPieceSquare = board[square.file + deltaFile, square.rank]

            requireNotNull(enPassantTarget)
            requireNotNull(capturedPieceSquare)

            BoardMove(
                move = Move(this, square.position, enPassantTarget.position),
                preMove = Capture(capturedPieceSquare.piece!!, capturedPieceSquare.position)
            )
        } else null
    }
}

private fun BoardMove.checkForPromotion(): List<BoardMove> {
    return if (move.to.rank == if (piece.pieceColor == LIGHT) 8 else 1) {
        listOf(
            copy(consequence = Promotion(move.to, Queen(piece.pieceColor))),
            copy(consequence = Promotion(move.to, Rook(piece.pieceColor))),
            copy(consequence = Promotion(move.to, Bishop(piece.pieceColor))),
            copy(consequence = Promotion(move.to, Knight(piece.pieceColor))),
        )
    } else listOf(this)
}