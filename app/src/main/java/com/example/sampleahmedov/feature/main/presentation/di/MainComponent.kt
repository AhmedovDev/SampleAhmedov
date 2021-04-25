package com.example.sampleahmedov.feature.main.presentation.di

import android.app.Activity
import com.example.sampleahmedov.feature.ScreenScope
import com.example.sampleahmedov.feature.main.presentation.MainActivity
import com.example.sampleahmedov.library.coreapi.app.AppProvider
import com.example.sampleahmedov.library.coreapi.app.AppProviderHolder
import dagger.Component

@ScreenScope
@Component(
    modules = [MainModule::class],
    dependencies = [AppProvider::class],
)
interface MainComponent {
    fun inject(main: MainActivity)

    @Component.Builder
    interface Builder {
        fun appProvider2(appProvider: AppProvider): Builder

        fun build(): MainComponent
    }

    companion object {
        fun create(activity: Activity): MainComponent {
            val appProvider = (activity.application as AppProviderHolder).getAppProvider()
            return DaggerMainComponent.builder()
                .appProvider2(appProvider)
                .build()
        }
    }
}
