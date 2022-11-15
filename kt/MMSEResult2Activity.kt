package com.example.projectteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MMSEResult2Activity : AppCompatActivity() {
    lateinit var mmr_btn1 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mmseresult2)

        mmr_btn1 = findViewById<Button>(R.id.MMR_btn1)

        mmr_btn1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,TestMActivity::class.java)
            startActivity(intent)
        })
    }
}