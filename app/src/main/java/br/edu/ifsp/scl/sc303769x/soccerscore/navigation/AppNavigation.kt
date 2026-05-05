package br.edu.ifsp.scl.sc303769x.soccerscore.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.edu.ifsp.scl.sc303769x.soccerscore.ui.screens.ConfigScreen
import br.edu.ifsp.scl.sc303769x.soccerscore.ui.screens.ResultScreen
import br.edu.ifsp.scl.sc303769x.soccerscore.ui.screens.SummaryScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "config") {
        composable("config") {
            ConfigScreen(
                onNavigateToSummary = { teamA, teamB, goalsA, goalsB ->
                    navController.navigate("summary/$teamA/$teamB/$goalsA/$goalsB")
                }
            )
        }

        composable(
            route = "summary/{teamA}/{teamB}/{goalsA}/{goalsB}",
            arguments = listOf(
                navArgument("teamA") { type = NavType.StringType },
                navArgument("teamB") { type = NavType.StringType },
                navArgument("goalsA") { type = NavType.IntType },
                navArgument("goalsB") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val teamA = backStackEntry.arguments?.getString("teamA") ?: ""
            val teamB = backStackEntry.arguments?.getString("teamB") ?: ""
            val goalsA = backStackEntry.arguments?.getInt("goalsA") ?: 0
            val goalsB = backStackEntry.arguments?.getInt("goalsB") ?: 0

            SummaryScreen(
                teamA = teamA,
                teamB = teamB,
                goalsA = goalsA,
                goalsB = goalsB,
                onConfirm = {
                    navController.navigate("result/$teamA/$teamB/$goalsA/$goalsB")
                },
                onEdit = {
                    // Retorna limpando a pilha até a tela de config
                    navController.popBackStack("config", inclusive = false)
                }
            )
        }

        composable(
            route = "result/{teamA}/{teamB}/{goalsA}/{goalsB}",
            arguments = listOf(
                navArgument("teamA") { type = NavType.StringType },
                navArgument("teamB") { type = NavType.StringType },
                navArgument("goalsA") { type = NavType.IntType },
                navArgument("goalsB") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val teamA = backStackEntry.arguments?.getString("teamA") ?: ""
            val teamB = backStackEntry.arguments?.getString("teamB") ?: ""
            val goalsA = backStackEntry.arguments?.getInt("goalsA") ?: 0
            val goalsB = backStackEntry.arguments?.getInt("goalsB") ?: 0

            ResultScreen(
                teamA = teamA,
                teamB = teamB,
                goalsA = goalsA,
                goalsB = goalsB,
                onNewGame = {
                    navController.popBackStack("config", inclusive = false)
                }
            )
        }
    }
}