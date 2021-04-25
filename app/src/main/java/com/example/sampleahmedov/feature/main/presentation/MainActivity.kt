package com.example.sampleahmedov.feature.main.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.sampleahmedov.R
import com.example.sampleahmedov.databinding.ActivityMainBinding
import com.example.sampleahmedov.feature.main.presentation.di.MainComponent
import com.example.sampleahmedov.library.coreui.base.BaseActivity
import com.example.sampleahmedov.library.coreui.navigation.ContainerIdProvider
import me.aartikov.alligator.NavigationContext
import me.aartikov.alligator.NavigationContextBinder
import me.aartikov.alligator.Screen
import me.aartikov.alligator.navigationfactories.NavigationFactory
import me.aartikov.alligator.screenswitchers.FragmentScreenSwitcher
import javax.inject.Inject

class MainActivity : BaseActivity(R.layout.activity_main) {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<MainViewModel> { viewModelFactory }

    @Inject lateinit var navigationFactory: NavigationFactory
    @Inject lateinit var navigationContextBinder: NavigationContextBinder

    private val screenSwitcher by lazy {
        FragmentScreenSwitcher(
            navigationFactory,
            supportFragmentManager,
            R.id.main_container
        )
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        MainComponent
            .create(this)
            .inject(this)
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            viewModel.onStart()
        }
        setupView()
        setupViewModel()
    }

    private fun setupView() {
        binding = ActivityMainBinding.bind(findViewById(R.id.main_root_container))

    }

    private fun setupViewModel() {
        with(viewModel) {
        }
    }

    override fun onResume() {
        super.onResume()
        bindNavigationContext()
    }

    private fun bindNavigationContext() {
        val builder = NavigationContext.Builder(this, navigationFactory)
            .screenSwitcher(screenSwitcher)
            .screenSwitchingListener { _, screenTo: Screen ->
                bindNavigationContext()
            }
        val fragment = screenSwitcher.currentFragment
        if (fragment is ContainerIdProvider) {
            builder.fragmentNavigation(fragment.childFragmentManager, fragment.containerId)
        }

        navigationContextBinder.bind(builder.build())
    }

    override fun onPause() {
        navigationContextBinder.unbind(this)
        super.onPause()
    }

    override fun onBackPressed() {
        viewModel.onBackPressed()
    }
}