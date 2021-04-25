package com.example.sampleahmedov.library.coreapi.app

import android.content.Context
import com.example.sampleahmedov.feature.home.domain.HomeDomainProvider
import com.example.sampleahmedov.library.coreapi.navigation.NavigationProvider
import com.example.sampleahmedov.library.coreapi.network.NetworkProvider

interface AppProvider :
    NetworkProvider,
    NavigationProvider,
    HomeDomainProvider {

    fun context(): Context
}