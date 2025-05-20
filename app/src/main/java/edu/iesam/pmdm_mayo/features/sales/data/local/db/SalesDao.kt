package edu.iesam.pmdm_mayo.features.sales.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SalesDao {

    @Insert
    suspend fun save(sale: SaleEntity)

    @Query("SELECT * FROM $TABLE_SALES WHERE dni = :dni")
    suspend fun findByClient(dni: String): List<SaleEntity>
}