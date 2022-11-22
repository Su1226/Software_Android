package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import android.content.Intent
import android.net.Uri
import android.widget.Button
import android.widget.EditText
import java.util.Random

class randomActivity : AppCompatActivity(){
    val DATAEBASE_PHONE = "LocalDB.db"
    val DATEBASE_VERSION = 1

    private lateinit var localDB: LocalDB
    lateinit var checkBtn : Button
    lateinit var callBtn : Button
    lateinit var returnBtn : Button
    val CALL_REQUEST_CODE = 100
    val random = Random()
    override fun onCreate(savedInstanceState: Bundle?) {
        localDB = LocalDB(this, DATAEBASE_PHONE, null, DATEBASE_VERSION)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random)
        var arraya = localDB.rancall()

        checkBtn = findViewById<Button>(R.id.checkBtn)
        callBtn = findViewById<Button>(R.id.callBtn)
        returnBtn = findViewById<Button>(R.id.returnBtn)
        callBtn.setOnClickListener {
            var num2 = random.nextInt(arraya.size)
            val num = Uri.parse("tel:"+arraya[num2])
            val callIntent = Intent(Intent.ACTION_CALL, num)
            if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED){
                callAlertDlg()
            }else{
                startActivity(callIntent)
            }
        }
        returnBtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        checkBtn.setOnClickListener{
            var a : String = ""
            for(i in arraya){
                a = a + i
            }
            Toast.makeText(this,a,Toast.LENGTH_LONG).show()
        }
    }
    fun callAlertDlg(){
        val builder = AlertDialog.Builder(this)
        builder.setMessage("CALL_PHONE 권한이 필요합니다.")
        builder.setTitle("권한허용")
        builder.setPositiveButton("OK"){ _,_ ->
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), CALL_REQUEST_CODE)
        }
        val dlg = builder.create()
        dlg.show()
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            CALL_REQUEST_CODE -> {
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "권한 승인", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "권한 승인 거부", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}