package com.example.sampleahmedov.feature.home.domain

import com.example.sampleahmedov.feature.home.domain.usecase.GetHomeUseCase

interface HomeDomainProvider {
    fun getHomeUseCase(): GetHomeUseCase
}