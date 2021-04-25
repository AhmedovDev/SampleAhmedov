package com.example.sampleahmedov.feature.home.data.network

import retrofit2.http.GET
import retrofit2.http.Query

interface HomeApi {
    @GET("repositories")
    suspend fun getHome(
        @Query("since") page: Int,
    ): List<HomeNetModel>
}