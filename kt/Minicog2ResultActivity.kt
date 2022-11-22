package com.example.android_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Minicog2ResultActivity : AppCompatActivity() {
    lateinit var mr_btn1 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minicog2_result)

        mr_btn1 = findViewById<Button>(R.id.MR_btn1)

        mr_btn1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,Test2Activity::class.java)
            startActivity(intent)
        })
    }
}