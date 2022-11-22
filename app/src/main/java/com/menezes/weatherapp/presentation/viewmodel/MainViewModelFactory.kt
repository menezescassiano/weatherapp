package com.menezes.weatherapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.menezes.weatherapp.domain.usecase.GetWeatherUseCase

class MainViewModelFactory(private val getNewsHeadlinesUseCase: GetWeatherUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(getNewsHeadlinesUseCase) as T
    }
}









