package com.menezes.weatherapp.domain.usecase

import com.menezes.weatherapp.data.model.WeatherResponse
import com.menezes.weatherapp.data.util.Resource
import com.menezes.weatherapp.domain.repository.WeatherRepository

class GetWeatherUseCase(private val weatherRepository: WeatherRepository) {

    suspend fun execute(id: String): Resource<WeatherResponse> {
        return weatherRepository.getWeather(id)
    }

}
