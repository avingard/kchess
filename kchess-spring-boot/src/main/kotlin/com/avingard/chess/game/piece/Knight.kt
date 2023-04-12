package com.avingard.chess.game.piece

import com.avingard.chess.game.GameState
import com.avingard.chess.game.moves.BoardMove
import com.avingard.chess.game.moves.singleCaptureMove
import com.avingard.chess.game.piece.Piece.Type
import com.avingard.chess.game.piece.Piece.Type.KNIGHT

class Knight(override val pieceColor: PieceColor) : Piece {

    override val type: Type = KNIGHT

    override fun legalMoves(gameState: GameState, checkCheck: Boolean): List<BoardMove> {
        val board = gameState.board
        return targets.mapNotNull { (deltaFile, deltaRank) ->
            singleCaptureMove(board, deltaFile, deltaRank)
        }
    }

    companion object {
        val targets = listOf(
            -2 to 1,
            -2 to -1,
            2 to 1,
            2 to -1,
            1 to 2,
            1 to -2,
            -1 to 2,
            -1 to -2
        )
    }
}