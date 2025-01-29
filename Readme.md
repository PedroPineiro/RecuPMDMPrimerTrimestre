# Recuperación PMDM - Pedro Piñeiro Ordax

## Enunciado

Implementa una app que es un juego de adivinar una palabra, dando pistas

Se genera una palabra random de un diccionario

Las pistas son sinónimos de esta palabra

En cada ronda la app muestra un sinónimo

Si al tercer intento el jugador no acierta, pierde y el juego termina

Si en algún intento el jugador acierta, gana y el juego termina


## Solución

Lo primero que haremos es crear las clases de la estructura MVVM, siendo estas la MainActivity por defecto, el view, siendo esto lo visible en la aplicacion con todas las composables (UI); la ViewModel, donde está toda la lógica del programa (ViewModel); y el model, donde están todos los datos que hacen funcionar el programa almacenados (Datos)

 