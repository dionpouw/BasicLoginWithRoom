package com.jefflete.simpledblogin.data.local

import com.jefflete.simpledblogin.data.local.db.AccountDao
import com.jefflete.simpledblogin.data.local.entity.Accounts
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val accountDao: AccountDao
) {
    suspend fun getAccount(account: Accounts) = accountDao.getAccount(account.username)
    suspend fun insertAccount(account: Accounts) = accountDao.insertAccount(account)
}
