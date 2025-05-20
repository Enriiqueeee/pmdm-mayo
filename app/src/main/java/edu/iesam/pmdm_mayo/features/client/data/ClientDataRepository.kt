package edu.iesam.pmdm_mayo.features.client.data

import edu.iesam.pmdm_mayo.features.client.data.local.ClientDbLocalDataSource
import edu.iesam.pmdm_mayo.features.client.data.mock.ClientMockDataSource
import edu.iesam.pmdm_mayo.features.client.domain.Client
import edu.iesam.pmdm_mayo.features.client.domain.ClientRepository
import org.koin.core.annotation.Single

@Single
class ClientDataRepository(private val db: ClientDbLocalDataSource, private val mock: ClientMockDataSource): ClientRepository {
    override suspend fun getClients(): List<Client> {
        val local = db.findAll()
        if (local.isEmpty()){
            val remote = mock.getAllClients()
            db.saveAll(remote)
            return remote
        }
        return local
    }

    override suspend fun deleteClient(client: Client) {
        return db.deleteClient(client)
    }
}