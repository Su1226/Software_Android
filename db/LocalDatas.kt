package com.example.android_project

import android.content.Context
import android.provider.BaseColumns

object LocalDatas { //  로컬 데이터 베이스의 자료형태 정의된 object
    object userData : BaseColumns {  //
        const val TABLE_NAME = "guest"
        const val COLUMN_NAME_NAME = "name"
        const val COLUMN_NAME_PHONE = "phone"
        const val COLUMN_NAME_BIRTHDAY = "birthday"
        const val COLUMN_NAME_BLOOD = "blood"
        const val COLUMN_NAME_TALL = "tall"
        const val COLUMN_NAME_WEIGHT = "weight"
        const val COLUMN_NAME_ILLNESS = "illness"
        const val COLUMN_NAME_EMERGENCY = "emergency"
        const val COLUMN_NAME_HOSPITAL = "hospital"
        const val COLUMN_NAME_MEDICINE = "medicine"

    }
}