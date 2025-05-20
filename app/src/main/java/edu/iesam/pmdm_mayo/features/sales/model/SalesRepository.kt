package edu.iesam.pmdm_mayo.features.sales.model

interface SalesRepository {
    suspend fun getClientDni(): List<String>
    suspend fun saveSale(sale: Sales)
}