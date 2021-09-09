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

    fun save(guest: GuestModel): Boolean {
        return try {
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

    fun update(guest: GuestModel): Boolean{
        return try {
            val db = mDataBaseHelper.writableDatabase

            val contentValues = ContentValues()
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guest.presence)

            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?"
            val args = arrayOf(guest.id.toString())

            db.update(DataBaseConstants.GUEST.TABLE_NAME, contentValues, selection, args)
            true
        } catch (ex: Exception) {
            false
        }
    }

    fun delete(id: Int): Boolean{
        return try {
            val db = mDataBaseHelper.writableDatabase

            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?"
            val args = arrayOf(id.toString())

            db.delete(DataBaseConstants.GUEST.TABLE_NAME, selection, args)
            true
        } catch (ex: Exception) {
            false
        }
    }

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