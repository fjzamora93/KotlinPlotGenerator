package com.example.kotlinplotgenerator.models.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.kotlinplotgenerator.models.CharacterStatCrossRef
import com.example.kotlinplotgenerator.models.Stat

data class CharacterWithStats(
    @Embedded val character: Character,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            CharacterStatCrossRef::class,
            parentColumn = "characterId",
            entityColumn = "statId"
        )
    )
    val stats: List<StatWithValues>
)

data class StatWithValues(
    @Embedded val stat: Stat,
    val value: Int // Valor del stat para este personaje
)
