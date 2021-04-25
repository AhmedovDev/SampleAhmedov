package com.example.sampleahmedov.library.coreui.mvvm

import androidx.lifecycle.ViewModelProvider
import com.example.sampleahmedov.library.coreui.mvvm.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
