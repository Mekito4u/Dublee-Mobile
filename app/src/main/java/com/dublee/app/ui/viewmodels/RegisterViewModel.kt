package com.dublee.app.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dublee.app.data.repositories.UserRepository
import com.dublee.app.domain.usecases.UserSession
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val userRepository: UserRepository,
    private val userSession: UserSession,
) : ViewModel() {
    val user = userSession.user
    private val _errorMsg = MutableStateFlow<String?>(null)
    val errorMsg = _errorMsg.asStateFlow()

    fun register(login: String, password: String, onSuccess: () -> Unit) {
        if (login.isBlank() || password.isBlank()) {
            _errorMsg.value = "Заполните логин и пароль"
            return
        }

        viewModelScope.launch {
            val (user, message) = userRepository.register(login, password)
            if (message == null) {
                userSession.updateUser(user!!)
                onSuccess()
            } else {
                _errorMsg.value = message
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