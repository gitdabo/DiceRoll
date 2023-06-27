package com.example.diceroll

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        val diceImage : ImageView = findViewById(R.id.imageView)
        diceImage.setImageResource(R.drawable.dice_2)

        rollButton.setOnClickListener()
        {
            var diceRolled = Dice(6).roll()

            val toast = Toast.makeText(this, "Dice Rolled $diceRolled", Toast.LENGTH_SHORT)
            toast.show()

            val drawableResource = when(diceRolled)
            {
                1-> R.drawable.dice_1
                2-> R.drawable.dice_2
                3-> R.drawable.dice_3
                4-> R.drawable.dice_4
                5-> R.drawable.dice_5
                else -> R.drawable.dice_6
            }

            diceImage.setImageResource(drawableResource)
        }

    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}