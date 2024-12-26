package com.example.kotlinplotgenerator

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State



/***
 * En Kotlin, este mapeo está utilizando un mutableStateOf para crear un
 * estado reactivo que contiene un mapa (Map) de estadísticas de un personaje.
 *
 * Vamos a desglosarlo:
 *
 * mutableStateOf: Es una función proporcionada por Jetpack Compose
 * (una biblioteca para interfaces de usuario en Kotlin) que crea una variable
 * que puede ser observada y reactiva a cambios. Es decir, cualquier cambio
 * en el valor de esta variable notificará automáticamente a las partes del
 * código que estén observando ese estado.
 *
 * El mapa (Map): En este caso, el mapa tiene como claves los nombres
 * de las estadísticas del personaje (como "Destreza", "Fuerza", etc.)
 * y como valores, los valores numéricos asociados a esas estadísticas
 * (todos comenzando en 0). Es un mapeo de cadenas (String) a enteros (Int),
 * que representa el valor de cada atributo del personaje.
 *
 * _stats: Es la variable interna que almacena el estado mutable.
 * Se define como un mutableStateOf, lo que permite cambiar su valor
 * y que esas actualizaciones se reflejen en la interfaz de usuario
 * si esta está observando este estado.
 *
 * stats: Es una propiedad que expone el estado de _stats de manera inmutable
 * a través de un State. Esto significa que otras partes del código pueden
 * leer el valor de stats pero no pueden modificar directamente _stats.
 * Es una práctica común en programación reactiva para proteger el estado
 * mutable de modificaciones directas desde fuera de la clase.
 */

data class Character(
    val id: String,
    val name: String,
    val stats: Map<String, Int>,
    val spells: List<String> = listOf(),
    val abilities: List<String> = listOf(),
    val items: List<String> = listOf()
)


class CharCreatorViewModel : ViewModel() {

    val character = mutableStateOf(
        Character(
            id = "1",
            name = "Hero",
            stats = mapOf(
                "Destreza" to 0,
                "Fuerza" to 0,
                "Constitución" to 0,
                "Inteligencia" to 0,
                "Sabiduría" to 0,
                "Carisma" to 0
            )
        )
    )

    // Método para actualizar una estadística
    fun updateStat(statName: String, newValue: Int) {
        // Creamos una copia mutable del mapa de stats
        val updatedStats = character.value.stats.toMutableMap()

        // Modificamos la estadística que queremos actualizar
        updatedStats[statName] = newValue

        // Actualizamos el valor del estado (Character) con el mapa actualizado
        character.value = character.value.copy(stats = updatedStats)
    }


    // Incrementar una estadística
    fun incrementStat(statName: String) {
        val currentValue = character.value.stats[statName] ?: 0
        updateStat(statName, currentValue + 1)
    }


    // Decrementar una estadística
    fun decrementStat(statName: String) {
        val currentValue = character.value.stats[statName] ?: 0
        updateStat(statName, currentValue - 1)
    }

}