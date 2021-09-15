package com.example.guest.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.guest.repository.util.DataBaseConstants

class DataBaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_GUEST)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "guests.db"

        private const val CREATE_TABLE_GUEST = ("CREATE TABLE " + DataBaseConstants.GUEST.TABLE_NAME
                + " (" + DataBaseConstants.GUEST.COLUMNS.ID + " INTEGER primary key autoincrement, "
                + DataBaseConstants.GUEST.COLUMNS.NAME + " TEXT, "
                + DataBaseConstants.GUEST.COLUMNS.PRESENCE + " INTEGER);")
    }
}