package com.example.chess.data.board

import com.example.chess.data.Position
import com.example.chess.data.Position.*
import com.example.chess.data.Square
import com.example.chess.data.moves.PieceEffect
import com.example.chess.data.piece.Piece
import com.example.chess.data.piece.PieceColor
import com.example.chess.data.piece.PieceColor.DARK
import com.example.chess.data.piece.PieceColor.LIGHT
import com.example.chess.data.piece.PieceType.*

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

    operator fun get(position: Position): Square {
        return squares[position]!!
    }

    fun find(piece: Piece): Square? {
        return squares.values.firstOrNull { it.piece == piece }
    }


    fun pieces(color: PieceColor): Map<Position, Piece> =
        pieces.filter { (_, piece) -> piece.color == color }

    fun apply(effect: PieceEffect?) : Board {
        return effect?.applyOn(this) ?: this
    }

    companion object {
        fun startingPieces() = mapOf(
            A1 to Piece(ROOK, LIGHT),
            B1 to Piece(KNIGHT, LIGHT),
            C1 to Piece(BISHOP, LIGHT),
            D1 to Piece(QUEEN, LIGHT),
            E1 to Piece(KING, LIGHT),
            F1 to Piece(BISHOP, LIGHT),
            G1 to Piece(KNIGHT, LIGHT),
            H1 to Piece(ROOK, LIGHT),

            A8 to Piece(ROOK, DARK),
            B8 to Piece(KNIGHT, DARK),
            C8 to Piece(BISHOP, DARK),
            D8 to Piece(QUEEN, DARK),
            E8 to Piece(KING, DARK),
            F8 to Piece(BISHOP, DARK),
            G8 to Piece(KNIGHT, DARK),
            H8 to Piece(ROOK, DARK),

            A2 to Piece(PAWN, LIGHT),
            B2 to Piece(PAWN, LIGHT),
            C2 to Piece(PAWN, LIGHT),
            D2 to Piece(PAWN, LIGHT),
            E2 to Piece(PAWN, LIGHT),
            F2 to Piece(PAWN, LIGHT),
            G2 to Piece(PAWN, LIGHT),
            H2 to Piece(PAWN, LIGHT),

            A7 to Piece(PAWN, DARK),
            B7 to Piece(PAWN, DARK),
            C7 to Piece(PAWN, DARK),
            D7 to Piece(PAWN, DARK),
            E7 to Piece(PAWN, DARK),
            F7 to Piece(PAWN, DARK),
            G7 to Piece(PAWN, DARK),
            H7 to Piece(PAWN, DARK)
        )

        fun initSquares(pieces: Map<Position, Piece>): Map<Position, Square> {
            return Position.values().associateBy({it}, { Square(pieces[it], it) })
        }
    }
}
