package edu.iesam.pmdm_mayo.features.sales.di

import edu.iesam.pmdm_mayo.app.data.local.db.ExamenDataBase
import edu.iesam.pmdm_mayo.features.client.data.local.ClientDao
import edu.iesam.pmdm_mayo.features.sales.data.local.db.SalesDao
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("edu.iesam.pmdm_mayo.features.sales")
class SalesModule {

    @Single
    fun provideDataBase(db: ExamenDataBase): SalesDao {
        return db.salesDao()
    }
}