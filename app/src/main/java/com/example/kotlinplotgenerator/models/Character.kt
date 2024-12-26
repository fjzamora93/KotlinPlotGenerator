package com.example.kotlinplotgenerator.models

data class Character(
    val id: String,
    val name: String,
    val description: String,
    val stats: Map<String, Int>,
    val spells: List<String> = listOf(),
    val abilities: List<String> = listOf(),
    val items: List<String> = listOf()
)