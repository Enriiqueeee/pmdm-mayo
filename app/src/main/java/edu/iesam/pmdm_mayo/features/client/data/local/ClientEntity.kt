package edu.iesam.pmdm_mayo.features.client.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val TABLE_ClIENTS = "Clients"

@Entity(tableName = TABLE_ClIENTS)
data class ClientEntity (
    @PrimaryKey @ColumnInfo(name = "dni") val dni: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "email") val email: String
)