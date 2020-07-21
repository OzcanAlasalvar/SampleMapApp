package com.ozcanalasalvar.core.di.module

import com.ozcanalasalvar.core.repository.MapRepository
import com.ozcanalasalvar.core.repository.data_source.RemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideRepository(
        remoteDataSource: RemoteDataSource
    ): MapRepository = MapRepository(remoteDataSource)

}