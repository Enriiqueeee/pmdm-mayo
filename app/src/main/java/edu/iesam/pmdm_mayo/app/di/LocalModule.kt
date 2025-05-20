package edu.iesam.pmdm_mayo.app.di

import android.content.Context
import androidx.room.Room
import edu.iesam.pmdm_mayo.app.data.local.db.ExamenDataBase
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan
class LocalModule {

    @Single
    fun provideDataBase(context: Context): ExamenDataBase{
        val db = Room.databaseBuilder(
            context,
            ExamenDataBase::class.java,
            "ExamenMayo"
        )
        db.fallbackToDestructiveMigration()
        return db.build()
    }
}