package com.avingard.chess.game

import com.avingard.chess.game.board.Position
import com.avingard.chess.game.piece.*


fun Position.isLightSquare(): Boolean {
    return (rank + file) % 2 == 0
}

fun Position.isDarkSquare(): Boolean {
    return !isLightSquare()
}

fun Map<Position, Piece>.hasInsufficientMaterial(): Boolean =
    when {
        size == 2 && hasWhiteKing() && hasBlackKing() -> true
        size == 3 && hasWhiteKing() && hasBlackKing() && hasBishop() -> true
        size == 3 && hasWhiteKing() && hasBlackKing() && hasKnight() -> true
        size == 4 && hasWhiteKing() && hasBlackKing() && hasBishopsOnSameColor() -> true
        else -> false
    }

private fun Map<Position, Piece>.hasWhiteKing(): Boolean =
    values.find { it.pieceColor == PieceColor.LIGHT && it is King } != null

private fun Map<Position, Piece>.hasBlackKing(): Boolean =
    values.find { it.pieceColor == PieceColor.DARK && it is King } != null

private fun Map<Position, Piece>.hasBishop(): Boolean =
    values.find { it is Bishop } != null

private fun Map<Position, Piece>.hasKnight(): Boolean =
    values.find { it is Knight } != null

private fun Map<Position, Piece>.hasBishopsOnSameColor(): Boolean {
    val bishops = filter { it.value is Bishop }
    return bishops.size > 1 && (bishops.all { it.key.isLightSquare() } || bishops.all { it.key.isDarkSquare() })
}