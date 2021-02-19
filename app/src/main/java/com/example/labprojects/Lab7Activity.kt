package com.example.labprojects

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import model.person

class Lab7Activity : AppCompatActivity() {
    private lateinit var lvPerson : ListView
    private lateinit var tvPerson : TextView
    private lateinit var btnAdd : Button
    var list = ArrayList<person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab7)

        lvPerson = findViewById(R.id.lvPerson)
        tvPerson = findViewById(R.id.tvPerson)
        btnAdd = findViewById(R.id.btnAdd)

        val intent = intent
        list = intent.getParcelableArrayListExtra<person>("list") as ArrayList<person>

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            list
        )
        lvPerson.adapter = adapter

        lvPerson.setOnItemClickListener { _,_, position,_ ->
            tvPerson.text = "Name: ${list.get(position).Name}\n" +
                            "Address: ${list.get(position).Address} \n" +
                            "Number: ${list.get(position).Number} \n" +
                            "Gender: ${list.get(position).Gender}"
        }

        btnAdd.setOnClickListener{
            var req = 1;
            startActivityForResult(Intent(this, Lab7FormActivity::class.java),req)
        }

    }
}