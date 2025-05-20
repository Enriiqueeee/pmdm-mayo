package edu.iesam.pmdm_mayo.app

import android.app.Application
import edu.iesam.pmdm_mayo.app.di.AppModule
import edu.iesam.pmdm_mayo.app.di.LocalModule
import edu.iesam.pmdm_mayo.features.client.di.ClientModule
import edu.iesam.pmdm_mayo.features.sales.di.SalesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class ExamenApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@ExamenApp)
            modules(
                AppModule().module,
                LocalModule().module,
                ClientModule().module,
                SalesModule().module
            )
        }

    }
}