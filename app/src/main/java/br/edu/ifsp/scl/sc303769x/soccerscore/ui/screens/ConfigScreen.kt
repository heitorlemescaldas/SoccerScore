package br.edu.ifsp.scl.sc303769x.soccerscore.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun ConfigScreen(onNavigateToSummary: (String, String, Int, Int) -> Unit) {
    var teamA by rememberSaveable { mutableStateOf("") }
    var teamB by rememberSaveable { mutableStateOf("") }
    var goalsAStr by rememberSaveable { mutableStateOf("") }
    var goalsBStr by rememberSaveable { mutableStateOf("") }
    var errorMessage by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Configuração da Partida", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = teamA,
            onValueChange = { teamA = it },
            label = { Text("Nome do Time A") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = goalsAStr,
            onValueChange = { goalsAStr = it },
            label = { Text("Gols do Time A") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = teamB,
            onValueChange = { teamB = it },
            label = { Text("Nome do Time B") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = goalsBStr,
            onValueChange = { goalsBStr = it },
            label = { Text("Gols do Time B") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        if (errorMessage.isNotEmpty()) {
            Text(errorMessage, color = MaterialTheme.colorScheme.error)
            Spacer(modifier = Modifier.height(8.dp))
        }

        Button(
            onClick = {
                val goalsA = goalsAStr.toIntOrNull()
                val goalsB = goalsBStr.toIntOrNull()

                if (teamA.isBlank() || teamB.isBlank() || goalsAStr.isBlank() || goalsBStr.isBlank()) {
                    errorMessage = "Todos os campos devem ser preenchidos."
                } else if (goalsA == null || goalsB == null || goalsA < 0 || goalsB < 0) {
                    errorMessage = "Os gols devem ser números inteiros maiores ou iguais a zero."
                } else {
                    errorMessage = ""
                    onNavigateToSummary(teamA, teamB, goalsA, goalsB)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ver Resultado")
        }
    }
}