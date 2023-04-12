package com.avingard.chess.game.piece

import com.avingard.chess.game.GameState
import com.avingard.chess.game.board.File.*
import com.avingard.chess.game.moves.*
import com.avingard.chess.game.piece.Piece.Type
import com.avingard.chess.game.piece.Piece.Type.KING
import com.avingard.chess.game.piece.PieceColor.*

class King(override val pieceColor: PieceColor) : Piece {

    override val type: Type = KING

    override fun legalMoves(gameState: GameState, checkCheck: Boolean): List<BoardMove> {
        val board = gameState.board
        val moves = targets
            .mapNotNull { (deltaFile, deltaRank) ->
                singleCaptureMove(board, deltaFile, deltaRank)
            }.toMutableList()

        if (!checkCheck) {
            castleKingSide(gameState)?.let { moves += it }
            castleQueenSide(gameState)?.let { moves += it }
        }

        return moves
    }

    private fun castleKingSide(gameState: GameState): BoardMove? {
        if (gameState.hasCheck()) return null
        if (!gameState.castlingInfo[pieceColor].canCastleKingSide) return null

        val board = gameState.board
        val rank = if (pieceColor == LIGHT) 1 else 8

        val eSquare = board[E, rank]!!
        val fSquare = board[F, rank]!!
        val gSquare = board[G, rank]!!
        val hSquare = board[H, rank]!!

        if (fSquare.isNotEmpty || gSquare.isNotEmpty) return null
        if (gameState.hasCheckFor(fSquare.position) || gameState.hasCheckFor(gSquare.position)) return null
        if (hSquare.piece !is Rook) return null

        return BoardMove(
            move = KingSideCastle(this, eSquare.position, gSquare.position),
            consequence = Move(hSquare.piece, hSquare.position, fSquare.position)
        )
    }

    private fun castleQueenSide(gameState: GameState): BoardMove? {
        if (gameState.hasCheck()) return null
        if (!gameState.castlingInfo[pieceColor].canCastleQueenSide) return null

        val board = gameState.board
        val rank = if (pieceColor == LIGHT) 1 else 8

        val eSquare = board[E, rank]!!
        val dSquare = board[D, rank]!!
        val cSquare = board[C, rank]!!
        val bSquare = board[B, rank]!!
        val aSquare = board[A, rank]!!
        if (dSquare.isNotEmpty || cSquare.isNotEmpty || bSquare.isNotEmpty) return null
        if (gameState.hasCheckFor(dSquare.position) || gameState.hasCheckFor(cSquare.position)) return null
        if (aSquare.piece !is Rook) return null

        return BoardMove(
            move = QueenSideCastle(this, eSquare.position, cSquare.position),
            consequence = Move(aSquare.piece, aSquare.position, dSquare.position)
        )
    }


    companion object {
        val targets = listOf(
            -1 to -1,
            -1 to 0,
            -1 to 1,
            0 to 1,
            0 to -1,
            1 to -1,
            1 to 0,
            1 to 1,
        )
    }
}