package com.example.sampleahmedov.feature.home.data.di

import com.example.sampleahmedov.feature.home.data.network.HomeApi
import com.example.sampleahmedov.feature.home.data.repository.HomeRepositoryImpl
import com.example.sampleahmedov.feature.home.domain.repository.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
abstract class HomeDataModule {

    @Binds
    @Singleton
    abstract fun bindHomeRepository(repository: HomeRepositoryImpl): HomeRepository

    companion object {
        @Provides
        @Singleton
        fun provideHomeApi(retrofit: Retrofit): HomeApi = retrofit.create()
    }
}
