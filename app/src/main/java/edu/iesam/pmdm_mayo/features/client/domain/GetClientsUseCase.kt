package edu.iesam.pmdm_mayo.features.client.domain

import edu.iesam.pmdm_mayo.features.sales.model.SalesRepository
import org.koin.core.annotation.Single

@Single
class GetClientsUseCase(
    private val clientRepository: ClientRepository,
    private val salesRepository: SalesRepository
) {
    suspend operator fun invoke(): List<ClientFeed> {
        val clients = clientRepository.getClients()
        return clients.map { client ->
            val sales = salesRepository.getSalesByClient(client.dni)
            val isVip = sales.size >= 5
            ClientFeed(client, isVip)
        }
    }

    data class ClientFeed(
        val client: Client,
        val isVip: Boolean
    )
}
