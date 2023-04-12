package com.example.chess.data.moves

import com.example.chess.data.Position
import com.example.chess.data.piece.Piece
import com.example.chess.data.piece.PieceColor
import com.example.chess.data.piece.PieceType

data class AppliedPlayerMove(
    val from: Position,
    val to: Position,
    val pieceType: PieceType,
    val pieceColor: PieceColor,
    val moveEffect: MoveEffect
)


val AppliedPlayerMove.primaryMove: PrimaryMove get() = Move(Piece(pieceType, pieceColor), from, to)
