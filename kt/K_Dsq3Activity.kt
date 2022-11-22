package com.example.android_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class K_Dsq3Activity : AppCompatActivity() {
    lateinit var k2_btn1 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kdsq3)

        k2_btn1 = findViewById<Button>(R.id.K2_btn1)

        k2_btn1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,K_DsqResultActivity::class.java)
            startActivity(intent)
        })
    }
}