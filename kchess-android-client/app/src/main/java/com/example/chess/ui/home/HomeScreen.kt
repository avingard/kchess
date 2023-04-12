package com.example.chess.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController


@Composable
fun HomeScreen(
    playerName: String,
    onNavigateToGame: (String) -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState

    LaunchedEffect(uiState.gameId) {
        val gameId = uiState.gameId

        if (gameId != null) {
            viewModel.forgetGame()
            onNavigateToGame(gameId)
        }
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(25.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Welcome back $playerName!",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.align(Alignment.TopStart)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (uiState.loading) {
                Text(
                    text = "Searching for opponent...",
                    style = MaterialTheme.typography.headlineSmall
                )

                Spacer(modifier = Modifier.height(15.dp))
            }

            Button(
                onClick = {
                    if (uiState.loading) {
                        viewModel.cancelSearch()
                    } else {
                        viewModel.play()
                    }
                }
            ) {
                Text(text = if (!uiState.loading) "PLAY" else "CANCEL")
            }
        }
    }
}


