package com.menezes.weatherapp.presentation.di

import com.menezes.weatherapp.data.api.WeatherAPIService
import com.menezes.weatherapp.data.repository.datasource.WeatherRemoteDataSource
import com.menezes.weatherapp.data.repository.datasourceimpl.WeatherRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideWeatherRemoteDataSource(weatherAPIService: WeatherAPIService): WeatherRemoteDataSource {
        return WeatherRemoteDataSourceImpl(weatherAPIService)
    }

}












