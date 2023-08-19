package com.curso.android.app.practica.counter.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.curso.android.app.practica.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            compararTextos()
        }
    }

    private fun compararTextos() {
        val texto1 = binding.text.text.toString()
        val texto2 = binding.texts.text.toString()

        val comparacion = mainViewModel.compareTexts(texto1, texto2)

        if (comparacion) {
            binding.comparar.text = "Los textos son iguales."
        } else {
            binding.comparar.text = "Los textos son diferentes."
        }
    }
}

