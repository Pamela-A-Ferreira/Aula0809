package com.proflucas.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class IMC : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_imc)
        Toast.makeText(this, "Trocou para Calcular IMC!", Toast.LENGTH_SHORT).show()

        val txtAltura = findViewById<EditText>(R.id.txtAltura)
        val txtPeso = findViewById<EditText>(R.id.txtPeso)
        val labelCalcularIMC = findViewById<TextView>(R.id.labelCalcularIMC)
        val btnCalcularIMC = findViewById<Button>(R.id.btnCalcularIMC)

        btnCalcularIMC.setOnClickListener {
            // Pegar o texto do EditText
            val txtAltura = findViewById<EditText>(R.id.txtAltura)
            val txtPeso = findViewById<EditText>(R.id.txtPeso)
            val labelCalcularIMC = findViewById<TextView>(R.id.labelCalcularIMC)
            val btnCalcularIMC = findViewById<Button>(R.id.btnCalcularIMC)

            btnCalcularIMC.setOnClickListener {
                val altura = txtAltura.text.toString().toDoubleOrNull()
                val peso = txtPeso.text.toString().toDoubleOrNull()

                if (altura == null || peso == null) {
                    labelCalcularIMC.text = "Valor inválido"
                    return@setOnClickListener
                }

                val imc: Double? = (peso) / (altura * altura)
                labelCalcularIMC.text = "O seu IMC é: $imc"

                val btnSwitchToMedia = findViewById<Button>(R.id.btnLayoutMedia)

                btnSwitchToMedia.setOnClickListener {
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
        }
    }
}