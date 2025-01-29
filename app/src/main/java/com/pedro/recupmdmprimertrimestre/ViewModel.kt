package com.pedro.recupmdmprimertrimestre

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * ViewModel que contiene la lógica y el estado del juego.
 */
class ViewModel : ViewModel() {

    private val _estado = MutableLiveData<Datos>()
    val estado: LiveData<Datos> get() = _estado

    private val _estadoJuego = MutableLiveData<EstadoJuego>()
    val estadoJuego: LiveData<EstadoJuego> get() = _estadoJuego

    private lateinit var palabraActual: String
    private var pistas: List<String> = emptyList()
    private var numPistas = 0
    private var intentosMax = 3

    init {
        iniciarJuego()
    }

    /**
     * Inicia un nuevo juego, seleccionando una palabra y sus pistas aleatoriamente.
     * También restablece los intentos y el estado del juego.
     */
    fun iniciarJuego() {
        val estadoActual = _estado.value

        if (estadoActual?.ganar == true) {
            intentosMax = maxOf(1, intentosMax - 1)
        } else if (estadoActual?.intentos == 0) {
            intentosMax = 3
        }

        val entrada = diccionarioPalabras.entries.random()
        palabraActual = entrada.key
        pistas = entrada.value.shuffled()
        numPistas = 0

        Datos.palabra = palabraActual
        Datos.pista = pistas[numPistas]
        Datos.intentos = intentosMax
        Datos.ganar = false

        _estado.value = Datos
        _estadoJuego.value = EstadoJuego.ADIVINANDO
    }

    /**
     * Reinicia el juego restableciendo los valores por defecto.
     */
    fun reiniciarJuego() {
        intentosMax = 3

        Datos.palabra = ""
        Datos.pista = ""
        Datos.intentos = 3
        Datos.ganar = false

        _estado.value = Datos
        iniciarJuego()
    }

    /**
     * Procesa la adivinanza del usuario y actualiza el estado del juego en consecuencia.
     *
     * @param adivinanza La palabra que el usuario ha adivinado.
     */
    fun hacerAdivinanza(adivinanza: String) {
        val estadoActual = _estado.value ?: return
        if (adivinanza.equals(palabraActual, ignoreCase = true)) {
            Datos.ganar = true
            _estado.value = Datos
            _estadoJuego.value = EstadoJuego.GANADO
        } else {
            val intentosRestantes = estadoActual.intentos - 1
            if (intentosRestantes > 0) {
                Datos.intentos = intentosRestantes
                Datos.pista = obtenerPista()
                _estado.value = Datos
            } else {
                Datos.intentos = 0
                _estado.value = Datos
                _estadoJuego.value = EstadoJuego.PERDIDO
            }
        }
    }

    /**
     * Obtiene la siguiente pista de la lista de pistas.
     *
     * @return La siguiente pista.
     */
    private fun obtenerPista(): String {
        numPistas = (numPistas + 1) % pistas.size
        return pistas[numPistas]
    }
}