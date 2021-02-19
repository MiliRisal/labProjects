package com.example.labprojects

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class scrollViewActivity : AppCompatActivity() {
    private lateinit var txtname : EditText
    private lateinit var txtpass :EditText
    private lateinit var btnlogin : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_view)

        txtname = findViewById(R.id.txtname)
        txtpass = findViewById(R.id.txtpass)
        btnlogin = findViewById(R.id.btnlogin)

        btnlogin.setOnClickListener{
            if (txtname.text.toString() == "Mili" && txtpass.text.toString() == "abc123"){
                 Toast.makeText(
                     this,
                     "Login successfull",
                     Toast.LENGTH_LONG
                 ).show()

            }
            else{
                Toast.makeText(
                    this,
                    "Login unsuccessfull",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

}