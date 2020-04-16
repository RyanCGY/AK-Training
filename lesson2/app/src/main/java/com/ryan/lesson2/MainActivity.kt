package com.ryan.lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.text.isDigitsOnly

class MainActivity : AppCompatActivity() {

    private lateinit var resultText: TextView
    private lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultText = findViewById(R.id.result_text)
        diceImage = findViewById(R.id.dice_image)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val countUpButton: Button = findViewById(R.id.count_up_button)
        countUpButton.setOnClickListener { countUp() }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { reset() }
    }

    private fun rollDice() {
        val randomInt = (1..6).random()
        resultText.text = randomInt.toString()


        diceImage.setImageResource(getDiceDrawable(randomInt))
    }

    private fun countUp() {
        if (resultText.text.toString().isDigitsOnly()) {
            val resultInt = resultText.text.toString().toInt()
            resultText.text = if (resultInt < 6) {
                (resultInt + 1).toString()
            } else {
                "6"
            }

            diceImage.setImageResource(getDiceDrawable(resultInt + 1))
        }
    }

    private fun reset() {
        resultText.text = "0"

        diceImage.setImageResource(R.drawable.empty_dice)
    }

    private fun getDiceDrawable(num: Int): Int {
        return when (num) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}
