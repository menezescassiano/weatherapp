package com.menezes.weatherapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.menezes.weatherapp.data.model.WeatherResponse
import com.menezes.weatherapp.data.util.Resource
import com.menezes.weatherapp.domain.usecase.GetWeatherUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val getWeatherUseCase: GetWeatherUseCase) : ViewModel() {

    val newsHeadLines: MutableLiveData<Resource<WeatherResponse>> = MutableLiveData()

    fun getWeather() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val apiResult = getWeatherUseCase.execute("4418")
                newsHeadLines.postValue(apiResult)
            } catch (e: Exception) {
                newsHeadLines.postValue(Resource.Error(e.message.toString()))
            }
        }
    }
}
