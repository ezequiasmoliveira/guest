package com.example.guest.repository

import android.content.ContentValues
import android.content.Context
import com.example.guest.model.GuestModel
import com.example.guest.repository.util.DataBaseConstants

class GuestRepository private constructor(context: Context) {
    private var mDataBaseHelper: DataBaseHelper = DataBaseHelper(context)

    companion object {
        private lateinit var repository: GuestRepository

        fun getInstance(context: Context): GuestRepository {
            if (!::repository.isInitialized) {
                repository = GuestRepository(context)
            }
            return repository
        }
    }

    fun save(guest: GuestModel){
        try {
            val db = mDataBaseHelper.writableDatabase

            val contentValues = ContentValues()
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guest.presence)

            db.insert(DataBaseConstants.GUEST.TABLE_NAME, null, contentValues)
            true
        } catch (ex: Exception) {
            false
        }
    }

    fun update(guest: GuestModel){}

    fun delete(guest: GuestModel){}

    fun getAll(): List<GuestModel> {
        val guests: MutableList<GuestModel> = ArrayList()
        return guests
    }

    fun getPresents(): List<GuestModel> {
        val guests: MutableList<GuestModel> = ArrayList()
        return guests
    }

    fun getAbsents(): List<GuestModel> {
        val guests: MutableList<GuestModel> = ArrayList()
        return guests
    }


}