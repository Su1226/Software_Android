package com.example.projectteam

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_mini_cog.*

class MiniCogActivity : AppCompatActivity() {
    lateinit var m_slide : ViewFlipper
    lateinit var m_btn1 : Button; lateinit var m_btn2 : Button
    lateinit var m_btn3 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mini_cog)

        m_slide = findViewById<ViewFlipper>(R.id.M_slide)
        m_btn1 = findViewById<Button>(R.id.M_btn1)
        m_btn2 = findViewById<Button>(R.id.M_btn2)
        m_btn3 = findViewById<Button>(R.id.M_btn3)

        m_btn1.setOnClickListener(View.OnClickListener {
            m_slide.isAutoStart = true
            m_slide.flipInterval = 5000
            m_slide.startFlipping()
        })

        m_btn2.setOnClickListener(View.OnClickListener {
            m_slide.stopFlipping()

        })

        m_btn3.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,MiniCogResultActivity::class.java)
            startActivity(intent)
        })




    }
}