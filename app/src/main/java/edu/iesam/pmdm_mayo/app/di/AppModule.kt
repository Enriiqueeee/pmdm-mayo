package edu.iesam.pmdm_mayo.app.di

import com.google.gson.Gson
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("edu.iesam.app")
class AppModule {

    @Single
    fun provideGson() = Gson()
}