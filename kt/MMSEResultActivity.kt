package com.example.projectteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MMSEResultActivity : AppCompatActivity() {
    lateinit var mmr_btn1 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mmseresult)

        mmr_btn1 = findViewById<Button>(R.id.MMR_btn1)

        mmr_btn1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,TestActivity::class.java)
            startActivity(intent)
        })
    }
}