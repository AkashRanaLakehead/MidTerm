package com.example.assignment1
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class CalculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1EditText = findViewById<TextInputEditText>(R.id.num1EditText)
        val num2EditText = findViewById<TextInputEditText>(R.id.num2EditText)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        val addButton = findViewById<Button>(R.id.addButton)
        val subtractButton = findViewById<Button>(R.id.subtractButton)
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val divideButton = findViewById<Button>(R.id.divideButton)

        addButton?.setOnClickListener {
            val result = performOperation(num1EditText?.text.toString(), num2EditText?.text.toString(), "add")
            resultTextView?.text = "Result: $result"
        }

        subtractButton?.setOnClickListener {
            val result = performOperation(num1EditText?.text.toString(), num2EditText?.text.toString(), "subtract")
            resultTextView?.text = "Result: $result"
        }

        multiplyButton?.setOnClickListener {
            val result = performOperation(num1EditText?.text.toString(), num2EditText?.text.toString(), "multiply")
            resultTextView?.text = "Result: $result"
        }

        divideButton?.setOnClickListener {
            val result = performOperation(num1EditText?.text.toString(), num2EditText?.text.toString(), "divide")
            resultTextView?.text = "Result: $result"
        }
    }

    private fun performOperation(num1: String, num2: String, operation: String): Double {
        val number1 = num1.toDoubleOrNull() ?: 0.0
        val number2 = num2.toDoubleOrNull() ?: 0.0

        return when (operation) {
            "add" -> number1 + number2
            "subtract" -> number1 - number2
            "multiply" -> number1 * number2
            "divide" -> if (number2 != 0.0) number1 / number2 else Double.NaN
            else -> 0.0
        }
    }
}
