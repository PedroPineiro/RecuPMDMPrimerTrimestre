package com.pedro.recupmdmprimertrimestre

/**
 * Objeto que contiene los datos del juego.
 */
object Datos {
    /**
     * La palabra que el usuario debe adivinar.
     */
    var palabra: String = ""

    /**
     * La pista actual para la palabra que se debe adivinar.
     */
    var pista: String = ""

    /**
     * El número de intentos restantes para adivinar la palabra.
     */
    var intentos: Int = 0

    /**
     * Indica si el usuario ha ganado el juego.
     */
    var ganar: Boolean = false
}

val diccionarioPalabras = mapOf(
    "dinero" to listOf("plata", "capital", "moneda", "riqueza", "fortuna"),
    "guerra" to listOf("conflicto", "batalla", "combate", "lucha", "hostilidades"),
    "ciudad" to listOf("metrópolis", "urbe", "villa", "capital", "localidad"),
    "pelota" to listOf("balón", "esfera", "bola", "cuero", "esférico"),
    "circuito" to listOf("trayecto", "recorrido", "ruta", "vuelta", "circuitería"),
)

enum class EstadoJuego {
    GANADO,
    PERDIDO,
    ADIVINANDO
}