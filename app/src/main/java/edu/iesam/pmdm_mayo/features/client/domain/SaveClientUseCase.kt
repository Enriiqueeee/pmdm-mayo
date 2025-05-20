package edu.iesam.pmdm_mayo.features.client.domain


import org.koin.core.annotation.Single

@Single
class SaveClientUseCase(private val repository: ClientRepository) {
    suspend operator fun invoke(client: Client) {
        repository.saveClient(client)
    }
}
