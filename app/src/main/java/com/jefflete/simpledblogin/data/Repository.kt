package com.jefflete.simpledblogin.data

import com.jefflete.simpledblogin.data.local.LocalDataSource
import com.jefflete.simpledblogin.data.local.entity.Accounts
import javax.inject.Inject

class Repository @Inject constructor(
    private val localDataSource: LocalDataSource
) {
    suspend fun login(account: Accounts) = localDataSource.getAccount(account)
    suspend fun register(account: Accounts) = localDataSource.insertAccount(account)
}