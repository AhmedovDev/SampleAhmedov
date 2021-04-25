package com.example.sampleahmedov.feature.home.data.repository

import com.example.sampleahmedov.feature.home.data.network.HomeApi
import com.example.sampleahmedov.feature.home.data.network.HomeNetworkMapper
import com.example.sampleahmedov.feature.home.domain.model.Home
import com.example.sampleahmedov.feature.home.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeApi: HomeApi,
    private val homeNetworkMapper: HomeNetworkMapper
) : HomeRepository {

    override suspend fun getHome(since: Int): List<Home> {
        return homeApi.getHome(since)
            .let { home -> home.map { homeNetworkMapper.mapFrom(it) } }
    }
}