package com.example.sampleahmedov.feature.home.presentation.di

import androidx.lifecycle.ViewModel
import com.example.sampleahmedov.feature.ScreenScope
import com.example.sampleahmedov.feature.home.presentation.HomeViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class HomeModule {

    @Binds
    @ScreenScope
    abstract fun bindViewModel(viewModel: HomeViewModel): ViewModel
}