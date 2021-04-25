package com.example.sampleahmedov.feature.home.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.sampleahmedov.feature.home.domain.model.Home
import com.example.sampleahmedov.feature.home.presentation.di.HomeComponent
import com.example.sampleahmedov.library.coreui.base.BaseFragment
import com.example.sampleahmedov.library.coreui.mvvm.ViewModelFactory
import com.example.sampleahmedov.R
import com.example.sampleahmedov.databinding.FragmentHomeBinding
import javax.inject.Inject

class HomeFragment : BaseFragment(R.layout.fragment_home) {

    @Inject lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by viewModels<HomeViewModel> { viewModelFactory }

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        HomeComponent
            .create(requireActivity())
            .inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupViewModel()
    }

    private fun setupView() {
        _binding = FragmentHomeBinding.bind(requireView())
        with(binding) {
            // установка клик листенеров и т.п.
        }
    }

    private fun setupViewModel() {
        with(viewModel) {
            emptyProgress.observe(viewLifecycleOwner) { showEmptyProgress(it) }
            home.observe(viewLifecycleOwner) { showHome(it) }
        }
    }

    private fun showEmptyProgress(show: Boolean) {
        binding.homeProgressBar.isVisible = show
    }

    private fun showHome(home: Home) {
        binding.homeLabel.text = home.nameRepository
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}