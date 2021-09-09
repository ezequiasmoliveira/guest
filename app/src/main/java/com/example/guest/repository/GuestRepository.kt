package com.example.guest.repository

import android.content.Context
import com.example.guest.model.GuestModel

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
        mDataBaseHelper.writableDatabase
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