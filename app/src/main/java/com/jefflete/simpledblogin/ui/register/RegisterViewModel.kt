package com.jefflete.simpledblogin.ui.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jefflete.simpledblogin.data.Repository
import com.jefflete.simpledblogin.data.local.entity.Accounts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    fun register(accounts: Accounts) {
        viewModelScope.launch {
            repository.register(accounts)
        }
    }
}