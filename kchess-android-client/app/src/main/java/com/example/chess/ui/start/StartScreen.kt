package com.example.chess.ui.start

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen(
    onNavigateToHome: (String) -> Unit,
    viewModel: StartViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState
    val (playerName, onPlayerNameChange) = viewModel.playerName

    LaunchedEffect(Unit) {
        viewModel.loadPlayer()
    }

    LaunchedEffect(uiState.playerName) {
        if (uiState.playerName != null) {
            onNavigateToHome(uiState.playerName!!)
        }
    }

    if (uiState.loading) {
        LoadingDialog()
    }

    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = playerName,
                onValueChange = onPlayerNameChange
            )

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = {
                    viewModel.registerPlayer(playerName)
                }
            ) {
                Text(text = "Continue")
            }
        }
    }
}

@Composable
private fun LoadingDialog() {
    Dialog(onDismissRequest = { /*TODO*/ }) {
        Box(modifier = Modifier
            .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}