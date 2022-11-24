package com.menezes.weatherapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.menezes.weatherapp.domain.usecase.GetWeatherUseCase

class MainViewModelFactory(private val getWeatherUseCase: GetWeatherUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(getWeatherUseCase) as T
    }
}
