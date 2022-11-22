package com.menezes.weatherapp.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.menezes.weatherapp.databinding.ActivityMainBinding
import com.menezes.weatherapp.presentation.viewmodel.MainViewModel
import com.menezes.weatherapp.presentation.viewmodel.MainViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: MainViewModelFactory
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        viewModel.getWeather()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.newsHeadLines.observe(this) { response ->
            binding.progressBar.isVisible = false
            binding.mainText.text = response.data?.title
        }
    }

}
