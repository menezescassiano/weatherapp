package com.menezes.weatherapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.menezes.weatherapp.data.model.WeatherResponse
import com.menezes.weatherapp.data.util.Resource
import com.menezes.weatherapp.domain.usecase.GetWeatherUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val getWeatherUseCase: GetWeatherUseCase) : ViewModel() {

    val weatherInfo: LiveData<Resource<WeatherResponse>>
        get() = _weatherInfo

    private val _weatherInfo: MutableLiveData<Resource<WeatherResponse>> = MutableLiveData()

    fun getWeather() {
        _weatherInfo.postValue(Resource.Loading())
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val apiResult = getWeatherUseCase.execute(TORONTO_ID)
                _weatherInfo.postValue(apiResult)
            } catch (e: Exception) {
                _weatherInfo.postValue(Resource.Error(e.message.toString()))
            }
        }
    }

    companion object {
        private const val TORONTO_ID = "4418"
    }
}
