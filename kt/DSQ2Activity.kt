package com.example.projectteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class DSQ2Activity : AppCompatActivity() {
    lateinit var k_btn1 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kdsqactivity)

        k_btn1 = findViewById<Button>(R.id.K_btn1)

        k_btn1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,DSQ3Activity::class.java)
            startActivity(intent)
        })
    }
}