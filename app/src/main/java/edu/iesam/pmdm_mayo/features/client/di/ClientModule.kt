package edu.iesam.pmdm_mayo.features.client.di

import edu.iesam.pmdm_mayo.app.data.local.db.ExamenDataBase
import edu.iesam.pmdm_mayo.features.client.data.local.ClientDao
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan
class ClientModule {

    @Single
    fun provideDataBase(db: ExamenDataBase): ClientDao{
        return db.clientDao()
    }
}