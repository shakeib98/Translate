package com.example.shakeib.translate

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textClickColor = findViewById(R.id.textViewColor) as TextView
        textClickColor.setOnClickListener {
            val colorsIntent = Intent(this@MainActivity, Colors::class.java)
            startActivity(colorsIntent)
        }

        val textClickNumbers = findViewById(R.id.textViewNumbers) as TextView
        textClickNumbers.setOnClickListener {
            val numbersIntent = Intent(this@MainActivity,Numbers::class.java)
            startActivity(numbersIntent)
        }
    }
}
