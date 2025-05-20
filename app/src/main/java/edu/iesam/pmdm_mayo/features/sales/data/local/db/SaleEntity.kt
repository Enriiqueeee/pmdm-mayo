package edu.iesam.pmdm_mayo.features.sales.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val TABLE_SALES = "sales"

@Entity(tableName = TABLE_SALES)
data class SaleEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name= "dni" ) val dni: String,
    @ColumnInfo(name= "conceptSales" ) val conceptSales: String,
    @ColumnInfo(name= "totalSales" ) val totalSales: Double
)