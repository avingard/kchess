package com.avingard.chess.game.board

import com.avingard.chess.game.Square
import com.avingard.chess.game.board.Position.*
import com.avingard.chess.game.moves.BoardMove
import com.avingard.chess.game.moves.PieceEffect
import com.avingard.chess.game.piece.*
import com.avingard.chess.game.piece.PieceColor.*
import com.avingard.chess.game.piece.PieceColor


data class Board(
    val pieces: Map<Position, Piece> = startingPieces()
) {
    val squares: Map<Position, Square> = initSquares(pieces)

    operator fun get(file: Int, rank: Int): Square? {
        return try {
            squares[Position.from(file, rank)]
        } catch (e: IllegalArgumentException) {
            null
        }
    }

    operator fun get(file: File, rank: Int): Square? {
        return get(file.ordinal + 1, rank)
    }

    operator fun get(position: Position): Square {
        return squares[position]!!
    }

    fun find(piece: Piece): Square? {
        return squares.values.firstOrNull { it.piece == piece }
    }

    inline fun <reified T : Piece> find(pieceColor: PieceColor): List<Square> =
        squares.values.filter {
            it.piece != null &&
                    it.piece::class == T::class &&
                    it.piece.pieceColor == pieceColor
        }

    fun pieces(pieceColor: PieceColor): Map<Position, Piece> =
        pieces.filter { (_, piece) -> piece.pieceColor == pieceColor }

    fun apply(effect: PieceEffect?) : Board {
        return effect?.applyOn(this) ?: this
    }

    fun apply(boardMove: BoardMove): Board {
        return this
            .apply(boardMove.preMove)
            .apply(boardMove.move)
            .apply(boardMove.consequence)
    }

    companion object {
        fun startingPieces() = mapOf(
            A1 to Rook(LIGHT),
            B1 to Knight(LIGHT),
            C1 to Bishop(LIGHT),
            D1 to Queen(LIGHT),
            E1 to King(LIGHT),
            F1 to Bishop(LIGHT),
            G1 to Knight(LIGHT),
            H1 to Rook(LIGHT),

            A8 to Rook(DARK),
            B8 to Knight(DARK),
            C8 to Bishop(DARK),
            D8 to Queen(DARK),
            E8 to King(DARK),
            F8 to Bishop(DARK),
            G8 to Knight(DARK),
            H8 to Rook(DARK),

            A2 to Pawn(LIGHT),
            B2 to Pawn(LIGHT),
            C2 to Pawn(LIGHT),
            D2 to Pawn(LIGHT),
            E2 to Pawn(LIGHT),
            F2 to Pawn(LIGHT),
            G2 to Pawn(LIGHT),
            H2 to Pawn(LIGHT),

            A7 to Pawn(DARK),
            B7 to Pawn(DARK),
            C7 to Pawn(DARK),
            D7 to Pawn(DARK),
            E7 to Pawn(DARK),
            F7 to Pawn(DARK),
            G7 to Pawn(DARK),
            H7 to Pawn(DARK),
        )

        fun initSquares(pieces: Map<Position, Piece>): Map<Position, Square> {
            return Position.values().associateBy({it}, { Square(pieces[it], it) })
        }
    }
}
