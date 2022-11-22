package com.example.android_project

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import android.widget.Toast
import java.lang.Exception
import java.nio.file.Files

class LocalDB (
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            createDatabase(db)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val sql : String = "DROP TABLE if exists ${LocalDatas.userData.TABLE_NAME}"

        if (db != null) {
            db.execSQL(sql)
            onCreate(db)
        }
    }

    fun createDatabase(db: SQLiteDatabase) {
        var sql: String = "CREATE TABLE if not exists ${LocalDatas.userData.TABLE_NAME} (" +
                "${BaseColumns._ID} integer primary key autoincrement," +
                "${LocalDatas.userData.COLUMN_NAME_NAME} varchar(20)," +
                "${LocalDatas.userData.COLUMN_NAME_PHONE} varchar(20)," +
                "${LocalDatas.userData.COLUMN_NAME_BIRTHDAY} varchar(20)," +
                "${LocalDatas.userData.COLUMN_NAME_BLOOD} varchar(20)," +
                "${LocalDatas.userData.COLUMN_NAME_TALL} varchar(20)," +
                "${LocalDatas.userData.COLUMN_NAME_WEIGHT} varchar(20)," +
                "${LocalDatas.userData.COLUMN_NAME_ILLNESS} varchar(20)," +
                "${LocalDatas.userData.COLUMN_NAME_EMERGENCY} varchar(20)," +
                "${LocalDatas.userData.COLUMN_NAME_HOSPITAL} varchar(20)," +
                "${LocalDatas.userData.COLUMN_NAME_MEDICINE} varchar(20)" +
                ");"

        db.execSQL(sql)
    }

    fun registerUser( name : String, phone : String, birthday : String, blood : String, tall : String, weight : String, illness : String, emergency : String,  hospital : String, medicine : String)
    {
        val db =this.writableDatabase
        val values = ContentValues().apply {
            put(LocalDatas.userData.COLUMN_NAME_NAME, name)
            put(LocalDatas.userData.COLUMN_NAME_PHONE, phone)
            put(LocalDatas.userData.COLUMN_NAME_BIRTHDAY, birthday)
            put(LocalDatas.userData.COLUMN_NAME_BLOOD, blood)
            put(LocalDatas.userData.COLUMN_NAME_TALL, tall)
            put(LocalDatas.userData.COLUMN_NAME_WEIGHT, weight)
            put(LocalDatas.userData.COLUMN_NAME_ILLNESS, illness)
            put(LocalDatas.userData.COLUMN_NAME_EMERGENCY, emergency)
            put(LocalDatas.userData.COLUMN_NAME_HOSPITAL, hospital)
            put(LocalDatas.userData.COLUMN_NAME_MEDICINE, medicine)
        }
        val newRowId = db?.insert(LocalDatas.userData.TABLE_NAME, null, values)
    }

    fun checkIdExist(phone: String): Boolean {
        val db = this.readableDatabase

        val projection = arrayOf(BaseColumns._ID)

        val selection = "${LocalDatas.userData.COLUMN_NAME_PHONE} = ?"
        val selectionArgs = arrayOf(phone)

        val cursor = db.query(
            LocalDatas.userData.TABLE_NAME,
            projection,
            selection,
            selectionArgs,
            null,
            null,
            null
        )
        if(cursor.count>0){
            return true;
        }else{
            return false;
        }

    }

    fun logIn(phone: String): Boolean {
        val db = this.readableDatabase

        // 리턴받고자 하는 컬럼 값의 array
        val projection = arrayOf(BaseColumns._ID)

        val selection = "${LocalDatas.userData.COLUMN_NAME_PHONE} = ?"
        val selectionArgs = arrayOf(phone)


        val cursor = db.query(
            LocalDatas.userData.TABLE_NAME,   // 테이블
            projection,             // 리턴 받고자 하는 컬럼
            selection,              // where 조건
            selectionArgs,          // where 조건에 해당하는 값의 배열
            null,                   // 그룹 조건
            null,                   // having 조건
            null               // orderby 조건 지정
        )
        if(cursor.count>0){//  반환된 cursor의 0번째 값이 null이면
            return true;
        }else {
            return false;
        }
    }


    fun getAllData(phone:String) : String {
        var result = "No data in DB"

        val db = this.readableDatabase

        //var sql : String = "select * from guest where phone = 'admin'"
        var sql : String = "select * from guest where phone = \'$phone\'"
        val cursor = db.rawQuery(sql, null)

            try {
                if (cursor.count != 0) {
                    val stringBuffer = StringBuffer()

                    while (cursor.moveToNext()) {
                        stringBuffer.append("이름 : " + cursor.getString(1).toString() + "\n"+ "\n")
                        stringBuffer.append("생년월일 : " + cursor.getString(3) + "\n"+ "\n")
                        stringBuffer.append("혈액형 : " + cursor.getString(4).toString() + "형" + "\n"+ "\n")
                        stringBuffer.append("키 : " + cursor.getString(5).toString() + "\n"+ "\n")
                        stringBuffer.append("몸무게 : " + cursor.getString(6).toString() + "\n"+ "\n")
                        stringBuffer.append("지병 : " + cursor.getString(7).toString() + "\n"+ "\n")
                        stringBuffer.append("긴급 번호 : " + cursor.getString(8).toString() + "\n"+ "\n")
                        stringBuffer.append("병원 : " + cursor.getString(9).toString() + "\n"+ "\n")
                        stringBuffer.append("복용약 : " + cursor.getString(10).toString())
                    }

                    result = stringBuffer.toString()
                } //bytearray 타입
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                if (cursor != null && !cursor.isClosed) {
                    cursor.close()
                }
            }

        return result
    }

    fun updateData(phone :String, illness: String, emergency: String, hospital: String, medicine: String){
        val db = this.writableDatabase

        val contentValues = ContentValues().apply {
            put(LocalDatas.userData.COLUMN_NAME_PHONE, phone)
            put(LocalDatas.userData.COLUMN_NAME_ILLNESS, illness)
            put(LocalDatas.userData.COLUMN_NAME_EMERGENCY, emergency)
            put(LocalDatas.userData.COLUMN_NAME_HOSPITAL, hospital)
            put(LocalDatas.userData.COLUMN_NAME_MEDICINE, medicine)
        }

        db.update(LocalDatas.userData.TABLE_NAME, contentValues, "${LocalDatas.userData.COLUMN_NAME_PHONE} = ?", arrayOf(phone))
    }
}

