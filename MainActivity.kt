package com.example.gametwo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import kotlinx.coroutines.selects.select

class MainActivity : AppCompatActivity() {
    lateinit var GoSelect : Button
    lateinit var rememberTime : Chronometer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "누락된 그림 찾기"

        GoSelect = findViewById<Button>(R.id.GoSelect)
        rememberTime = findViewById<Chronometer>(R.id.rememberTime)

        // 누락된 그림 찾기 레이아웃에 접속 시 바로 시간을 측정한다.
        // 기억하는데 얼마나 걸렸나를 확인
        // 사람들이 부담스러워 하거나 긴박감을 느낄 수 있기 때문에,
        // xml에는 연한 회색으로 표시함.
        rememberTime.base=SystemClock.elapsedRealtime()
        rememberTime.start()

        GoSelect.setOnClickListener {
            // 다음 버튼을 누르면 화면을 넘어가면서 기억하는 시간 측정을 멈춰야하므로,
            rememberTime.stop()
            // 다음 정답지를 누를 화면으로 넘어가기
            val nextIntent = Intent(this, selectAnswer::class.java)
            startActivity(nextIntent)
        }

    }
}
