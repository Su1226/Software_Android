package com.example.android_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Mmse1ResultActivity : AppCompatActivity() {
    lateinit var mmr_btn1 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mmse1_result)

        mmr_btn1 = findViewById<Button>(R.id.MMR_btn1)

        mmr_btn1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,Test1Activity::class.java)
            startActivity(intent)
        })
    }
}