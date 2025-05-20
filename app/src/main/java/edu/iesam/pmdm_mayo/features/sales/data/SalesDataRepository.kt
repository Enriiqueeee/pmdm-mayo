package edu.iesam.pmdm_mayo.features.sales.data

import edu.iesam.pmdm_mayo.features.sales.data.local.db.SaleDbLocalDataSource
import edu.iesam.pmdm_mayo.features.sales.model.Sales
import edu.iesam.pmdm_mayo.features.sales.model.SalesRepository
import org.koin.core.annotation.Single

@Single
class SaleDataRepository(
    private val localDataSource: SaleDbLocalDataSource
) : SalesRepository {


    override suspend fun getClientDni(): List<String> {
        return localDataSource.getClientDnis()
    }

    override suspend fun saveSale(sale: Sales) {
        localDataSource.saveSale(sale)
    }
}