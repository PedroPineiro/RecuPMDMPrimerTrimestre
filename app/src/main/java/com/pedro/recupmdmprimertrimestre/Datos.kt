package com.pedro.recupmdmprimertrimestre

object Datos {
    var palabra: String = ""
    var pista: String = ""
    var intentos: Int = 0
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