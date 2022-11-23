package com.menezes.weatherapp.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.menezes.weatherapp.R
import com.menezes.weatherapp.data.util.Resource
import com.menezes.weatherapp.databinding.ActivityMainBinding
import com.menezes.weatherapp.presentation.util.UrlUtil
import com.menezes.weatherapp.presentation.viewmodel.MainViewModel
import com.menezes.weatherapp.presentation.viewmodel.MainViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlin.math.roundToInt

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
        setupListener()
        setupObservers()
    }

    private fun setupListener() {
        binding.errorMessage.setOnClickListener {
            viewModel.getWeather()
        }
    }

    private fun setupObservers() {
        viewModel.newsHeadLines.observe(this) { response ->
            when (response) {
                is Resource.Success -> {
                    binding.apply {
                        progressBar.isVisible = false
                        mainText.text = response.data?.title
                        temperatureText.text = getString(
                            R.string.current_temperature,
                            response.data?.consolidatedWeather?.first()?.theTemp?.roundToInt()
                        )
                        stateNameText.text =
                            response.data?.consolidatedWeather?.first()?.weatherStateName.orEmpty()
                        lowAndHighTemperatureText.text = getString(
                            R.string.low_and_high_temperatures,
                            response.data?.consolidatedWeather?.first()?.minTemp?.roundToInt(),
                            response.data?.consolidatedWeather?.first()?.maxTemp?.roundToInt()
                        )
                        Glide.with(binding.imageView.context)
                            .load(UrlUtil.imageUrlFormat(response.data?.consolidatedWeather?.first()?.weatherStateAbbr.orEmpty()))
                            .into(binding.imageView)
                    }
                }
                is Resource.Error -> {
                    binding.progressBar.isVisible = false
                    binding.errorMessage.isVisible = true
                }
                else -> {
                    binding.progressBar.isVisible = true
                }
            }
        }
    }

}
