package com.example.novocompose.di

import com.example.novocompose.data.repo.DataRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesDataRepository(): DataRepo {
        return DataRepo()
    }
}