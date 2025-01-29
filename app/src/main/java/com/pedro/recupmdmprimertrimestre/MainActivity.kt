package com.pedro.recupmdmprimertrimestre

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.pedro.recupmdmprimertrimestre.ui.theme.RecuPMDMPrimerTrimestreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // inicializamos ViewModel
        val viewModel: ViewModel = ViewModel()

        enableEdgeToEdge()
        setContent {
            RecuPMDMPrimerTrimestreTheme {
                // llamamos a la IU pasando el ViewModel
                IU(viewModel)
            }
        }
    }
}