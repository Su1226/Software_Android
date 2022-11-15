package com.example.projectteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class TestActivity : AppCompatActivity() {
    lateinit var t_btn1 : Button; lateinit var  t_btn2 : Button
    lateinit var t_btn3 : Button; lateinit var t_btn4 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        t_btn1 = findViewById<Button>(R.id.T_btn1)
        t_btn2 = findViewById<Button>(R.id.T_btn2)
        t_btn3 = findViewById<Button>(R.id.T_btn3)
        t_btn4 = findViewById<Button>(R.id.T_btn4)

        t_btn1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MiniCogActivity::class.java)
            startActivity(intent)
        })

        t_btn2.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, K_DSQ1Activity::class.java)
            startActivity(intent)
        })

        t_btn3.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MMSEActivity::class.java)
            startActivity(intent)
        })

        t_btn4.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, IntroActivity::class.java)
            startActivity(intent)
        })
    }
}