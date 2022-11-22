package com.example.android_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class dmtgames2Activity : AppCompatActivity() {

    lateinit var gameOneBtn : Button
    lateinit var gameTwoBtn : Button
    lateinit var backmainbtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dmtgames2)
        title = "치매 예방 게임"

        gameOneBtn = findViewById<Button>(R.id.gameOneBtn)
        gameTwoBtn = findViewById<Button>(R.id.gameTwoBtn)
        backmainbtn = findViewById<Button>(R.id.backMain)

        gameOneBtn.setOnClickListener {
            var intent = Intent(this, gameone2Activity::class.java)
            startActivity(intent)
        }

        gameTwoBtn.setOnClickListener {

        }

        backmainbtn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }


}