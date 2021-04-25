package com.example.sampleahmedov.library.coreapi.network

import retrofit2.Retrofit

interface NetworkProvider {
    fun retrofit(): Retrofit
}