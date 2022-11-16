package com.example.android_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class IntroActivity : AppCompatActivity() {
    lateinit var i_btn1 : Button; lateinit var i_btn2 : Button;
    lateinit var i_btn3 : Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        i_btn1 = findViewById<Button>(R.id.I_btn1)
        i_btn2 = findViewById<Button>(R.id.I_btn2)
        i_btn3 = findViewById<Button>(R.id.I_btn3)

        i_btn1.setOnClickListener(View.OnClickListener {
            val intent =Intent(this,Test1Activity::class.java)
            startActivity(intent)
        })

        i_btn2.setOnClickListener(View.OnClickListener {

        })

        i_btn3.setOnClickListener(View.OnClickListener {
            val intent =Intent(this,LoginActivity::class.java)
            startActivity(intent)
        })
    }
}