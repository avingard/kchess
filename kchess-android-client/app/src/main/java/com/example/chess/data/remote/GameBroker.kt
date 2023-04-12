package com.example.chess.data.remote

import com.example.chess.data.Position
import com.example.chess.data.game.GameApi
import com.example.chess.data.game.GameState
import com.example.chess.data.moves.AppliedPlayerMove
import com.example.chess.data.moves.MoveEffect
import com.example.chess.data.player.PlayerRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameBroker @Inject constructor(
    private val gameApi: GameApi,
    private val playerRepository: PlayerRepository
) {
    private val _gameState = MutableStateFlow(GameState())
    val gameState: StateFlow<GameState> = _gameState.asStateFlow()

    fun startNewGame(matchFound: MatchFound) {
        _gameState.update { currentState ->
            currentState.copy(
                opponent = matchFound.opponent,
                playerColor = matchFound.opponent.color.opposite()
            )
        }
    }

    suspend fun boardMoves(gameId: String): Flow<AppliedPlayerMove> {
        return gameApi.boardMoves(gameId).onEach { move ->
            _gameState.update { currentState ->
                currentState.copy(
                    activePlayer = move.pieceColor.opposite(),
                    moveEffect = move.moveEffect
                )
            }
        }
    }

    suspend fun move(gameId: String, from: Position, to: Position): Result<Unit> {
        val currentPlayer = playerRepository.getCurrentPlayer() ?: throw IllegalStateException("Current player is not")
        return gameApi.move(gameId, currentPlayer.id, from, to)
    }
}