package edu.iesam.pmdm_mayo.features.sales.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface SalesDao {

    @Insert
    fun save(sale: SaleEntity)
}