package edu.iesam.pmdm_mayo.features.client.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val TABLE_NAME = "Clients"

@Entity(tableName = TABLE_NAME)
data class ClientEntity (

    @PrimaryKey @ColumnInfo(name = "dni") val dni: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "email") val email: String
)