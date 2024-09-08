package com.example.simplecalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number1: EditText = findViewById(R.id.num1)
        val number2: EditText = findViewById(R.id.num2)
        val radioGroup: RadioGroup = findViewById(R.id.operatorGroup)
        val btnCalculate: Button = findViewById(R.id.btnCalculate)

        btnCalculate.setOnClickListener {
            val input1 = number1.text.toString().toDoubleOrNull()
            val input2 = number2.text.toString().toDoubleOrNull()

            if (input1 == null || input2 == null) {
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val result = when (radioGroup.checkedRadioButtonId) {
                R.id.add -> input1 + input2
                R.id.subtract -> input1 - input2
                R.id.multiply -> input1 * input2
                R.id.divide -> {
                    if (input2 != 0.0) {
                        input1 / input2
                    } else {
                        Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                }
                else -> {
                    Toast.makeText(this, "Please select an operation", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("result", result)
            intent.putExtra("nim", "225150400111024")
            intent.putExtra("name", "Muhammad Reihan Ghiffari")
            startActivity(intent)
        }
    }
}
