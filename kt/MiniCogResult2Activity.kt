package com.example.projectteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MiniCogResult2Activity : AppCompatActivity() {
    lateinit var mr_btn1 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mini_cog_result2)

        mr_btn1 = findViewById<Button>(R.id.MR_btn1)

        mr_btn1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,TestMActivity::class.java)
            startActivity(intent)
        })
    }
}