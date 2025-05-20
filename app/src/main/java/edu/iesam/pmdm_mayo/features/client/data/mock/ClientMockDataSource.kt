package edu.iesam.pmdm_mayo.features.client.data.mock

import edu.iesam.pmdm_mayo.features.client.domain.Client
import org.koin.core.annotation.Single

@Single
class ClientMockDataSource{
    fun getAllClients(): List<Client> {
        return listOf(
            Client(dni = "12345678A", name = "Laura Fernández", email = "laura.fernandez@email.com"),
            Client(dni = "23456789D", name = "Carlos Ruiz", email = "carlos.ruiz@email.com"),
            Client(dni = "34567890E", name = "Marta López", email = "marta.lopez@email.com"),
            Client(dni = "45678901G", name = "Sergio Gómez", email = "sergio.gomez@email.com"),
            Client(dni = "56789012H", name = "Ana Martínez", email = "ana.martinez@email.com"),
            Client(dni = "67890123F", name = "Iván Sánchez", email = "ivan.sanchez@email.com"),
            Client(dni = "78901234A", name = "Lucía Torres", email = "lucia.torres@email.com"),
            Client(dni = "89012345W", name = "David Romero", email = "david.romero@email.com"),
            Client(dni = "90123456H", name = "Elena Navarro", email = "elena.navarro@email.com"),
            Client(dni = "11223344L", name = "Raúl Ortega", email = "raul.ortega@email.com"),
            Client(dni = "22334455L", name = "Javier Morales", email = "javier.morales@email.com"),
            Client(dni = "33445566J", name = "Natalia Vega", email = "natalia.vega@email.com"),
            Client(dni = "44556677V", name = "Luis Herrera", email = "luis.herrera@email.com"),
            Client(dni = "55667788C", name = "Carmen Gil", email = "carmen.gil@email.com"),
            Client(dni = "66778899D", name = "Andrés Salas", email = "andres.salas@email.com")
        )
    }
}

