package edu.iesam.pmdm_mayo.features.sales.data.local.db

import edu.iesam.pmdm_mayo.features.client.data.local.ClientDao
import edu.iesam.pmdm_mayo.features.sales.model.Sales
import org.koin.core.annotation.Single

@Single
class SaleDbLocalDataSource(
    private val saleDao: SalesDao,
    private val clientDao: ClientDao
) {
    suspend fun saveSale(sale: Sales) {
        saleDao.save(sale.toEntity())
    }

    suspend fun getClientDnis(): List<String> {
        return clientDao.findAll().map { it.dni }
    }

    suspend fun getSalesByClient(dni: String): List<Sales>{
        return saleDao.findByClient(dni).map { it.toDomain() }
    }

}