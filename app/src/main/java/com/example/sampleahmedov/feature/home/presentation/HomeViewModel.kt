package com.example.sampleahmedov.feature.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.sampleahmedov.feature.home.domain.model.Home
import com.example.sampleahmedov.feature.home.domain.usecase.GetHomeUseCase
import com.example.sampleahmedov.library.coreui.mvvm.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getHomeUseCase: GetHomeUseCase
) : BaseViewModel() {

    private val _emptyProgress = MutableLiveData<Boolean>()
    val emptyProgress: LiveData<Boolean> get() = _emptyProgress

    private val _home = MutableLiveData<Home>()
    val home: LiveData<Home> get() = _home

    init {
        loadHome()
    }

    private fun loadHome() {
        viewModelScope.launch {
            try {
                _emptyProgress.value = true
                val home = getHomeUseCase.invoke(1)
                _home.value = home[1]
            } catch (e: Exception) {
                e
            } finally {
                _emptyProgress.value = false
            }
        }
    }
}