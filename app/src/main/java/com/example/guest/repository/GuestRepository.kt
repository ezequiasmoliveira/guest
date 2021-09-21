package com.example.guest.repository

import android.content.Context
import com.example.guest.model.GuestModel

class GuestRepository(context: Context) {

    private val mDataBase = GuestDataBase.getDataBse(context).guestDAO()

    fun save(guest: GuestModel): Boolean {
        return mDataBase.save(guest) > 0
    }

    fun update(guest: GuestModel): Boolean{
        return mDataBase.update(guest) > 0
    }

    fun delete(guest: GuestModel) {
        mDataBase.delete(guest)
    }

    fun get(id: Int): GuestModel {
        return mDataBase.get(id)
    }

    fun getAll(): List<GuestModel> {
        return mDataBase.getAll()
    }

    fun getPresents(): List<GuestModel> {
        return mDataBase.getPresents()
    }

    fun getAbsents(): List<GuestModel> {
        return mDataBase.getAbsents()
    }

}