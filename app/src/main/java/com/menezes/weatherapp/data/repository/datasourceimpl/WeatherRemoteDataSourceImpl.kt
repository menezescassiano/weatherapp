package com.menezes.weatherapp.data.repository.datasourceimpl

import com.menezes.weatherapp.data.api.WeatherAPIService
import com.menezes.weatherapp.data.model.WeatherResponse
import com.menezes.weatherapp.data.repository.datasource.WeatherRemoteDataSource
import retrofit2.Response

class WeatherRemoteDataSourceImpl(private val weatherAPIService: WeatherAPIService) :
    WeatherRemoteDataSource {

    override suspend fun getWeather(id: String): Response<WeatherResponse> {
        return weatherAPIService.getWeather(id)
    }

}
