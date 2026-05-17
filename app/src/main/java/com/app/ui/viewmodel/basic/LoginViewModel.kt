package com.app.ui.viewmodel.basic

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel() : ViewModel() {
    private val _errorMsg = MutableStateFlow<String?>(null)
    val errorMsg = _errorMsg.asStateFlow()

    fun loginUser(login: String, password: String) {
        val confirmPassword = "123"
        if (password != confirmPassword) {
            _errorMsg.value = "Неверный логин или пароль"
        }

    }
}