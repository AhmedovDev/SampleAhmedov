package com.example.sampleahmedov.feature.home.data.network

import com.google.gson.annotations.SerializedName

data class HomeNetModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val nameRepository: String,
//    @SerializedName("login") val userName: String,
    @SerializedName("description") val description: String?,
)