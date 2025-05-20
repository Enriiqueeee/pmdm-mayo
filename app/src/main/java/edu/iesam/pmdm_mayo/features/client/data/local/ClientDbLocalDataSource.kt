package edu.iesam.pmdm_mayo.features.client.data.local

import edu.iesam.pmdm_mayo.features.client.domain.Client
import org.koin.core.annotation.Single

@Single
class ClientDbLocalDataSource(private val clientDao: ClientDao) {

    suspend fun findAll():List<Client>{
        val entities = clientDao.findAll()
        return entities.map { it.toDomain() }
    }

    suspend fun saveAll(client: List<Client>){
        clientDao.saveAll(client.map { it.toEntity() })
    }

    suspend fun deleteClient(client: Client){
        clientDao.delete(client.toEntity())
    }

    suspend fun saveClient(client: Client) {
        clientDao.save(client.toEntity())
    }
}