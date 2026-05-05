package br.edu.ifsp.scl.sc303769x.soccerscore.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SummaryScreen(
    teamA: String,
    teamB: String,
    goalsA: Int,
    goalsB: Int,
    onConfirm: () -> Unit,
    onEdit: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Resumo da Partida", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(24.dp))

        Text("$teamA x $teamB", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text("$goalsA x $goalsB", style = MaterialTheme.typography.displayMedium)

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = onConfirm, modifier = Modifier.fillMaxWidth()) {
            Text("Confirmar Resultado")
        }
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedButton(onClick = onEdit, modifier = Modifier.fillMaxWidth()) {
            Text("Editar")
        }
    }
}