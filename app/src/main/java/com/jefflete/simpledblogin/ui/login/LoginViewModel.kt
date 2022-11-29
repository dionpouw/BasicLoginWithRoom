package com.jefflete.simpledblogin.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jefflete.simpledblogin.data.Repository
import com.jefflete.simpledblogin.data.local.entity.Accounts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private var _account = MutableLiveData<Accounts?>()
    val account get() = _account

    fun login(accounts: Accounts) {
        viewModelScope.launch { _account.value = repository.login(accounts) }
    }
}