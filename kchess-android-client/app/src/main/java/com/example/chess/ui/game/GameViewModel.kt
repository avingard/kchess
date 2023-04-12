package com.example.chess.ui.game

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chess.data.Position
import com.example.chess.data.board.Board
import com.example.chess.data.board.BoardState
import com.example.chess.data.moves.AppliedPlayerMove
import com.example.chess.data.moves.primaryMove
import com.example.chess.data.remote.GameBroker
import com.example.chess.sink
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val gameBroker: GameBroker
) : ViewModel() {
    val gameState = gameBroker.gameState

    private val _board = MutableStateFlow(Board())
    val board: StateFlow<Board> = _board.asStateFlow()

    private val _boardState = MutableStateFlow(BoardState())
    val boardState: StateFlow<BoardState> = _boardState.asStateFlow()

    fun watchBoardMoves(gameId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val boardMoves = gameBroker.boardMoves(gameId).sink()

            boardMoves.collect { appliedMoves ->
                updateBoard(appliedMoves)
            }
        }
    }

    fun onClick(gameId: String, position: Position) {
        if (notPlayerTurn()) return
        handleOnClick(gameId, position)
    }


    private fun handleOnClick(gameId: String, position: Position) {
        val boardState = boardState.value
        viewModelScope.launch(Dispatchers.IO) {
            if (position.hasOwnPiece()) {
                toggleSelectPosition(position)
                return@launch
            }

            if (boardState.selectedPosition != null) {
                move(gameId, position)
            }
        }
    }

    private fun toggleSelectPosition(position: Position) {
        _boardState.update { it.copy(selectedPosition = if (it.selectedPosition != position) position else null) }
    }

    private suspend fun move(gameId: String, position: Position) {
        val result = moveTo(gameId, position)
        if (result.isSuccess) {
            _boardState.update { it.copy(selectedPosition = null) }
        }
    }

    private suspend fun moveTo(gameId: String, position: Position): Result<Unit> {
        val boardState = boardState.value
        if (boardState.selectedPosition == null) return Result.failure(RuntimeException("Selected position is null"))

        return gameBroker.move(gameId = gameId, from = boardState.selectedPosition, to = position)
    }

    private fun updateBoard(appliedMoves: List<AppliedPlayerMove>) {
        _board.update { board ->
            appliedMoves.fold(board) { accumulator, move ->
                accumulator.apply(move.primaryMove)
            }
        }
    }

    private fun notPlayerTurn(): Boolean {
        val gameState = gameState.value
        return !gameState.isPlayerTurn
    }

    private fun Position.hasOwnPiece(): Boolean {
        val board = board.value
        val square = board[this]
        val gameState = gameState.value

        return square.hasPiece(gameState.playerColor)
    }
}