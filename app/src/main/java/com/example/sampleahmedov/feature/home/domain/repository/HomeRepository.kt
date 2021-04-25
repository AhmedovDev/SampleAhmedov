package com.example.sampleahmedov.feature.home.domain.repository

import com.example.sampleahmedov.feature.home.domain.model.Home

interface HomeRepository {
    suspend fun getHome(since: Int): List<Home>
}