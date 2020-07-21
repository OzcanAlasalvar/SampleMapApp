package com.ozcanalasalvar.samplemapapp.di

import com.ozcanalasalvar.core.di.CoreComponent
import com.ozcanalasalvar.core.di.scope.AppScope
import com.ozcanalasalvar.samplemapapp.ui.search.SearchFragment
import com.ozcanalasalvar.samplemapapp.App
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class]
)
interface AppComponent {

    fun inject(application: App)
    fun inject(searchFragment: SearchFragment)

}