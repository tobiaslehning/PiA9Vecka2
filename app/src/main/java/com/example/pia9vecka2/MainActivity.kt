package com.example.pia9vecka2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var counterNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var counterTextView = findViewById<TextView>(R.id.counterTextView)

        counterTextView.text = "0"

        var plusButton = findViewById<Button>(R.id.plusButton)

        plusButton.setOnClickListener {

            counterNumber = counterNumber +1
            counterTextView.text = counterNumber.toString()
        }
        var minusButton = findViewById<Button>(R.id.minusButton)

        minusButton.setOnClickListener {

            counterNumber = counterNumber -1

            if (counterNumber < 0){
                counterNumber = 0
            }

            counterTextView.text = counterNumber.toString()
        }

        var resetButton = findViewById<Button>(R.id.resetButton)

        resetButton.setOnClickListener {

            resetCounting()
        }

        var setButton = findViewById<Button>(R.id.setButton)
        setButton.setOnClickListener {

            var numbertext = findViewById<EditText>(R.id.numberEditText)

            var enteredText = numbertext.text.toString()

           /*
            var enteredNumber = enteredText.toIntOrNull()


            if(enteredNumber != null){

                counterNumber = enteredNumber
            }

            */
            enteredText.toIntOrNull()?.let {
                counterNumber = it
            }

            counterTextView.text = counterNumber.toString()

            numbertext.setText("")



        }

        var goOtherButton = findViewById<Button>(R.id.goOtherButton)
        goOtherButton.setOnClickListener {
                         Log.d("Debug", "Lets Go")
            var intent = Intent(this, OtherActivity::class.java)
            intent.putExtra("counter", counterNumber)
            startActivity(intent)
        }

    }

    fun resetCounting(){

        counterNumber = 0
        var counterTextView = findViewById<TextView>(R.id.counterTextView)
        counterTextView.text = counterNumber.toString()

    }

}
