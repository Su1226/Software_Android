package com.example.game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.MediaStore
import android.view.Gravity
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.util.*

class GameOneActivity : AppCompatActivity() {

    lateinit var guild : TextView
    lateinit var sentence : TextView
    lateinit var rGroup: RadioGroup
    lateinit var answer1 : RadioButton
    lateinit var answer2 : RadioButton
    lateinit var answer3 : RadioButton
    lateinit var answer4 : RadioButton
    lateinit var checkResult: Button

    lateinit var toastView : View
    lateinit var toastText : TextView


    val random = Random()
    var fchoice = random.nextInt(3) //랜덤 연산시 사용
    var bchoice = random.nextInt(4) //랜덤으로 정답 위치 정할 때 사용
    var left = random.nextInt(10)+1
    var right = random.nextInt(10)+1
    var nn = 0; //빼기 연산시 사용
    var nresult = 100
    var bbresult = 0 // 라디오 버튼으로 계산 결과 확인시 사용



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "연산게임"

        guild = findViewById<TextView>(R.id.guide)
        sentence = findViewById<TextView>(R.id.sentence)
        rGroup = findViewById<RadioGroup>(R.id.rGroup)
        answer1= findViewById<RadioButton>(R.id.answer1)
        answer2= findViewById<RadioButton>(R.id.answer2)
        answer3= findViewById<RadioButton>(R.id.answer3)
        answer4= findViewById<RadioButton>(R.id.answer4)
        checkResult = findViewById<Button>(R.id.checkResult)

        Quiz()
        rnum()

        answer1.setOnClickListener{
            if(bchoice==0) bbresult=1
            else bbresult=2
        }
        answer2.setOnClickListener{
            if(bchoice==1)  bbresult=1
            else bbresult=2
        }
        answer3.setOnClickListener{
            if(bchoice==2) bbresult=1
            else bbresult=2
        }
        answer4.setOnClickListener{
            if(bchoice==3) bbresult=1
            else bbresult=2
        }

        checkResult.setOnClickListener{
            if(bbresult==0){
                var toast2 = Toast(this@GameOneActivity)
                toastView = View.inflate(this@GameOneActivity, R.layout.toast2, null)
                toastText = toastView.findViewById<TextView>(R.id.checkToast)
                toastText.text = "답을 선택해주세요"
                toast2.setGravity(Gravity.CENTER, 30,30)
                toast2.view=toastView
                toast2.show()

            }
            else if(bbresult==1) {
                var toast1 = Toast(this@GameOneActivity)
                toastView = View.inflate(this@GameOneActivity, R.layout.toast1, null)
                toastText = toastView.findViewById<TextView>(R.id.correctToast)
                toastText.text = "정답입니다"
                toast1.setGravity(Gravity.CENTER, 30,30)
                toast1.view=toastView
                toast1.show()
                //토스트 뜨고 사라지면 새로운 문제 나타남
                Handler().postDelayed({
                    refresh()
                }, 2700)


            }
            else if(bbresult==2) {
                var toast3 = Toast(this@GameOneActivity)
                toastView = View.inflate(this@GameOneActivity, R.layout.toast3, null)
                toastText = toastView.findViewById<TextView>(R.id.incorrectToast)
                toastText.text = "오답입니다"
                toast3.setGravity(Gravity.CENTER, 30,30)
                toast3.view=toastView
                toast3.show()
            }
        }
    }

    //덧셈 뺄셈 곱셈 랜덤으로 나옴
    fun Quiz(){
        when(fchoice) {
            0 -> {
                nresult = left + right
                sentence.text = left.toString() + " + " + right.toString() +" = ?"
            }
            1 -> {
                //마이너스 값이 나올수 없도록 처리
                if(right > left) {
                    nn = left
                    left=right
                    right = nn
                }
                nresult = left - right
                sentence.text = left.toString()+ " - " + right.toString() +" = ?"
            }
            2 -> {
                nresult = left * right
                sentence.text = left.toString()+ " * " + right.toString() +" = ?"
            }
        }
    }

    fun rnum(){
        //라디오 버튼에 정답빼고 중복 없는 랜덤 숫자 나오게 하는 식
        var arr = Array<Int>(3,{0})
        for( i in arr.indices){
            arr[i] = random.nextInt(20)+1
        }
        while (arr[0]==arr[1]||arr[0]==arr[2]||arr[1]==arr[2]||arr[0]==nresult||arr[1]==nresult||arr[2]==nresult){
            for( i in arr.indices){
                arr[i] = random.nextInt(20)+1
            }
        }

        var rone = arr[0]
        var rtwo = arr[1]
        var rtree = arr[2]

        when(bchoice){
            0 -> {
                answer1.text = nresult.toString()
                answer2.text = rone.toString()
                answer3.text = rtwo.toString()
                answer4.text = rtree.toString()
            }
            1 -> {
                answer1.text = rone.toString()
                answer2.text = nresult.toString()
                answer3.text = rtwo.toString()
                answer4.text = rtree.toString()
            }
            2 -> {
                answer1.text = rone.toString()
                answer2.text = rtwo.toString()
                answer3.text = nresult.toString()
                answer4.text = rtree.toString()
            }
            3 -> {
                answer1.text = rone.toString()
                answer2.text = rtwo.toString()
                answer3.text = rtree.toString()
                answer4.text = nresult.toString()
            }
        }
    }

    fun refresh() {
        //정답을 맞췄을 경우 자동으로 새로운 문제 나옴
        fchoice = random.nextInt(3)
        bchoice = random.nextInt(4)
        left = random.nextInt(10)+1
        right = random.nextInt(10)+1

        Quiz()
        rnum()

        answer1.isChecked = false
        answer2.isChecked = false
        answer3.isChecked = false
        answer4.isChecked = false
        bbresult = 0

    }

}
