package com.example.android_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class dmtgamesActivity : AppCompatActivity() {

    lateinit var gameOneBtn : Button
    lateinit var gameTwoBtn : Button
    lateinit var backmainbtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dmtgames)
        title = "치매 예방 게임"

        gameOneBtn = findViewById<Button>(R.id.gameOneBtn)
        gameTwoBtn = findViewById<Button>(R.id.gameTwoBtn)
        backmainbtn = findViewById<Button>(R.id.backMain)

        gameOneBtn.setOnClickListener {
            var intent = Intent(this, gameoneActivity::class.java)
            startActivity(intent)
        }

        gameTwoBtn.setOnClickListener {

        }

        backmainbtn.setOnClickListener {
            var intent = Intent(this, IntroActivity::class.java)
            startActivity(intent)
        }

    }


}
