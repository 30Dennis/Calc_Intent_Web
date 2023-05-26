
package com.example.intent_calc_web

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var ButtonCalculator: Button
    lateinit var ButtonIntent: Button
    lateinit var ButtonWeb: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        ButtonCalculator=findViewById(R.id.btn_calc)
        ButtonCalculator.setOnClickListener {
            val calculator= Intent(this, CalculatorActivity::class.java)
            startActivity(calculator)

        ButtonIntent=findViewById(R.id.btn_intent)
        ButtonIntent.setOnClickListener {
            val intent=Intent(this, IntentActivity::class.java)
            startActivity(intent)

        ButtonWeb=findViewById(R.id.btn_web)
        ButtonWeb.setOnClickListener {
            val Web=Intent(this, WebActivity::class.java)
            startActivity(Web)
        }
        }
        }
    }


}
