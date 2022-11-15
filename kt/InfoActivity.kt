package com.example.projectteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.*

class InfoActivity : AppCompatActivity() {
    lateinit var i_edit1 : EditText; lateinit var i_edit2 : EditText;
    lateinit var i_edit3 : EditText; lateinit var i_edit4 : EditText;
    lateinit var i_edit5 : EditText; lateinit var i_edit6 : EditText;
    lateinit var i_edit7 : EditText;

    lateinit var i_rg : RadioGroup;
    lateinit var i_r1 : RadioButton; lateinit var i_r2 : RadioButton;
    lateinit var i_r3 : RadioButton;

    lateinit var  info_btn1 : Button; lateinit var  info_btn2 : Button;
    lateinit var  info_btn3 : Button;

    lateinit var i_tv1 : TextView; lateinit var i_tv2 : TextView;
    lateinit var i_tv3 : TextView; lateinit var i_tv4 : TextView;
    lateinit var i_tv5 : TextView; lateinit var i_tv6 : TextView;
    lateinit var i_tv7 : TextView; lateinit var i_tv8 : TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        i_edit1 = findViewById<EditText>(R.id.I_edit1)
        i_edit2 = findViewById<EditText>(R.id.I_edit2)
        i_edit3 = findViewById<EditText>(R.id.I_edit3)
        i_edit4 = findViewById<EditText>(R.id.I_edit4)
        i_edit5 = findViewById<EditText>(R.id.I_edit5)
        i_edit6 = findViewById<EditText>(R.id.I_edit6)
        i_edit7 = findViewById<EditText>(R.id.I_edit7)

        i_rg = findViewById<RadioGroup>(R.id.I_RG)

        i_r1 = findViewById<RadioButton>(R.id.I_R1)
        i_r2 = findViewById<RadioButton>(R.id.I_R2)
        i_r3 = findViewById<RadioButton>(R.id.I_R3)

        info_btn1 = findViewById<Button>(R.id.Info_btn1)
        info_btn2 = findViewById<Button>(R.id.Info_btn2)
        info_btn3 = findViewById<Button>(R.id.Info_btn3)

        i_tv1 = findViewById<TextView>(R.id.I_tv1)
        i_tv2 = findViewById<TextView>(R.id.I_tv2)
        i_tv3 = findViewById<TextView>(R.id.I_tv3)
        i_tv4 = findViewById<TextView>(R.id.I_tv4)
        i_tv5 = findViewById<TextView>(R.id.I_tv5)
        i_tv6 = findViewById<TextView>(R.id.I_tv6)
        i_tv7 = findViewById<TextView>(R.id.I_tv7)
        i_tv8 = findViewById<TextView>(R.id.I_tv8)


        info_btn1.setOnClickListener(View.OnClickListener {
            i_edit1.visibility = View.INVISIBLE
            i_edit2.visibility = View.INVISIBLE
            i_edit3.visibility = View.INVISIBLE
            i_edit4.visibility = View.INVISIBLE
            i_edit5.visibility = View.INVISIBLE
            i_edit6.visibility = View.INVISIBLE
            i_edit7.visibility = View.INVISIBLE

            i_rg.visibility = View.INVISIBLE
            i_r1.visibility = View.INVISIBLE
            i_r2.visibility = View.INVISIBLE
            i_r3.visibility = View.INVISIBLE

            i_tv1.visibility = View.VISIBLE
            i_tv2.visibility = View.VISIBLE
            i_tv3.visibility = View.VISIBLE
            i_tv4.visibility = View.VISIBLE
            i_tv5.visibility = View.VISIBLE
            i_tv6.visibility = View.VISIBLE
            i_tv7.visibility = View.VISIBLE
            i_tv8.visibility = View.VISIBLE

            if(i_r1.text.toString() != null){
                i_tv1.text = i_r1.text.toString()
            }
            else if(i_r2.text.toString() != null){
                i_tv1.text = i_r2.text.toString()
            }
            else if(i_r3.text.toString() != null){
                i_tv1.text = i_r3.text.toString()
            }

            i_tv2.text = i_edit1.text.toString()
            i_tv3.text = i_edit2.text.toString()
            i_tv4.text = i_edit3.text.toString()
            i_tv5.text = i_edit4.text.toString()
            i_tv6.text = i_edit5.text.toString()
            i_tv7.text = i_edit6.text.toString()
            i_tv8.text = i_edit7.text.toString()

        })

        info_btn2.setOnClickListener(View.OnClickListener {
            i_edit1.visibility = View.VISIBLE
            i_edit2.visibility = View.VISIBLE
            i_edit3.visibility = View.VISIBLE
            i_edit4.visibility = View.VISIBLE
            i_edit5.visibility = View.VISIBLE
            i_edit6.visibility = View.VISIBLE
            i_edit7.visibility = View.VISIBLE

            i_rg.visibility = View.VISIBLE
            i_r1.visibility = View.VISIBLE
            i_r2.visibility = View.VISIBLE
            i_r3.visibility = View.VISIBLE

            i_tv1.visibility = View.INVISIBLE
            i_tv2.visibility = View.INVISIBLE
            i_tv3.visibility = View.INVISIBLE
            i_tv4.visibility = View.INVISIBLE
            i_tv5.visibility = View.INVISIBLE
            i_tv6.visibility = View.INVISIBLE
            i_tv7.visibility = View.INVISIBLE
            i_tv8.visibility = View.INVISIBLE

            i_tv1.text = ""
            i_tv2.text = ""
            i_tv3.text = ""
            i_tv4.text = ""
            i_tv5.text = ""
            i_tv6.text = ""
            i_tv7.text = ""
            i_tv8.text = ""

        })

        info_btn3.setOnClickListener(View.OnClickListener {
            val intent =Intent(this,MainActivity::class.java)
            startActivity(intent)
        })
    }



}