package edu.iesam.pmdm_mayo.features.client.domain

interface ClientRepository {
    suspend fun getClients(): List<Client>
    suspend fun deleteClient(client: Client)
    suspend fun saveClient(client: Client)
}