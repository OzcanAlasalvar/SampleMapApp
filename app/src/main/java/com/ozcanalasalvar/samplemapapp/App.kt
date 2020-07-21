package com.ozcanalasalvar.samplemapapp

import android.app.Application
import com.ozcanalasalvar.core.di.CoreComponent
import com.ozcanalasalvar.core.di.DaggerCoreComponent
import com.ozcanalasalvar.core.di.module.ContextModule
import com.ozcanalasalvar.samplemapapp.di.AppComponent
import com.ozcanalasalvar.samplemapapp.di.DaggerAppComponent

class App : Application() {

    private lateinit var component: AppComponent
    private lateinit var coreComponent: CoreComponent

    companion object {
        lateinit var INSTANCE: App
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        coreComponent = DaggerCoreComponent.builder()
            .contextModule(ContextModule(applicationContext))
            .build()

        component = DaggerAppComponent.builder()
            .coreComponent(coreComponent)
            .build()

        component.inject(this)

    }

    fun getAppComponent(): AppComponent = component

}