package com.example.android_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_project.databinding.ActivityModifyBinding

class modifyActivity : AppCompatActivity() {
    val DATABASE_VERSION = 1
    val DATABASE_NAME = "LocalDB.db"

    private lateinit var  binding : ActivityModifyBinding
    private lateinit var localDB : LocalDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modify)

        binding = ActivityModifyBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        localDB = LocalDB(this, DATABASE_NAME, null, DATABASE_VERSION)

        binding.ModifyBtn1.setOnClickListener {
            try{
                localDB.updateData(
                    binding.ModifyPhone.text.toString().trim(),
                    binding.ModifyIllness.text.toString().trim(),
                    binding.ModifyEmergency.text.toString().trim(),
                    binding.ModifyHospital.text.toString().trim(),
                    binding.ModifyMedicine.text.toString().trim(),
                )
            }catch (e: Exception){
                e.printStackTrace()
            }

            val intent = Intent(this, InformationActivity::class.java)
            intent.putExtra("Phone", binding.ModifyPhone.text.toString())
            startActivity(intent)
        }


    }
}