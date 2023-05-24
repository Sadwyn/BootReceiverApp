package com.example.bootreceiverapp.di

import android.content.Context
import androidx.room.Room
import com.example.bootreceiverapp.data.AppDatabase
import com.example.bootreceiverapp.data.BootDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideContext(@ApplicationContext applicationContext: Context): Context {
        return applicationContext;
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext applicationContext: Context): AppDatabase {
        return Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "boot-database"
        ).build()
    }

    @Singleton
    @Provides
    fun providesDao(appDatabase: AppDatabase): BootDAO {
        return appDatabase.bootDAO()
    }
}