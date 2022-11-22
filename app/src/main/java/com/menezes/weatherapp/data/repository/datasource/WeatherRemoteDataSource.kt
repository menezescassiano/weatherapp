package com.menezes.weatherapp.data.repository.datasource

import com.menezes.weatherapp.data.model.WeatherResponse
import retrofit2.Response

interface WeatherRemoteDataSource {

    suspend fun getWeather(id: String): Response<WeatherResponse>

}
