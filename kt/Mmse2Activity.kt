package com.example.android_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ViewFlipper

class Mmse2Activity : AppCompatActivity() {
    lateinit var mm_slide : ViewFlipper
    lateinit var mm_btn1 : Button; lateinit var mm_btn2 : Button
    lateinit var mm_btn3 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mmse2)

        mm_slide = findViewById<ViewFlipper>(R.id.MM_slide)
        mm_btn1 = findViewById<Button>(R.id.MM_btn1)
        mm_btn2 = findViewById<Button>(R.id.MM_btn2)
        mm_btn3 = findViewById<Button>(R.id.MM_btn3)

        mm_btn1.setOnClickListener(View.OnClickListener {
            mm_slide.isAutoStart = true
            mm_slide.flipInterval = 5000
            mm_slide.startFlipping()
        })

        mm_btn2.setOnClickListener(View.OnClickListener {
            mm_slide.stopFlipping()

        })

        mm_btn3.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,Mmse2ResultActivity::class.java)
            startActivity(intent)
        })
    }
}