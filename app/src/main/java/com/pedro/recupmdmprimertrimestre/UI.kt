package com.pedro.recupmdmprimertrimestre

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Función composable que representa la interfaz de usuario del juego.
 *
 * @param viewModel El ViewModel que contiene la lógica y el estado del juego.
 */
@Composable
fun IU(viewModel: ViewModel) {
    // Observa el estado actual del juego desde el ViewModel
    val estado by viewModel.estado.observeAsState()
    val estadoJuego by viewModel.estadoJuego.observeAsState()

    // Variable de estado para mantener la adivinanza del usuario
    var adivinandoUsuario by remember { mutableStateOf("") }

    // Diseño principal en columna para la interfaz de usuario
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Texto para mostrar la pista
        Text(
            text = "Pista: ${estado?.pista ?: ""}",
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp)
        )

        // Campo de texto para que el usuario introduzca su adivinanza
        OutlinedTextField(
            value = adivinandoUsuario,
            onValueChange = { adivinandoUsuario = it },
            label = { Text("Introduce tu palabra") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        // Botón para enviar la palabra del usuario
        Button(
            onClick = {
                viewModel.hacerAdivinanza(adivinandoUsuario)
                adivinandoUsuario = "" // Pone el texto vacío al hacer click
            },
            enabled = estadoJuego == EstadoJuego.ADIVINANDO,
            modifier = Modifier.padding(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text("Enviar")
        }

        // Texto para mostrar los intentos restantes
        Text(
            text = "Intentos restantes: ${estado?.intentos ?: 0}",
            fontSize = 16.sp,
            modifier = Modifier.padding(8.dp)
        )

        // Texto para mostrar el resultado del juego
        Text(
            text = when (estadoJuego) {
                EstadoJuego.GANADO -> "¡Has ganado!"
                EstadoJuego.PERDIDO -> "¡Has perdido!"
                else -> ""
            },
            fontSize = 18.sp,
            modifier = Modifier.padding(8.dp)
        )

        // Botón que reinicia el juego con los valores por defecto
        Button(
            onClick = { viewModel.reiniciarJuego() },
            modifier = Modifier.padding(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text("Reiniciar Juego")
        }
    }
}