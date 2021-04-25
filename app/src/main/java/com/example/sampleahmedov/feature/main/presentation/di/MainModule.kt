package com.example.sampleahmedov.feature.main.presentation.di

import androidx.lifecycle.ViewModel
import com.example.sampleahmedov.feature.ScreenScope
import com.example.sampleahmedov.feature.main.presentation.MainViewModel
import com.example.sampleahmedov.library.coreui.mvvm.ViewModelModule
import dagger.Binds
import dagger.Module

@Module(includes = [ViewModelModule::class])
abstract class MainModule {

    @Binds
    @ScreenScope
    abstract fun bindViewModel(viewModel: MainViewModel): ViewModel
}
