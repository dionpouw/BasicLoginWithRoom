package com.jefflete.simpledblogin.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jefflete.simpledblogin.data.local.entity.Accounts

@Dao
interface AccountDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertAccount(account: Accounts)

    @Query("SELECT * FROM accounts WHERE username = :username")
    suspend fun getAccount(username: String): Accounts
}