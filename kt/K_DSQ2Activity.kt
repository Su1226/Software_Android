package com.example.projectteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class K_DSQ2Activity : AppCompatActivity() {
    lateinit var k2_btn1 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kdsq2)

        k2_btn1 = findViewById<Button>(R.id.K2_btn1)

        k2_btn1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,K_DSQResultActivity::class.java)
            startActivity(intent)
        })
    }
}