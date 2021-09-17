package com.example.guest.constants

class GuestConstants private constructor(){
    companion object{
        const val GUEST_ID = "guestID"


    }

    object FILTER {
        const val EMPTY = 0
        const val PRESENT = 1
        const val ABSENT = 2
    }
}
