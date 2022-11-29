package com.jefflete.simpledblogin.module

import android.app.Application
import androidx.room.Room
import com.jefflete.simpledblogin.data.Repository
import com.jefflete.simpledblogin.data.local.LocalDataSource
import com.jefflete.simpledblogin.data.local.db.AccountDao
import com.jefflete.simpledblogin.data.local.db.AccountDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAccountDao(db: AccountDatabase) = db.accountDao()

    @Singleton
    @Provides
    fun provideAppDatabase(app: Application): AccountDatabase =
        Room.databaseBuilder(app, AccountDatabase::class.java, "accounts.db").build()

    @Singleton
    @Provides
    fun provideLocalDataSource(accountDao: AccountDao) = LocalDataSource(accountDao)

    @Singleton
    @Provides
    fun provideRepository(localDataSource: LocalDataSource) = Repository(localDataSource)
}
