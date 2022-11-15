package com.example.projectteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class K_DSQResultActivity : AppCompatActivity() {
    lateinit var kr_btn1 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kdsqresult)

        kr_btn1 = findViewById<Button>(R.id.KR_btn1)

        kr_btn1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,TestActivity::class.java)
            startActivity(intent)
        })
    }
}