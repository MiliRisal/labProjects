package com.example.labprojects

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import model.person

class Lab7FormActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etName: EditText
    private lateinit var etAdd: EditText
    private lateinit var etNum: EditText
    private lateinit var rbFemale: RadioButton
    private lateinit var rbMale: RadioButton
    private lateinit var btnSubmit: Button
    private var list = arrayListOf<person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab7_form)

        etName = findViewById(R.id.etName)
        etAdd = findViewById(R.id.etAdd)
        etNum = findViewById(R.id.etNum)
        rbFemale = findViewById(R.id.rbFemale)
        rbMale = findViewById(R.id.rbMale)
        btnSubmit = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener(this)
    }

    private fun getValue() {

        val n = etName.text.toString()
        val a = etAdd.text.toString()
        val num = etNum.text.toString()
        var g = ""

        if(rbMale.isChecked){
            g = rbMale.text.toString()
        }
        else if(rbFemale.isChecked){
            g = rbFemale.text.toString()
        }

        list.add(person(n,a,num,g))
        val intent = Intent(
            this,
            Lab7Activity::class.java
        )
        intent.putExtra("list",list)
        startActivity(intent)
    }

    override fun onClick(v: View?) {
       when(v?.id){
           R.id.btnSubmit -> {
               getValue()
           }
       }
    }
}