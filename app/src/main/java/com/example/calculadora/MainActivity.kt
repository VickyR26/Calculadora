package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //Para poder acceder a los ids de activity_main
    private lateinit var binding: ActivityMainBinding
    var firstValue: Double = 0.0
    var operator: Char ='0'
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //Hasta aqui listos para acceder a los ids

        binding.buttonClear.setOnClickListener{
            //Toast.makeText(this, "ejemplo", Toast.LENGTH_LONG).show()
            binding.editTextCalculo.text.clear()
        }

        binding.buttonDelete.setOnClickListener{
            binding.editTextCalculo.setText(binding.editTextCalculo.text.dropLast(1))
        }

        binding.buttonPorcentaje.setOnClickListener{
            binding.editTextCalculo.setText(porcentaje(operator))
        }

        binding.buttonIgual.setOnClickListener{
            when(operator){
                '+' -> {
                    binding.editTextCalculo.setText(
                    "${firstValue + binding.editTextCalculo.text.toString().toDouble()}"
                    )
                }
                '-' -> {
                    binding.editTextCalculo.setText(
                        "${firstValue - binding.editTextCalculo.text.toString().toDouble()}"
                    )
                }
                '×' -> {
                    binding.editTextCalculo.setText(
                        "${firstValue * binding.editTextCalculo.text.toString().toDouble()}"
                    )
                }
                '÷' -> {
                    binding.editTextCalculo.setText(
                        "${firstValue / binding.editTextCalculo.text.toString().toDouble()}"
                    )
                }
                else-> binding.editTextCalculo.setText("ERROR")
            }
            operator = '0'
            firstValue = 0.0
        }
    }

    fun porcentaje (operatorToUse: Char) : String {
        when (operatorToUse){
            '+' -> {return "${firstValue + (firstValue * binding.editTextCalculo.text.toString().toDouble()/100)}"}
            '-' -> {return "${firstValue - (firstValue * binding.editTextCalculo.text.toString().toDouble()/100)}"}
            '0' -> {return "${binding.editTextCalculo.text.toString().toDouble()/100}"}
            else-> {return "ERROR"}
        }
    }

    fun getOperator(view: View){
        val button = view as Button

        operator = button.text.get(0)

        /*
        operator = when(button.id){
            binding.buttonDivision.id -> { '÷' }
            binding.buttonMultiplicacion.id -> { '×' }
            binding.buttonSuma.id -> { '+' }
            binding.buttonResta.id -> { '-' }
            else -> { '0' }
        }
         */

        firstValue = binding.editTextCalculo.text.toString().toDouble()
        binding.editTextCalculo.text.clear()
    }


    fun numberButtonClicked(view: View) {
        val button = view as Button
        /*Opcion 1
        if(button.id.equals(binding.buttonDecimal.id) ){
            if( !binding.editTextCalculations.text.contains('.')){
                binding.editTextCalculations.text.append(button.text)
            }
        }else{
            binding.editTextCalculations.text.append(button.text)
        }
         */

        //Opcion 2
        when(button.id){
            binding.buttonDecimal.id -> {
                if (!binding.editTextCalculo.text.contains('.')) {
                    binding.editTextCalculo.text.append(".")
                }
            }
            binding.button0.id -> {binding.editTextCalculo.text.append("0")}
            binding.button1.id -> {binding.editTextCalculo.text.append("1")}
            binding.button2.id -> {binding.editTextCalculo.text.append("2")}
            binding.button3.id -> {binding.editTextCalculo.text.append("3")}
            binding.button4.id -> {binding.editTextCalculo.text.append("4")}
            binding.button5.id -> {binding.editTextCalculo.text.append("5")}
            binding.button6.id -> {binding.editTextCalculo.text.append("6")}
            binding.button7.id -> {binding.editTextCalculo.text.append("7")}
            binding.button8.id -> {binding.editTextCalculo.text.append("8")}
            binding.button9.id -> {binding.editTextCalculo.text.append("9")}
        }
    }


}