package com.example.guest.repository.util

class DataBaseConstants private constructor() {

    /**
     *Database table
     */
    object GUEST {
        const val TABLE_NAME = "Guest"
        object COLUMNS {
            const val ID = "id"
            const val NAME = "name"
            const val PRESENCE = "presence"
        }
    }
}