package com.example.practicaclase2

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicaclase2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calculateIMC()
    }

    private fun calculateIMC() {
        binding.btnCalculate.setOnClickListener {
            val height = binding.atHeight.text.toString().toDoubleOrNull()
            val weight = binding.atWeight.text.toString().toDoubleOrNull()

            if (height != null && weight != null) {
                val imc = weight / (height * height)

                val imcRange = when {
                    imc < 18.5 -> "Bajo Peso"
                    imc in 18.5..25.0 -> "Peso Normal"
                    imc in 25.0..29.9 -> "Sobrepeso"
                    imc >= 30 -> "Obesidad"
                    else -> {null}
                }
                binding.tvResultIMC.text = imcRange

            } else {
                Toast.makeText(this, "Por favor, ingrese valores válidos.",
                    Toast.LENGTH_LONG).show()
            }
        }
    }
}


