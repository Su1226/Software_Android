package com.example.android_project

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Dsq3Activity : AppCompatActivity() {
    lateinit var k2_btn1 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dsq3)

        k2_btn1 = findViewById<Button>(R.id.K2_btn1)

        k2_btn1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, DsqResultActivity::class.java)
            startActivity(intent)
        })
    }
}