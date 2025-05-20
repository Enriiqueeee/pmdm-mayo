package edu.iesam.pmdm_mayo.features.client.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ClientDao {
    @Query("SELECT * FROM $TABLE_NAME")
    suspend fun findAll(): List<ClientEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAll(vararg client: List<ClientEntity>)

    @Delete
    suspend fun delete(client: ClientEntity)
}