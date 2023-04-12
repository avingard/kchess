package com.example.chess.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chess.ui.game.GameScreen
import com.example.chess.ui.home.HomeScreen
import com.example.chess.ui.start.StartScreen

@Composable
fun AppNav(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "start"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("start") {
            StartScreen(
                onNavigateToHome = { playerName ->
                    navController.navigate("home/$playerName") {
                        popUpTo("start") {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable("home/{playerName}") { backStackEntry ->
            HomeScreen(
                onNavigateToGame = { gameId ->
                    navController.navigate("game/$gameId")
                },
                playerName = backStackEntry.arguments?.getString("playerName")!!
            )
        }

        composable("game/{gameId}") { backStackEntry ->
            GameScreen(
                onNavigateBackToHome = {
                    navController.popBackStack()
                },
                gameId = backStackEntry.arguments?.getString("gameId")!!
            )
        }
    }
}