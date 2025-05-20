package edu.iesam.pmdm_mayo.app.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.iesam.pmdm_mayo.features.client.data.local.ClientDao
import edu.iesam.pmdm_mayo.features.client.data.local.ClientEntity


@Database(
    entities = [ClientEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ExamenDataBase: RoomDatabase() {
    abstract fun clientDao(): ClientDao
}