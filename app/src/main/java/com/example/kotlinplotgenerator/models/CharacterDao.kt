package com.example.kotlinplotgenerator.models

import androidx.room.*
import com.example.kotlinplotgenerator.models.relations.CharacterWithStats

@Dao
interface CharacterDao {
    @Insert
    suspend fun insertUser(char: Character): Long

    @Insert
    suspend fun insertStat(stat: Stat)

    @Query("SELECT * FROM characters")
    suspend fun getAllCharacters(): List<Character>



    @Update
    suspend fun updateCharacter(char: Character)

    @Delete
    suspend fun deleteCharacter(char: Character)

    // CONSULTAS CRUZADAS

    @Insert
    suspend fun insertCharacterStatCrossRef(crossRef: CharacterStatCrossRef)

    @Transaction
    @Query("SELECT * FROM characters WHERE id = :characterId")
    suspend fun getCharacterWithStats(characterId: Int): CharacterWithStats
}