package com.example.labprojects

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.*

class formActivity : AppCompatActivity() {
    private var depart = arrayOf("Finance1", "Sales", "Marketing", "IT")
    private lateinit var spinner: Spinner
    private lateinit var btnSubmit : Button
    private lateinit var etName : EditText
    private lateinit var etAdd : EditText
    private lateinit var etDate : EditText
    private lateinit var txtName : TextView
    private lateinit var txtDep : TextView
    private lateinit var txtAdd : TextView
    private lateinit var txtDate : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)


        btnSubmit = findViewById(R.id.btnSubmit)

        etName = findViewById(R.id.etName)
        spinner = findViewById(R.id.depart)
        etAdd = findViewById(R.id.etAdd)
        etDate = findViewById(R.id.etDate)

        txtName = findViewById(R.id.txtName)
        txtDep =findViewById(R.id.txtDep)
        txtAdd = findViewById(R.id.txtAdd)
        txtDate = findViewById(R.id.txtDate)



        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            depart
        )
        spinner.adapter = adapter

        etDate.setOnClickListener{
            val c= Calendar.getInstance()
            val year= c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                    this,
                    DatePickerDialog.OnDateSetListener{view, year, monthOfYear, dayOfMonth->
                        etDate.setText("$dayOfMonth/$monthOfYear/$year")
                    },
                    year,
                    month,
                    day
            )
            datePickerDialog.show()
        }

        btnSubmit.setOnClickListener{
            txtName.text = etName.editableText.toString()
            txtDep.text = spinner.selectedItem.toString()
            txtAdd.text = etAdd.editableText.toString()
            txtDate.text = etDate.text.toString()

        }

    }

}