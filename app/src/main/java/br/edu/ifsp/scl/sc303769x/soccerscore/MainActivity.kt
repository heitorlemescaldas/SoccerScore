package br.edu.ifsp.scl.sc303769x.soccerscore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.edu.ifsp.scl.sc303769x.soccerscore.navigation.AppNavigation
import br.edu.ifsp.scl.sc303769x.soccerscore.ui.theme.SoccerScoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SoccerScoreTheme {
                AppNavigation()
            }
        }
    }
}