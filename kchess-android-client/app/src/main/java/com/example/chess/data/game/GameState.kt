package com.example.chess.data.game

import com.example.chess.data.moves.MoveEffect
import com.example.chess.data.piece.PieceColor
import com.example.chess.data.piece.PieceColor.LIGHT
import com.example.chess.data.remote.Opponent

data class GameState(
    val playerColor: PieceColor = LIGHT,
    val activePlayer: PieceColor = LIGHT,
    val opponent: Opponent = Opponent(LIGHT, ""),
    val moveEffect: MoveEffect = MoveEffect.NONE
) {

    val isPlayerTurn: Boolean get() = activePlayer == playerColor

}
