package com.example.sampleahmedov.feature.home.domain.usecase

import com.example.sampleahmedov.feature.home.domain.model.Home
import com.example.sampleahmedov.feature.home.domain.repository.HomeRepository
import javax.inject.Inject

class GetHomeUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {

    suspend fun invoke(since: Int): List<Home> {
        return homeRepository.getHome(since)
    }
}