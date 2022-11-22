package com.example.android_project

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.android_project.LocalDatas.userData.COLUMN_NAME_NAME
import com.example.android_project.databinding.ActivityInformationBinding
import com.example.android_project.databinding.ActivityRegisterBinding//건강정보임
import kotlinx.android.synthetic.main.activity_information.*
import kotlinx.coroutines.selects.select

class InformationActivity : AppCompatActivity() {
    lateinit var ibtn1 : Button; lateinit var ibtn2 : Button

    val DATABASE_VERSION = 1
    val DATABASE_NAME = "LocalDB.db"

    private lateinit var  binding : ActivityInformationBinding
    private lateinit var localDB : LocalDB
    lateinit var database : SQLiteDatabase

    lateinit var tvresult : TextView

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        binding = ActivityInformationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        localDB = LocalDB(this, DATABASE_NAME, null, DATABASE_VERSION)

        tvresult = findViewById<TextView>(R.id.Info_result)
        var btn1 = findViewById<Button>(R.id.Info_btn1)

        var intent = intent
        var phone = intent.getStringExtra("Phone").toString()

        try {
            val selectResult = localDB.getAllData(phone.toString()).toString()

            val str = StringBuffer()
            str.append(selectResult)

            var txt: String = str.toString()

            tvresult.text = txt

        } catch (e: Exception) {
            e.printStackTrace()
        }

        binding.InfoBtn1.setOnClickListener {
            val intent = Intent(this, modifyActivity::class.java)
            startActivity(intent)
        }

        binding.InfoBtn2.setOnClickListener {view ->
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("Phone", phone)
            startActivity(intent)

        }


    }

}
