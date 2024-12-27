package com.example.kotlinplotgenerator.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlinplotgenerator.models.Character
import com.example.kotlinplotgenerator.models.CharacterDao
import com.example.kotlinplotgenerator.models.User
import com.example.kotlinplotgenerator.models.UserDao

@Database(entities = [User::class, Character::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun characterDao(): CharacterDao
    // abastract fun otroEntityDao(): otroEntityDao
}