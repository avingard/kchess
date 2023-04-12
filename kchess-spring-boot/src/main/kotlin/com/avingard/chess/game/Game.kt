package com.avingard.chess.game

import com.avingard.chess.game.board.Position
import com.avingard.chess.game.moves.AppliedMove
import com.avingard.chess.game.moves.BoardMove
import com.avingard.chess.game.moves.MoveEffect
import com.avingard.chess.game.moves.Promotion
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class Game(
    private val playerSet: PlayerSet
) {

    private val _gameState: MutableStateFlow<GameState> = MutableStateFlow(GameState())
    private val gameState: StateFlow<GameState> = _gameState.asStateFlow()

    fun applyMove(playerId: Int, from: Position, to: Position): AppliedMove? {
        val (playerColor, _) = playerSet.findById(playerId) ?: throw IllegalStateException("Couldn't associate provided playerId with in-game players")
        if (gameState.value.activePlayer != playerColor) return null

        val boardMove = findBoardMove(from, to) ?: return null
        return calculateAppliedMove(boardMove).lastMove
    }


    private fun calculateAppliedMove(boardMove: BoardMove): GameState {
        val currentGameState = gameState.value
        val newGameState = derivePseudoGameState(currentGameState, boardMove)
        val validMoves = with(newGameState) {
            board.pieces(activePlayer).filter { (position, _) ->
                legalMovesFrom(position, newGameState).isNotEmpty()
            }
        }

        val isCheck = newGameState.hasCheckFor(newGameState.activePlayer)
        val isCheckNotMate = validMoves.isNotEmpty() && isCheck
        val isCheckMate = validMoves.isEmpty() && isCheck
        val isStaleMate = validMoves.isEmpty() && !isCheck
        val insufficientMaterial = newGameState.board.pieces.hasInsufficientMaterial()

        //TODO: check for repetition

        val appliedMove = AppliedMove(
            //TODO: apply ambiguity (whatever that means)
            boardMove = boardMove,
            effect = when {
                isCheckNotMate -> MoveEffect.CHECK
                isCheckMate -> MoveEffect.CHECKMATE
                isStaleMate -> MoveEffect.DRAW
                insufficientMaterial -> MoveEffect.DRAW
                else -> MoveEffect.NONE
            }
        )

        return newGameState.copy(lastMove = appliedMove).also { newState ->
            _gameState.update { newState }
        }
    }

    private fun findBoardMove(from: Position, to: Position): BoardMove? {
        val gameState = gameState.value
        val legalMoves = legalMovesFrom(from, gameState).filter { it.to == to }

        return when {
            legalMoves.isEmpty() -> {
                throw IllegalArgumentException("No legal moves exist between $from and $to")
            }
            legalMoves.size == 1 -> {
                legalMoves.first()
            }
            legalMoves.all { it.consequence is Promotion } -> {
                handlePromotion(to, legalMoves)
            }
            else -> {
                throw IllegalStateException("Something went wrong with moves: $legalMoves")
            }
        }
    }

    private fun legalMovesFrom(position: Position, gameState: GameState): List<BoardMove> {
        return gameState.board[position]
            .piece
            ?.legalMoves(gameState, false)
            ?.applyCheckConstraints(gameState)
            ?: emptyList()
    }

    private fun List<BoardMove>.applyCheckConstraints(gameState: GameState): List<BoardMove> {
        return filter { move ->
            val newGameState = derivePseudoGameState(gameState, move)
            !newGameState.hasCheckFor(move.piece.pieceColor)
        }
    }

    //TODO: implement promotion
    private fun handlePromotion(position: Position, legalMoves: List<BoardMove>): BoardMove? {
        return null
    }

    private fun derivePseudoGameState(gameState: GameState, boardMove: BoardMove): GameState {
        val updatedBoard = gameState.board.apply(boardMove)

        return gameState.copy(
            board = updatedBoard,
            activePlayer = gameState.activePlayer.opposite(),
            lastMove = AppliedMove(
                boardMove = boardMove,
                effect = MoveEffect.NONE
            )
        )
    }
}