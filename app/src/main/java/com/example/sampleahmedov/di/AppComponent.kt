package com.example.sampleahmedov.di

import android.content.Context
import com.example.sampleahmedov.di.module.AppModule
import com.example.sampleahmedov.di.module.NavigationModule
import com.example.sampleahmedov.feature.home.data.di.HomeDataModule
import com.example.sampleahmedov.library.coreapi.app.AppProvider
import com.example.sampleahmedov.library.coreimpl.network.di.NetworkModule
import com.example.sampleahmedov.ShopSampleApp
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        NavigationModule::class,
        HomeDataModule::class,
    ]
)
interface AppComponent : AppProvider {
    fun inject(app: ShopSampleApp)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}