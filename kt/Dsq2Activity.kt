package com.example.android_project

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Dsq2Activity : AppCompatActivity() {
    lateinit var k_btn1 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dsq2)

        k_btn1 = findViewById<Button>(R.id.K_btn1)

        k_btn1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Dsq3Activity::class.java)
            startActivity(intent)
        })
    }
}