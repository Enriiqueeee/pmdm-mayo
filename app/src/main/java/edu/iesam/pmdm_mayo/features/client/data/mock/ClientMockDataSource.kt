package edu.iesam.pmdm_mayo.features.client.data.mock

import edu.iesam.pmdm_mayo.features.client.domain.Client
import org.koin.core.annotation.Single

@Single
class ClientMockDataSource{
    fun getAllClients(): List<Client> {
        return listOf(
            Client(dni = 12345678, name = "Laura Fernández", email = "laura.fernandez@email.com"),
            Client(dni = 23456789, name = "Carlos Ruiz", email = "carlos.ruiz@email.com"),
            Client(dni = 34567890, name = "Marta López", email = "marta.lopez@email.com"),
            Client(dni = 45678901, name = "Sergio Gómez", email = "sergio.gomez@email.com"),
            Client(dni = 56789012, name = "Ana Martínez", email = "ana.martinez@email.com"),
            Client(dni = 67890123, name = "Iván Sánchez", email = "ivan.sanchez@email.com"),
            Client(dni = 78901234, name = "Lucía Torres", email = "lucia.torres@email.com"),
            Client(dni = 89012345, name = "David Romero", email = "david.romero@email.com"),
            Client(dni = 90123456, name = "Elena Navarro", email = "elena.navarro@email.com"),
            Client(dni = 11223344, name = "Raúl Ortega", email = "raul.ortega@email.com")
        )
    }
}

