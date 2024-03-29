package com.menezes.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("title")
    val title: String,
    @SerializedName("consolidated_weather")
    val consolidatedWeather: List<ConsolidatedWeather>
)
