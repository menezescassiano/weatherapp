package com.menezes.weatherapp.presentation.util

import com.menezes.weatherapp.BuildConfig

object UrlUtil {

    private const val ICONS_PATH = "icons/"
    private const val FORMAT_PATH = ".png"

    fun imageUrlFormat(string: String) = BuildConfig.BASE_URL + ICONS_PATH + string + FORMAT_PATH

}
