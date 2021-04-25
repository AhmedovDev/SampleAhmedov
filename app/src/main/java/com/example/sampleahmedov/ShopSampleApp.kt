package com.example.sampleahmedov

import android.app.Application
import com.example.sampleahmedov.di.AppComponent
import com.example.sampleahmedov.di.DaggerAppComponent
import com.example.sampleahmedov.library.coreapi.app.AppProvider
import com.example.sampleahmedov.library.coreapi.app.AppProviderHolder

class ShopSampleApp : Application(), AppProviderHolder {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        (getAppProvider() as AppComponent).inject(this)
    }

    override fun getAppProvider(): AppProvider {
        if (!::appComponent.isInitialized) {
            appComponent = DaggerAppComponent
                .factory()
                .create(applicationContext)
        }
        return appComponent
    }
}