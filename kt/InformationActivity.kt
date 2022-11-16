package com.example.android_project

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.android_project.databinding.ActivityInformationBinding
import com.example.android_project.databinding.ActivityRegisterBinding

class InformationActivity : AppCompatActivity() {
    lateinit var ibtn1 : Button; lateinit var ibtn2 : Button

    val DATABASE_VERSION = 1
    val DATABASE_NAME = "LocalDB.db"

    private lateinit var  binding : ActivityInformationBinding
    private lateinit var localDB : LocalDB
    lateinit var database : SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        binding = ActivityInformationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        localDB = LocalDB(this, DATABASE_NAME, null, DATABASE_VERSION)



    }
}