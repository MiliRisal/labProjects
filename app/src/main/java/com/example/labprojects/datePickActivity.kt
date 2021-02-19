package com.example.labprojects

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextClock
import android.widget.TextView
import java.util.*

class datePickActivity : AppCompatActivity() {
    private lateinit var btnCalendar: Button
    private lateinit var txtDate : TextView
    private lateinit var btnTime: Button
    private lateinit var txtTime : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_pick)

        btnCalendar = findViewById(R.id.btnCalender)
        txtDate = findViewById(R.id.txtDate)
        btnTime = findViewById(R.id.btnTime)
        txtTime = findViewById(R.id.txtTime)

        btnCalendar.setOnClickListener{
            OpenCalendar()
        }

        btnTime.setOnClickListener{
            val t= Calendar.getInstance()
            val hour = t.get(Calendar.HOUR_OF_DAY)
            val minute = t.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener(){ timePicker, hour, minute ->
                    txtTime.text="Selected time: $hour:$minute"
                },
                hour,
                minute,
                true

            )
            timePickerDialog.show()
        }

    }



    private fun OpenCalendar(){
        val c= Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener(){ view, year, monthOfYear, dayOfMonth->
                txtDate.text="Selected Date: $dayOfMonth/$monthOfYear/$year"
            },
            year,
            month,
            day

        )
        datePickerDialog.show()
    }


}