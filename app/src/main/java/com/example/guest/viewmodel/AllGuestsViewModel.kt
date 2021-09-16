package com.example.guest.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.guest.model.GuestModel
import com.example.guest.repository.GuestRepository

class AllGuestsViewModel(application: Application) : AndroidViewModel(application) {

    private val mGuestRepository = GuestRepository.getInstance(application.applicationContext)

    private val mGuests = MutableLiveData<List<GuestModel>>()
    val guests: LiveData<List<GuestModel>> = mGuests

    fun load(){
        mGuests.value = mGuestRepository.getAll()
    }

    fun delete(id: Int) {
        mGuestRepository.delete(id)
    }
}