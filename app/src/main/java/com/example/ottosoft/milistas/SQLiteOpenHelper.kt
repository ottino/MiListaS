package com.example.ottosoft.milistas

import android.content.Context
import android.database.sqlite.SQLiteDatabase

open class SQLiteOpenHelper(context: Context, dB_NAME: Any?, nothing: Nothing?, dB_VERSION: Any?) {
    open fun onCreate(db: SQLiteDatabase) {}
    open fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}
}