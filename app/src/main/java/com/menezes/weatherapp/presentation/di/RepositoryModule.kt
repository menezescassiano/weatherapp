package com.menezes.weatherapp.presentation.di

import com.menezes.weatherapp.data.repository.datasource.WeatherRemoteDataSource
import com.menezes.weatherapp.domain.repository.WeatherRepository
import com.menezes.weatherapp.data.repository.WeatherRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        newsRemoteDataSource: WeatherRemoteDataSource
    ): WeatherRepository {
        return WeatherRepositoryImpl(newsRemoteDataSource)
    }
}














