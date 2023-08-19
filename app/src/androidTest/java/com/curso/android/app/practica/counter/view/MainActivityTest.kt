package com.curso.android.app.practica.counter.view

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @After
    fun cleanup() {
        scenario.moveToState(Lifecycle.State.DESTROYED)
    }

    @Test
    fun testComparingTexts() {
        scenario.onActivity { activity ->
            val viewModel = activity.mainViewModel

            activity.binding.text.setText("Texto de prueba izquierdo")
            activity.binding.texts.setText("Texto de prueba derecho")
            activity.binding.button.performClick()

            val expectedText = if (viewModel.compareTexts("Texto de prueba izquierdo", "Texto de prueba derecho")) {
                "Los textos son iguales."
            } else {
                "Los textos son diferentes."
            }

            assert(activity.binding.comparar.text == expectedText)
        }
    }
}