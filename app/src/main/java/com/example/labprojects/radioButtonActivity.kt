package com.example.labprojects

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView

class radioButtonActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private  lateinit var radioButton1: RadioButton
    private  lateinit var radioButton2: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button)

        var btn : Button = findViewById(R.id.button2)
        btn.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

        textView= findViewById(R.id.textView2)
        radioButton1 = findViewById(R.id.radioButton1)
        radioButton2 = findViewById(R.id.radioButton2)

        radioButton1.setOnClickListener{
            textView.text="Female"
        }
        radioButton2.setOnClickListener{
            textView.text="Male"
        }

    }
}