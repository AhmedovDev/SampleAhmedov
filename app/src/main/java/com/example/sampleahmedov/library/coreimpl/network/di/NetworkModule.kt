package com.example.sampleahmedov.library.coreimpl.network.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
abstract class NetworkModule {

    companion object {
        @Provides
        @Singleton
        fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
            .build()

        @Provides
        @Singleton
        fun provideGson(): Gson =
            GsonBuilder()
                .setLenient()
                .create()

        @Provides
        @Singleton
        fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit =
            Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }
}