package com.example.sampleahmedov.feature.main.presentation

import com.example.sampleahmedov.feature.home.presentation.navigation.HomeScreens
import com.example.sampleahmedov.library.coreui.mvvm.BaseViewModel
import me.aartikov.alligator.Navigator
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val navigator: Navigator,

    ) : BaseViewModel() {

    fun onStart() {
        navigator.switchTo(HomeScreens.Home)
    }

    fun onBackPressed() {
        navigator.goBack()
    }
}