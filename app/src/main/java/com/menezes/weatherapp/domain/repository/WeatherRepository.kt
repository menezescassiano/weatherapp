package com.menezes.weatherapp.domain.repository

import com.menezes.weatherapp.data.util.Resource
import com.menezes.weatherapp.data.model.WeatherResponse


interface WeatherRepository {

    suspend fun getWeather(id: String): Resource<WeatherResponse>

}
