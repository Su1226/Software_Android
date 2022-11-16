package com.example.android_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var ma_btn1 : Button; lateinit var ma_btn2 : Button
    lateinit var ma_btn3 : Button; lateinit var ma_btn4 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ma_btn1 = findViewById<Button>(R.id.Ma_btn1)
        ma_btn2 = findViewById<Button>(R.id.Ma_btn2)
        ma_btn3 = findViewById<Button>(R.id.Ma_btn3)
        ma_btn4 = findViewById<Button>(R.id.Ma_btn4)

        ma_btn1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,Test2Activity::class.java)
            startActivity(intent)
        })

        ma_btn2.setOnClickListener(View.OnClickListener {

        })

        ma_btn3.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, InformationActivity::class.java)
            startActivity(intent)
        })

        ma_btn4.setOnClickListener(View.OnClickListener {

        })


    }
}