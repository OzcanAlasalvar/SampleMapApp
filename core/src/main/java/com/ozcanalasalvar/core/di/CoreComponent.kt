package com.ozcanalasalvar.core.di

import android.content.Context
import com.ozcanalasalvar.core.di.module.ContextModule
import com.ozcanalasalvar.core.di.module.NetworkModule
import com.ozcanalasalvar.core.network.service.Service
import com.ozcanalasalvar.core.repository.MapRepository
import com.ozcanalasalvar.core.di.module.RepositoryModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, RepositoryModule::class, ContextModule::class])
interface CoreComponent {

    fun context(): Context

    fun service(): Service

    fun placeRepository(): MapRepository

}