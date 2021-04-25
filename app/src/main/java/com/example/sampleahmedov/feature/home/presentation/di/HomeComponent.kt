package com.example.sampleahmedov.feature.home.presentation.di

import android.app.Activity
import com.example.sampleahmedov.feature.ScreenScope
import com.example.sampleahmedov.feature.home.presentation.HomeFragment
import com.example.sampleahmedov.library.coreapi.app.AppProvider
import com.example.sampleahmedov.library.coreapi.app.AppProviderHolder
import dagger.Component

@ScreenScope
@Component(
    modules = [HomeModule::class],
    dependencies = [AppProvider::class]
)
interface HomeComponent {
    fun inject(home: HomeFragment)

    companion object {
        fun create(activity: Activity): HomeComponent {
            val appProvider = (activity.application as AppProviderHolder).getAppProvider()
            return DaggerHomeComponent.builder()
                .appProvider(appProvider)
                .build()
        }
    }
}