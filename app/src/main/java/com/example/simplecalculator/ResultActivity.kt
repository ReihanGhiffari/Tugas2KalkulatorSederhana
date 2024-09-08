package com.example.simplecalculator

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity

class ResultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Get the result, NIM, and name from the intent
        val result = intent.getDoubleExtra("result", 0.0)
        val nim = intent.getStringExtra("nim")
        val name = intent.getStringExtra("name")

        // Initialize TextViews
        val resultTextView: TextView = findViewById(R.id.resultText)
        val nimTextView: TextView = findViewById(R.id.nimText)
        val nameTextView: TextView = findViewById(R.id.nameText)

        // Set the values to the TextViews
        resultTextView.text = "Result: $result"
        nimTextView.text = "NIM: $nim"
        nameTextView.text = "Name: $name"
    }
}
