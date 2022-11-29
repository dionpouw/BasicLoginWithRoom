package com.jefflete.simpledblogin.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jefflete.simpledblogin.data.local.entity.Accounts

@Database(entities = [Accounts::class], version = 1, exportSchema = false)
abstract class AccountDatabase :RoomDatabase() {
    abstract fun accountDao(): AccountDao
}