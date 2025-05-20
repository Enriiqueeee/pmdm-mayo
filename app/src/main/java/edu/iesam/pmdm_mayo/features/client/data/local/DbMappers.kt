package edu.iesam.pmdm_mayo.features.client.data.local

import edu.iesam.pmdm_mayo.features.client.domain.Client

fun Client.toEntity(): ClientEntity{
    return ClientEntity(
        this.dni,
        this.name,
        this.email
    )
}

fun ClientEntity.toDomain(): Client{
    return Client(
        this.dni,
        this.name,
        this.email
    )
}