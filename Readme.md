# Recuperación PMDM - Pedro Piñeiro Ordax

## Enunciado

Implementa una app que es un juego de adivinar una palabra, dando pistas

Se genera una palabra random de un diccionario

Las pistas son sinónimos de esta palabra

En cada ronda la app muestra un sinónimo

Si al tercer intento el jugador no acierta, pierde y el juego termina

Si en algún intento el jugador acierta, gana y el juego termina


## Solución

Lo primero que hago es crear las clases de la estructura MVVM, siendo estas la MainActivity por defecto, el view, siendo esto lo visible en la aplicacion con todas las composables (UI); la ViewModel, donde está toda la lógica del programa (ViewModel); y el model, donde están todos los datos que hacen funcionar el programa almacenados (Datos)

Empiezo con la clase Datos, en la que implemento un Singleton utilizando un object para poner las variables que usaré 

Además utilizo un enum class para definir los estados del juego (EstadoJuego)


Seguimos con la ViewModel, donde utilizo LiveData para observar los cambios en el estado y estadoJuego, la diferencia es que en el primero mantengo el estado de los datos del juego, como la palabra q hay q adivinar, las pistas, sinonimos, rondas... este es un MutableLiveData de tipo Datos

En cambio en estadoJuego mantengo el estado del juego como tal, si ha Ganado Perdido o Adivinando, y es un MutableLiveData de tipo EstadoJuego

También implemento métodos para iniciar un nuevo juego, reiniciar el juego, obtener pistas y hacer una adivinanza.

Estos métodos actualizan los LiveData correspondientes para reflejar los cambios en el estado del juego  
