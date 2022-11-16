package com.example.android_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.android_project.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    val DATABASE_VERSION = 1
    val DATABASE_NAME = "LocalDB.db"

    private lateinit var  binding : ActivityRegisterBinding
    private lateinit var localDB : LocalDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        localDB = LocalDB(this, DATABASE_NAME, null, DATABASE_VERSION)

        binding.RBtn1.setOnClickListener{view ->
            if(binding.RegisterName.text.isEmpty() || binding.RegisterPhone.text.isEmpty() || binding.RegisterBirthday.text.isEmpty() || binding.R2Edit1.text.isEmpty() || binding.R2Edit2.text.isEmpty() || binding.R2Edit3.text.isEmpty() || binding.R2Edit4.text.isEmpty()
                || binding.R2Edit6.text.isEmpty() || binding.R2Edit7.text.isEmpty()) {
                Toast.makeText(this, "값을 전부 입력해주세요", Toast.LENGTH_SHORT).show()
            }
            else{//만약에 DB에 휴대폰번호가 들어 있으면
                if(localDB.checkIdExist(binding.RegisterPhone.text.toString())) {
                    Toast.makeText(this, "휴대폰 번호가 이미 존재합니다.", Toast.LENGTH_LONG).show()
                }
                else {
                    localDB.registerUser(
                        binding.RegisterName.text.toString(),
                        binding.RegisterPhone.text.toString(),
                        binding.RegisterBirthday.text.toString(),
                        binding.R2RG.toString(),
                        binding.R2Edit1.text.toString(),
                        binding.R2Edit2.text.toString(),
                        binding.R2Edit3.text.toString(),
                        binding.R2Edit4.text.toString(),
                        binding.R2Edit6.text.toString(),
                        binding.R2Edit7.text.toString(),
                    )

                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }
            }

        }


    }
}
