package com.example.kotlinplotgenerator.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "stats")
data class Stat(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val statName: String
)
