package com.app.ui.viewmodel.basic

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RegisterViewModel() : ViewModel() {
    private val _errorMsg = MutableStateFlow<String?>(null)
    val errorMsg = _errorMsg.asStateFlow()

    fun registerUser(login: String, password: String, repeatPassword: String) {
        if (password != repeatPassword) {
            _errorMsg.value = "Пароли не совпадают"
        }

    }
}