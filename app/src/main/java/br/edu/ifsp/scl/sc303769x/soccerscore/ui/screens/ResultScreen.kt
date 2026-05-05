package br.edu.ifsp.scl.sc303769x.soccerscore.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ResultScreen(
    teamA: String,
    teamB: String,
    goalsA: Int,
    goalsB: Int,
    onNewGame: () -> Unit
) {
    val resultMessage = when {
        goalsA > goalsB -> "$teamA venceu!"
        goalsB > goalsA -> "$teamB venceu!"
        else -> "Empate emocionante!"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Resultado Final", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(24.dp))

        Text(resultMessage, style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = onNewGame, modifier = Modifier.fillMaxWidth()) {
            Text("Novo Jogo")
        }
    }
}