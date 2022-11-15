package com.example.projectteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class TestMActivity : AppCompatActivity() {
    lateinit var tm_btn1 : Button; lateinit var  tm_btn2 : Button
    lateinit var tm_btn3 : Button; lateinit var tm_btn4 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_mactivity)

        tm_btn1 = findViewById<Button>(R.id.TM_btn1)
        tm_btn2 = findViewById<Button>(R.id.TM_btn2)
        tm_btn3 = findViewById<Button>(R.id.TM_btn3)
        tm_btn4 = findViewById<Button>(R.id.TM_btn4)

        tm_btn1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MiniCog2Activity::class.java)
            startActivity(intent)
        })

        tm_btn2.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, DSQ1Activity::class.java)
            startActivity(intent)
        })

        tm_btn3.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MMSE2Activity::class.java)
            startActivity(intent)
        })

        tm_btn4.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
    }
}