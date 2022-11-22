package com.menezes.weatherapp.data.repository

import com.menezes.weatherapp.data.util.Resource
import com.menezes.weatherapp.data.repository.datasource.WeatherRemoteDataSource
import com.menezes.weatherapp.data.model.WeatherResponse
import com.menezes.weatherapp.domain.repository.WeatherRepository
import retrofit2.Response

class WeatherRepositoryImpl(private val weatherRemoteDataSource: WeatherRemoteDataSource) :
    WeatherRepository {

    override suspend fun getWeather(id: String): Resource<WeatherResponse> {
        return responseToResource(weatherRemoteDataSource.getWeather(id))
    }

    private fun responseToResource(response: Response<WeatherResponse>): Resource<WeatherResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }
}
