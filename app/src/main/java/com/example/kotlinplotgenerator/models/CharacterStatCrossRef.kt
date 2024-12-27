package com.example.kotlinplotgenerator.models
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "character_stats",
    primaryKeys = ["characterId", "statId"],
    foreignKeys = [
        ForeignKey(
            entity = Character::class,
            parentColumns = ["id"],
            childColumns = ["characterId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Stat::class,
            parentColumns = ["id"],
            childColumns = ["statId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class CharacterStatCrossRef(
    val characterId: Int,
    val statId: Int,
    var value: Int // Valor del stat para este personaje, por ejemplo: 10
)
