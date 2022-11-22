package com.menezes.weatherapp.data.api

import com.menezes.weatherapp.data.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherAPIService {

    @GET("{id}.json")
    suspend fun getWeather(@Path("id") id: String): Response<WeatherResponse>

}
