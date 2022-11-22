package com.example.android_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DmtGamesActivity : AppCompatActivity() {

    lateinit var gameOneBtn : Button
    lateinit var gameTwoBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dmtgames)
        title = "치매 예방 게임"

        gameOneBtn = findViewById<Button>(R.id.gameOneBtn)
        gameTwoBtn = findViewById<Button>(R.id.gameTwoBtn)

        gameOneBtn.setOnClickListener {
            var intent = Intent(applicationContext, GameOneActivity::class.java)
            startActivity(intent)
        }

    }


}