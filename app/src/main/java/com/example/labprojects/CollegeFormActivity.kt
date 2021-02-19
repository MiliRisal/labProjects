package com.example.labprojects

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class CollegeFormActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var tvStudentID: TextView
    private lateinit var etStudentID: EditText

    private lateinit var spinner: Spinner
    private val department = arrayOf("Academic","IT","Reception","Admission")
    private val student= arrayOf("25A","25B","25C","25D")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_college_form)

        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)

        //For the sipnner
        spinner = findViewById(R.id.spinner)
        textView = findViewById(R.id.textView)
        tvStudentID = findViewById(R.id.tvStudentID)
        etStudentID = findViewById(R.id.etStudentID)

        //Array adapter
        radioGroup.setOnCheckedChangeListener(object:RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when(checkedId){
                    R.id.rbStudent->{
                        textView.setText("Batch")
                        etStudentID.visibility = View.VISIBLE
                        tvStudentID.visibility=View.VISIBLE
                        val adapter = ArrayAdapter(
                            this@CollegeFormActivity,
                            android.R.layout.simple_list_item_1,
                            student
                        )
                        spinner.adapter=adapter
                    }

                    R.id.rbStaff->{
                        textView.setText("Department")
                        etStudentID.visibility = View.GONE
                        tvStudentID.visibility=View.GONE
                        val adapter = ArrayAdapter(
                            this@CollegeFormActivity,
                            android.R.layout.simple_list_item_1,
                            department
                        )
                        spinner.adapter=adapter
                    }

                    //for showing student and staff id
                    /*R.id.rbStudent->{
                        textView.setText("Batch")
                        etStudentID.setHint("Enter Student ID")
                        tvStudentID.setText("Student ID")
                        val adapter = ArrayAdapter(
                                this@CollegeFormActivity,
                                android.R.layout.simple_list_item_1,
                                student
                        )
                        spinner.adapter=adapter
                    }

                    R.id.rbStaff->{
                        textView.setText("Batch")
                        etStudentID.setHint("Enter Staff ID")
                        tvStudentID.setText("Staff ID")
                        val adapter = ArrayAdapter(
                                this@CollegeFormActivity,
                                android.R.layout.simple_list_item_1,
                                department
                        )
                        spinner.adapter=adapter
                    }*/
                }
            }

        })

        //on item selected listener on spinner
        spinner.onItemSelectedListener=
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                )
                {
                    val selectedItem=parent?.getItemAtPosition(position).toString()
                    Toast.makeText(
                        this@CollegeFormActivity,
                        "Selected item:$selectedItem",
                        Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }

    }
}