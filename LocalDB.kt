package com.example.projectteam

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

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
        val sql2 : String = "DROP TABLE if exists ${LocalDatas.info.TABLE_NAME2}"

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
                "${LocalDatas.userData.COLUMN_NAME_BIRTHDAY} varchar(20)" +
                ");"

        db.execSQL(sql)
    }

    fun createDatabase2(db: SQLiteDatabase) {
        val sql2 : String = "CREATE TABLE if not exists ${LocalDatas.info.TABLE_NAME2} (" +
                "${BaseColumns._ID} integer primary key autoincrement," +
                "${LocalDatas.info.COLUMN_NAME_BLOOD} varchar(20)," +
                "${LocalDatas.info.COLUMN_NAME_TALL} varchar(20)," +
                "${LocalDatas.info.COLUMN_NAME_WEIGHT} varchar(20)," +
                "${LocalDatas.info.COLUMN_NAME_ILLNESS} varchar(20)," +
                "${LocalDatas.info.COLUMN_NAME_EMERGENCY1} varchar(20)," +
                "${LocalDatas.info.COLUMN_NAME_EMERGENCY2} varchar(20)," +
                "${LocalDatas.info.COLUMN_NAME_HOSPITAL} varchar(20)," +
                "${LocalDatas.info.COLUMN_NAME_MEDICINE} varchar(20)" +
                ");"

        db.execSQL(sql2)
    }

    fun registerUser( name : String, phone : String, birthday : String)
    {
        val db =this.writableDatabase
        val values = ContentValues().apply {
            put(LocalDatas.userData.COLUMN_NAME_NAME, name)
            put(LocalDatas.userData.COLUMN_NAME_PHONE, phone)
            put(LocalDatas.userData.COLUMN_NAME_BIRTHDAY, birthday)
        }
        val newRowId = db?.insert(LocalDatas.userData.TABLE_NAME, null, values)
    }

    fun registerUser2(blood : String, tall : String, weight : String, illness : String, emergency1 : String, emergency2 : String, hospital : String, medicine : String)
    {
        val db =this.writableDatabase
        val values = ContentValues().apply {
            put(LocalDatas.info.COLUMN_NAME_BLOOD, blood)
            put(LocalDatas.info.COLUMN_NAME_TALL, tall)
            put(LocalDatas.info.COLUMN_NAME_WEIGHT, weight)
            put(LocalDatas.info.COLUMN_NAME_ILLNESS, illness)
            put(LocalDatas.info.COLUMN_NAME_EMERGENCY1, emergency1)
            put(LocalDatas.info.COLUMN_NAME_EMERGENCY2, emergency2)
            put(LocalDatas.info.COLUMN_NAME_HOSPITAL, hospital)
            put(LocalDatas.info.COLUMN_NAME_MEDICINE, medicine)
        }
        val newRowId = db?.insert(LocalDatas.info.TABLE_NAME2, null, values)
    }

    fun checkIdExist(phone: String): Boolean {
        val db = this.readableDatabase

        // 리턴받고자 하는 컬럼 값의 array
        val projection = arrayOf(BaseColumns._ID)
        //,LocalDatas.userData.COLUMN_NAME_ID, LocalDatas.userData.COLUMN_NAME_PASSWORD)


        //  WHERE "id" = id AND "password"=password 구문 적용하는 부분
        val selection = "${LocalDatas.userData.COLUMN_NAME_PHONE} = ?"
        val selectionArgs = arrayOf(phone)

//         정렬조건 지정
//        val sortOrder = "${FeedEntry.COLUMN_NAME_SUBTITLE} DESC"

        val cursor = db.query(
            LocalDatas.userData.TABLE_NAME,   // 테이블
            projection,             // 리턴 받고자 하는 컬럼
            selection,              // where 조건
            selectionArgs,          // where 조건에 해당하는 값의 배열
            null,                   // 그룹 조건
            null,                   // having 조건
            null               // orderby 조건 지정
        )
        if(cursor.count>0){//  반환된 cursor 값이 존재
            return true;
        }else{//반환된 cursor 값이 없음
            return false;
        }

    }

    fun logIn(phone: String): Boolean {
        val db = this.readableDatabase

        // 리턴받고자 하는 컬럼 값의 array
        val projection = arrayOf(BaseColumns._ID)
        //,LocalDatas.userData.COLUMN_NAME_ID, LocalDatas.userData.COLUMN_NAME_PASSWORD)


        //  WHERE "id" = id AND "password"=password 구문 적용하는 부분
        val selection = "${LocalDatas.userData.COLUMN_NAME_PHONE} = ?"
        val selectionArgs = arrayOf(phone)

//         정렬조건 지정
//        val sortOrder = "${FeedEntry.COLUMN_NAME_SUBTITLE} DESC"

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
        }else{
            return false;
        }

    }
}


