package edu.iesam.pmdm_mayo.features.sales.model

import org.koin.core.annotation.Single

@Single
class SaveSaleUseCase(private val repository: SalesRepository) {
   suspend operator fun invoke(sale: Sales) {
        repository.saveSale(sale)
    }
}