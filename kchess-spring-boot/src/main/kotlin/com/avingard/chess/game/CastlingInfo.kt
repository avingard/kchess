package com.avingard.chess.game

import com.avingard.chess.game.board.Board
import com.avingard.chess.game.moves.BoardMove
import com.avingard.chess.game.piece.King
import com.avingard.chess.game.piece.PieceColor
import com.avingard.chess.game.piece.PieceColor.*
import com.avingard.chess.game.board.Position.*
import com.avingard.chess.game.piece.Rook

data class CastlingInfo(
    val holders: Map<PieceColor, Holder> = mapOf(
        LIGHT to Holder(),
        DARK to Holder()
    )
) {

    operator fun get(pieceColor: PieceColor) = holders[pieceColor]!!

    fun apply(boardMove: BoardMove): CastlingInfo {
        val move = boardMove.move
        val piece = boardMove.piece
        val color = piece.pieceColor
        val holder = holders[color]!!


        val kingSideRookInitialPosition = if (color == LIGHT) H1 else H8
        val queenSideRookInitialPosition = if (color == LIGHT) A1 else A8

        val updatedHolder = holder.copy(
            kingHasMoved = holder.kingHasMoved || piece is King,
            kingSideRookHasMoved = holder.kingSideRookHasMoved || piece is Rook && move.from == kingSideRookInitialPosition,
            queenSideRookHasMoved = holder.queenSideRookHasMoved || piece is Rook && move.from == queenSideRookInitialPosition,
        )

        return copy(
            holders = holders
                .minus(color)
                .plus(color to updatedHolder)
        )
    }

    data class Holder(
        val kingHasMoved: Boolean = false,
        val kingSideRookHasMoved: Boolean = false,
        val queenSideRookHasMoved: Boolean = false,
    ) {
        val canCastleKingSide: Boolean
            get() = !kingHasMoved && !kingSideRookHasMoved

        val canCastleQueenSide: Boolean
            get() = !kingHasMoved && !queenSideRookHasMoved
    }

    companion object {
        fun from(board: Board): CastlingInfo {
            val lightPieces = board.pieces(LIGHT)
            val lightHolder = Holder(
                kingHasMoved = lightPieces[E1] !is King,
                kingSideRookHasMoved = lightPieces[H1] !is Rook,
                queenSideRookHasMoved = lightPieces[A1] !is Rook,
            )
            val darkPieces = board.pieces(DARK)
            val darkHolder = Holder(
                kingHasMoved = darkPieces[E8] !is King,
                kingSideRookHasMoved = darkPieces[H8] !is Rook,
                queenSideRookHasMoved = darkPieces[A8] !is Rook,
            )

            return CastlingInfo(
                mapOf(
                    LIGHT to lightHolder,
                    DARK to darkHolder
                )
            )
        }
    }
}