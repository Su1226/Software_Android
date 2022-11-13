package com.example.gametwo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog

class selectAnswer : AppCompatActivity() {
    lateinit var ans1 : ImageButton
    lateinit var ans2 : ImageButton
    lateinit var ans3 : ImageButton
    lateinit var ans4 : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_answer)
        title="누락된 그림 찾기"

        ans1 = findViewById<ImageButton>(R.id.ans1)
        ans2 = findViewById<ImageButton>(R.id.ans2)
        ans3 = findViewById<ImageButton>(R.id.ans3)
        ans4 = findViewById<ImageButton>(R.id.ans4)

        ans1.setOnClickListener {
            var resultMessage = AlertDialog.Builder(this@selectAnswer)
            resultMessage.setTitle("틀렸습니다!")
            resultMessage.setMessage("다시 도전하시겠습니까?")
            resultMessage.setPositiveButton("네") { dialog, which ->
                val restartGame =  Intent(this, MainActivity::class.java)
                startActivity(restartGame)
            }
            // 다시 도전하는 경우 랜덤으로 그림을 바꾸어 다시 게임 restart

            // 포기하는 경우, 치매 예방 게임 메인 화면 자체로 이동
//            resultMessage.setNegativeButton("아니요") {
//                val gameMain = Intent(this, ::class.java)
//                startActivity(gameMain)
//            } // main 화면이 정해지면 다시 작성.
            resultMessage.show()
        }

        ans2.setOnClickListener {
            var resultMessage = AlertDialog.Builder(this@selectAnswer)
            resultMessage.setTitle("틀렸습니다!")
            resultMessage.setMessage("다시 도전하시겠습니까?")
            resultMessage.setPositiveButton("네") { dialog, which ->
                val restartGame =  Intent(this, MainActivity::class.java)
                startActivity(restartGame)
            }
            // 다시 도전하는 경우 랜덤으로 그림을 바꾸어 다시 게임 restart

            // 포기하는 경우, 치매 예방 게임 메인 화면 자체로 이동
//            resultMessage.setNegativeButton("아니요") {
//                val gameMain = Intent(this, ::class.java)
//                startActivity(gameMain)
//            } // main 화면이 정해지면 다시 작성.
            resultMessage.show()
        }

        ans3.setOnClickListener {
            var resultMessage = AlertDialog.Builder(this@selectAnswer)
            resultMessage.setTitle("틀렸습니다!")
            resultMessage.setMessage("다시 도전하시겠습니까?")
            resultMessage.setPositiveButton("네") { dialog, which ->
                val restartGame =  Intent(this, MainActivity::class.java)
                startActivity(restartGame)
            }
            // 다시 도전하는 경우 랜덤으로 그림을 바꾸어 다시 게임 restart

            // 포기하는 경우, 치매 예방 게임 메인 화면 자체로 이동
//            resultMessage.setNegativeButton("아니요") {
//                val gameMain = Intent(this, ::class.java)
//                startActivity(gameMain)
//            } // main 화면이 정해지면 다시 작성.
            resultMessage.show()
        }

        ans4.setOnClickListener {
            var resultMessage = AlertDialog.Builder(this@selectAnswer)
            resultMessage.setTitle("정답입니다!")
            resultMessage.setMessage("다시 도전하시겠습니까?")
            resultMessage.setPositiveButton("네") { dialog, which ->
                val restartGame =  Intent(this, MainActivity::class.java)
                startActivity(restartGame)
            }
            // 다시 도전하는 경우 랜덤으로 그림을 바꾸어 다시 게임 restart

            // 포기하는 경우, 치매 예방 게임 메인 화면 자체로 이동
//            resultMessage.setNegativeButton("아니요") {
//                val gameMain = Intent(this, ::class.java)
//                startActivity(gameMain)
//            } // main 화면이 정해지면 다시 작성.
            resultMessage.show()
        }
    }
}
