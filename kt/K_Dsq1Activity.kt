package com.example.android_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class K_Dsq1Activity : AppCompatActivity() {
    lateinit var k1_btn1 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kdsq1)

        k1_btn1 = findViewById<Button>(R.id.K1_btn1)

        k1_btn1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,K_Dsq2Activity::class.java)
            startActivity(intent)
        })
    }
}