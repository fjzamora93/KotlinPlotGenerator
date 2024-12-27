package com.example.kotlinplotgenerator.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class Character(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0, // AutoIncrement

    val name: String,
    val description: String,

    // CAMBIAR EL SISTEMA A RELACIÓN ENTRE TABLAS
    //val stats: Map<String, Int>,
    //val spells: List<String> = listOf(),
    //val abilities: List<String> = listOf(),
    //val items: List<String> = listOf()
)