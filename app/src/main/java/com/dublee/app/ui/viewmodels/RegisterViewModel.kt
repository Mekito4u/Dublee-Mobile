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

class RegisterViewModel(
    userProviderImpl: UserProviderImpl
) : ViewModel(),
    UserAuth by userProviderImpl,
    Session by userProviderImpl,
    UserAndPartnerLoader by userProviderImpl{
    private val _errorMsg = MutableStateFlow<String?>(null)
    val errorMsg = _errorMsg.asStateFlow()

    fun trySignUp(login: String, password: String, onSuccess: () -> Unit) {
        if (login.isBlank() || password.isBlank()) {
            _errorMsg.value = "Заполните логин и пароль"
            return
        }
        println("=== Try sign up: $login $password")
        viewModelScope.launch {
            val success = register(login, password)
            if (success) {
                onSuccess()
            } else {
                _errorMsg.value = "Логин уже занят("
            }
        }
    }

    fun checkPasswords(password1: String, password2: String): Boolean {
        if (password1 != password2) {
            _errorMsg.value = "Пароли не совпадают!"
            return false
        } else {
            return true
        }
    }
}