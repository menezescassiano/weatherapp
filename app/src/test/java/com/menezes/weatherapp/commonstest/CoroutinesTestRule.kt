package com.menezes.weatherapp.commonstest

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

@ExperimentalCoroutinesApi
class CoroutinesTestRule : TestRule {

    private val testDispatcher = TestCoroutineDispatcher()

    override fun apply(base: Statement?, description: Description?) = object : Statement() {
        override fun evaluate() {
            Dispatchers.setMain(testDispatcher)
            base?.evaluate()
        }
    }
}
