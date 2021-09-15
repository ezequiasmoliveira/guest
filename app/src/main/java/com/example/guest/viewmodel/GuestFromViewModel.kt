package com.example.guest.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.guest.model.GuestModel
import com.example.guest.repository.GuestRepository

class GuestFromViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext = application.applicationContext
    private val mGuestRepository: GuestRepository = GuestRepository.getInstance(mContext)

    private var mSaveGuest = MutableLiveData<Boolean>()
    private var mGuest = MutableLiveData<GuestModel>()

    val saveGuest: LiveData<Boolean> = mSaveGuest
    val guest: LiveData<GuestModel> = mGuest

    fun save(name: String, presence: Boolean) {
        val guest = GuestModel(name = name, presence = presence)
        mSaveGuest.value = mGuestRepository.save(guest)
    }

    fun load(id: Int) {
        mGuest.value = mGuestRepository.get(id)
    }

}