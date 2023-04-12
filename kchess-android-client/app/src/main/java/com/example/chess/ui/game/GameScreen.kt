package com.example.chess.ui.game

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.chess.data.Position
import com.example.chess.data.game.GameState
import com.example.chess.data.moves.MoveEffect.CHECKMATE
import com.example.chess.data.moves.MoveEffect.DRAW
import com.example.chess.data.piece.PieceColor

@Composable
fun GameScreen(
    gameId: String,
    onNavigateBackToHome: () -> Unit,
    viewModel: GameViewModel = hiltViewModel()
) {
    val gameState by viewModel.gameState.collectAsState()
    val board by viewModel.board.collectAsState()
    val boardState by viewModel.boardState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.watchBoardMoves(gameId)
    }

    if ((gameState.moveEffect == CHECKMATE || gameState.moveEffect == DRAW)) {
        ResultDialog(
            gameState = gameState,
            onNavBackToHome = onNavigateBackToHome
        )
    }

    BoxWithConstraints(modifier = Modifier
        .fillMaxWidth()
        .aspectRatio(1f)
    ) {
        val squareSize = maxWidth / 8

        Column {
            val ranks = remember(gameState.playerColor) {
                if (gameState.playerColor == PieceColor.LIGHT) {
                    Position.values().groupBy { it.rank }
                } else {
                    Position.values().groupBy { it.rank }.toList().reversed().toMap()
                }
            }

            ranks.forEach {
                val files = remember(gameState.playerColor) {
                    if (gameState.playerColor == PieceColor.LIGHT) it.value else it.value.reversed()
                }

                Row(modifier = Modifier
                    .fillMaxWidth()
                ) {
                    files.forEach {
                        val square = board[it]
                        Box(modifier = Modifier
                            .size(squareSize)
                            .background(
                                squareBackground(
                                    gameState.playerColor != PieceColor.LIGHT,
                                    boardState.selectedPosition,
                                    it.file,
                                    it.rank
                                )
                            )
                            .clickable(enabled = square.piece != null || boardState.selectedPosition != null) {
                                viewModel.onClick(gameId, square.position)
                            },
                            contentAlignment = Alignment.Center
                        ) {
                            if (square.piece != null) {
                                Icon(
                                    painter = painterResource(square.piece.asset),
                                    contentDescription = null,
                                    tint = Color.Unspecified
                                )
                            }
                        }
                    }
                }
            }

        }
    }
}

@Composable
private fun ResultDialog(
    gameState: GameState,
    onNavBackToHome: () -> Unit
) {
    val resultTitle = remember {
        if (!gameState.isPlayerTurn) {
            "You Won!"
        } else {
            "${gameState.activePlayer.opposite().formattedName()} Won!"
        }
    }

    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        confirmButton = {
            TextButton(onClick = onNavBackToHome) {
                Text("Ok")
            }
        },
        title = {
            Text(resultTitle)
        }
    )
}

@Composable
private fun squareBackground(reversed: Boolean, selectedPosition: Position?, file: Int, rank: Int): Color {
    val position = remember(file, rank) {
        Position.from(file, rank)
    }

    return if (selectedPosition == position) {
        Color.Green
    } else {
        if ((rank + file) % 2 == if (reversed) 0 else 1) {
            Color.White
        } else {
            Color.Gray
        }
    }
}