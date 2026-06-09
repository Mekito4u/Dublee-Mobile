package com.dublee.app.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dublee.app.domain.providers.Session
import com.dublee.app.domain.providers.UserAndPartnerLoader
import com.dublee.app.domain.providers.UserAuth
import com.dublee.app.domain.providers.UserProviderImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    userProviderImpl: UserProviderImpl
) : ViewModel(),
    UserAuth by userProviderImpl,
    Session by userProviderImpl,
    UserAndPartnerLoader by userProviderImpl{
    private val _errorMsg = MutableStateFlow<String?>(null)
    val errorMsg = _errorMsg.asStateFlow()

    fun trySignIn(login: String, password: String, onSuccess: () -> Unit) {
        if (login.isBlank() || password.isBlank()) {
            _errorMsg.value = "Заполните логин и пароль"
            return
        }
        println("=== Try sign in: $login $password")
        viewModelScope.launch {
            val success = login(login, password)
            if (success) {
                onSuccess()
            } else {
                _errorMsg.value = "Неверный логин или пароль"
            }
        }
    }
}