package com.jefflete.simpledblogin.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "accounts")
data class Accounts(

    @PrimaryKey
    val username:String,
    val password:String
)
