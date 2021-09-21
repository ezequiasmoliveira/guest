package com.example.guest.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.guest.model.GuestModel

@Database(entities = [GuestModel::class], version = 1)
abstract class GuestDataBase : RoomDatabase() {

    abstract fun guestDAO(): GuestDAO

    companion object{
        private lateinit var INSTANCE: GuestDataBase

        fun getDataBse(context: Context): GuestDataBase{
            if (!::INSTANCE.isInitialized){
                synchronized(GuestDataBase::class.java) {
                    INSTANCE = Room.databaseBuilder(context, GuestDataBase::class.java, "guestDB")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}