package edu.iesam.pmdm_mayo.app.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [],
    version = 1,
    exportSchema = false
)
abstract class ExamenDataBase: RoomDatabase() {
    abstract fun clientDao(): ClientDao
}