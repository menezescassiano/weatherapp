package com.menezes.weatherapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.menezes.weatherapp.commonstest.CoroutinesTestRule
import com.menezes.weatherapp.data.model.ConsolidatedWeather
import com.menezes.weatherapp.data.model.WeatherResponse
import com.menezes.weatherapp.data.util.Resource
import com.menezes.weatherapp.domain.usecase.GetWeatherUseCase
import com.menezes.weatherapp.presentation.viewmodel.MainViewModel
import io.mockk.coEvery
import io.mockk.coVerifyOrder
import io.mockk.mockk
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineTestRule = CoroutinesTestRule()

    private lateinit var viewModel: MainViewModel
    private val weatherInfoMock: Observer<Resource<WeatherResponse>> = mockk(relaxed = true)
    private val getWeatherUseCaseMock : GetWeatherUseCase = mockk(relaxed = true)

    @Before
    fun `Setup test`() {
        viewModel = MainViewModel(getWeatherUseCaseMock)
        setupLiveDataObservables()
    }

  private fun setupLiveDataObservables() {
        viewModel.apply {
            weatherInfo.observeForever(weatherInfoMock)
        }
    }
    @Test
    fun `Test getWeather() behaviour`() {

        val apiResult =
            WeatherResponse(title = "Toronto", listOf(ConsolidatedWeather("oi", "oi", 1f, 1f, 1f)))
        coEvery { getWeatherUseCaseMock.execute("1234") } returns Resource.Success(apiResult)

        viewModel.getWeather()

        coVerifyOrder {
            weatherInfoMock.onChanged(Resource.Loading())
            weatherInfoMock.onChanged(Resource.Success(apiResult))
        }

    }
}
