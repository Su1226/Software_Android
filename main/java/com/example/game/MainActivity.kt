package com.example.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var guild : TextView
    lateinit var sentence : TextView
    lateinit var rGroup: RadioGroup
    lateinit var answer1 : RadioButton
    lateinit var answer2 : RadioButton
    lateinit var answer3 : RadioButton
    lateinit var answer4 : RadioButton
    lateinit var checkResult: Button

    val random = Random()
    val fchoice = random.nextInt(3)
    val bchoice = random.nextInt(4)
    var left = random.nextInt(10)+1
    var right = random.nextInt(10)+1
    var nresult = 100
    var bbresult = 0
    var set: TreeSet<Int> = TreeSet()
    val textList = ArrayList<String>()


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
        bnum()
        //brun()

        answer1.setOnClickListener{
            if(bchoice==0){
                bbresult=1
            }else
                bbresult=2
        }
        answer2.setOnClickListener{
            if(bchoice==1){
                bbresult=1
            }else
                bbresult=2
        }
        answer3.setOnClickListener{
            if(bchoice==2){
                bbresult=1
            }else
                bbresult=2
        }
        answer4.setOnClickListener{
            if(bchoice==3){
                bbresult=1
            }else
                bbresult=2
        }

        checkResult.setOnClickListener{

            //토스트 결과 값에 맞춰서 나올 수 있도록 수정하기
            when(bbresult){
                0 -> Toast.makeText(applicationContext,"답을 선택해주세요.",Toast.LENGTH_SHORT).show()
                1 -> Toast.makeText(applicationContext,"정답입니다.",Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(applicationContext,"오답입니다.",Toast.LENGTH_SHORT).show()
            }
        }

    }

    /*fun brun(){

        var nCount = 0
        while (set.size < 4) {
            val num = random.nextInt(21)
            set.add(num)
        }
        for (i in set) {
            var textID : Int = getResources().getIdentifier("answer"+(nCount+1),"id", packageName)
            val answer = findViewById<RadioButton>(textID)
            answer.text=textList.get(i)
            nCount++
        }
    }*/


    //연산식 랜덤으로 나오게 하기 위한 식
    fun Quiz(){
        when(fchoice) {
            0 -> plusQuiz()
            1 -> subQuiz()
            2 -> mulQuiz()
        }
    }

    fun plusQuiz() {
        Toast.makeText(applicationContext,"plus",Toast.LENGTH_SHORT).show()
        nresult = left + right
        sentence.text = left.toString() + " + " + right.toString() +" = ?"
    }

    fun subQuiz(){
        Toast.makeText(applicationContext,"sub",Toast.LENGTH_SHORT).show()
        //마이너스 값이 나올수 없도록 처리
        if(right > left)
            left=right
        nresult = left - right
        sentence.text = left.toString()+ " - " + right.toString() +" = ?"
    }

    fun mulQuiz(){
        Toast.makeText(applicationContext,"mul",Toast.LENGTH_SHORT).show()
        nresult = left * right
        sentence.text = left.toString()+ " * " + right.toString() +" = ?"
    }

    //라디오 버튼 값을 랜덤으로 나오게 하기 위한 식
    fun bnum() {
        when(bchoice) {
            0 -> bnum1()
            1 -> bnum2()
            2 -> bnum3()
            3 -> bnum4()
        }
    }


//라디오 버튼에 같은 값이 나오는 경우 처리해야됨
    fun bnum1(){
        Toast.makeText(applicationContext,"bnum1",Toast.LENGTH_SHORT).show()
        answer1.text= nresult.toString()
        answer2.text = random.nextInt(21).toString()
        answer3.text = random.nextInt(21).toString()
        answer4.text = random.nextInt(21).toString()
    }

    fun bnum2(){
        Toast.makeText(applicationContext,"bnum2",Toast.LENGTH_SHORT).show()
        answer1.text = random.nextInt(21).toString()
        answer2.text= nresult.toString()
        answer3.text = random.nextInt(21).toString()
        answer4.text = random.nextInt(21).toString()
    }

    fun bnum3(){
        Toast.makeText(applicationContext,"bnum3",Toast.LENGTH_SHORT).show()
        answer1.text = random.nextInt(21).toString()
        answer2.text = random.nextInt(21).toString()
        answer3.text= nresult.toString()
        answer4.text = random.nextInt(21).toString()
    }

    fun bnum4(){
        Toast.makeText(applicationContext,"bnum4",Toast.LENGTH_SHORT).show()
        answer1.text = random.nextInt(21).toString()
        answer2.text = random.nextInt(21).toString()
        answer3.text = random.nextInt(21).toString()
        answer4.text= nresult.toString()
    }
}
