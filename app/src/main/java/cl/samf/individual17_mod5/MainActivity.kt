package cl.samf.individual17_mod5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import cl.samf.individual17_mod5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val divisas = listOf<String>("USD", "CLP", "EUR")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.spinnerInic.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, divisas)
        binding.spinnerReem.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, divisas)

        initListener()
    }

    private fun initListener() {
        binding.buttonConvert.setOnClickListener {
            val cantidad = binding.editTextIngreso.text.toString().toDouble()
            val divisaInicial = binding.spinnerInic.selectedItem.toString()
            val divisaCambio = binding.spinnerReem.selectedItem.toString()
            Log.d("aguaite", "$cantidad $divisaInicial $divisaCambio")
            val resultado = conversorDivisas(cantidad, divisaInicial, divisaCambio)
            binding.textViewResult.text = resultado.toString()

        }
        binding.buttonReset.setOnClickListener{
            limpiar()
        }
    }

    fun conversorDivisas(cantidad: Double, divisaInicial: String, divisaCambio: String): Double {
        var resultado = cantidad
        when (divisaInicial) {
            "USD" -> if (divisaCambio == "CLP") {
                resultado = cantidad * 817
            } else if (divisaCambio == "USD") {
                resultado = cantidad * 1
            } else if (divisaCambio == "EUR") {
                resultado = cantidad * 0.89
            }


            "CLP" -> if (divisaCambio == "CLP") {
                resultado = cantidad * 1
            } else if (divisaCambio == "USD") {
                resultado = cantidad * 0.001
            } else if (divisaCambio == "EUR") {
                resultado = cantidad * 0.01
            }

            "EUR" -> if (divisaCambio == "CLP") {
                resultado = cantidad * 910
            } else if (divisaCambio == "USD") {
                resultado = cantidad * 1.11
            } else if (divisaCambio == "EUR") {
                resultado = cantidad * 1
            }

            else -> {
                resultado = cantidad
            }
        }

            return resultado
        }
        fun limpiar(){
            binding.textViewResult.text = ""
            binding.editTextIngreso.setText("")
        }
    }
