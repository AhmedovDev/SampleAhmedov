package com.example.sampleahmedov

import com.example.sampleahmedov.feature.home.presentation.HomeFragment
import com.example.sampleahmedov.feature.home.presentation.navigation.HomeScreens
import me.aartikov.alligator.navigationfactories.RegistryNavigationFactory

class AppRegistryNavigationFactory : RegistryNavigationFactory() {

    init {
        registerFragment(HomeScreens.Home::class.java, HomeFragment::class.java)
    }
}