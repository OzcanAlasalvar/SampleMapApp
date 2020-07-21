package com.ozcanalasalvar.core.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideContext(): Context = context
}