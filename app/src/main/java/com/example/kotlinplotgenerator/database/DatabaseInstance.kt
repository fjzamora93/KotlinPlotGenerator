package com.example.kotlinplotgenerator.database

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

object DatabaseInstance {

    @Volatile
    private var INSTANCE: AppDatabase? = null

    // Define tus migraciones fuera del bloque synchronized
    val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            // Ejemplo de migración: añadir la columna "email"
            database.execSQL("ALTER TABLE users ADD COLUMN email TEXT")
        }
    }

    fun getDatabase(context: Context): AppDatabase {
        // Si la instancia ya está creada, la devuelve
        return INSTANCE ?: synchronized(this) {
            // Si la instancia aún no ha sido creada, la crea
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "app_database"  // Nombre de la base de datos
            )
                .addMigrations(MIGRATION_1_2)  // Agrega tu migración aquí
                .build()
            INSTANCE = instance
            instance
        }
    }
}