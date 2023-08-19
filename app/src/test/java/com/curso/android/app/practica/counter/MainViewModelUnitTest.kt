package com.curso.android.app.practica.counter.view

import org.junit.Test
import org.junit.Assert.*

class MainViewModelTest {

    @Test
    fun testCompareTexts_equalTexts() {
        val viewModel = MainViewModel()

        val result = viewModel.compareTexts("Hello", "Hello")

        assertTrue(result)
    }

    @Test
    fun testCompareTexts_differentTexts() {
        val viewModel = MainViewModel()

        val result = viewModel.compareTexts("Hello", "World")

        assertFalse(result)
    }
}
