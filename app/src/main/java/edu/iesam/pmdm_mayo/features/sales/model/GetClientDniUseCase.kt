package edu.iesam.pmdm_mayo.features.sales.model

import org.koin.core.annotation.Single

@Single
class GetClientDnisUseCase(private val repository: SalesRepository) {
    suspend operator fun invoke(): List<String> {
        return repository.getClientDni()
    }
}