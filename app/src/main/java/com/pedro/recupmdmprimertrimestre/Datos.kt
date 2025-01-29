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
    "viaje" to listOf("travesía", "excursión", "aventura", "peregrinaje", "ruta"),
    "odio" to listOf("rencor", "ira", "resentimiento", "antipatía", "aversión"),
    "miedo" to listOf("temor", "pavor", "pánico", "terror", "angustia"),
)

enum class EstadoJuego {
    GANADO,
    PERDIDO,
    ADIVINANDO
}