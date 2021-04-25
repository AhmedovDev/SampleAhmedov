package com.example.sampleahmedov.feature.home.data.network

import com.example.sampleahmedov.feature.home.domain.model.Home
import javax.inject.Inject

class HomeNetworkMapper @Inject constructor() {

    fun mapFrom(model: HomeNetModel) = Home(
        id = model.id,
        nameRepository = model.nameRepository,
//        userName = model.userName,
        description = model.description.orEmpty()
    )
}