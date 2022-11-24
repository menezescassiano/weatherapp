package com.menezes.weatherapp.presentation.di

import com.menezes.weatherapp.domain.usecase.GetWeatherUseCase
import com.menezes.weatherapp.presentation.viewmodel.MainViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideMainViewModelFactory(getWeatherUseCase: GetWeatherUseCase): MainViewModelFactory {
        return MainViewModelFactory(getWeatherUseCase)
    }

}








