package com.example.android_project

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android_project.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    val DATEBASE_NAME = "LocalDB.db"
    val DATEBASE_VERSION = 1

    private lateinit var binding : ActivityLoginBinding
    private lateinit var  localDB : LocalDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        localDB = LocalDB(this, DATEBASE_NAME, null, DATEBASE_VERSION)

        binding.LBtn1.setOnClickListener { view->

            val phone = binding.LEdit.text.toString()
            val exist = localDB.logIn(phone)


            if(exist){
                val intent = Intent(this,MainActivity::class.java)
                intent.putExtra("Phone", phone)
                startActivity(intent)
            }

            else{
                Toast.makeText(this@LoginActivity, "존재하는 휴대폰 번호가 없습니다.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.LBtn2.setOnClickListener { view ->
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onDestroy() {
        localDB.close()
        super.onDestroy()
    }
}

