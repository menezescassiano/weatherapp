package com.menezes.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class ConsolidatedWeather(
    @SerializedName("weather_state_name")
    val weatherStateName: String,
    @SerializedName("weather_state_abbr")
    val weatherStateAbbr: String,
    @SerializedName("min_temp")
    val minTemp: Float,
    @SerializedName("max_temp")
    val maxTemp: Float,
    @SerializedName("the_temp")
    val theTemp: Float
)
