package com.example.guest.repository

import com.example.guest.model.GuestModel

class GuestRepository {

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

    fun save(guest: GuestModel){}

    fun update(guest: GuestModel){}

    fun delete(guest: GuestModel){}
}