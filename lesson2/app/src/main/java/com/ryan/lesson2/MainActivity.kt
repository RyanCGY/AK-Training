package com.ryan.lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.isDigitsOnly

class MainActivity : AppCompatActivity() {

    private lateinit var resultText: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultText = findViewById(R.id.result_text)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val countUpButton: Button = findViewById(R.id.count_up_button)
        countUpButton.setOnClickListener { countUp() }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { resultText.text = "0" }
    }

    private fun rollDice() {
        val randomInt = (1..6).random()
        resultText.text = randomInt.toString()
//        resultText.text = "Dice Rolled!"
//        Toast.makeText(this, "button clicked", Toast.LENGTH_LONG).show()
    }

    private fun countUp() {
        if (resultText.text.toString().isDigitsOnly()) {
            val resultInt = resultText.text.toString().toInt()
            resultText.text = if (resultInt < 6) {
                (resultInt + 1).toString()
            } else {
                "6"
            }
        }
    }
}
