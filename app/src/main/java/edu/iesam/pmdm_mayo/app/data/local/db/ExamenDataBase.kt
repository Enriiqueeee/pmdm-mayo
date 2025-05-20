package edu.iesam.pmdm_mayo.app.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.iesam.pmdm_mayo.features.client.data.local.ClientDao
import edu.iesam.pmdm_mayo.features.client.data.local.ClientEntity
import edu.iesam.pmdm_mayo.features.sales.data.local.db.SaleEntity
import edu.iesam.pmdm_mayo.features.sales.data.local.db.SalesDao


@Database(
    entities = [ClientEntity::class, SaleEntity::class],
    version = 5,
    exportSchema = false
)
abstract class ExamenDataBase: RoomDatabase() {
    abstract fun clientDao(): ClientDao
    abstract fun salesDao(): SalesDao
}