package com.dublee.app.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dublee.app.data.repositories.UserRepository
import com.dublee.app.domain.usecases.PartnerSession
import com.dublee.app.domain.usecases.UserSession
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val userRepository: UserRepository,
    private val userSession: UserSession,
    private val partnerSession: PartnerSession,
) : ViewModel() {
    val user = userSession.user
    val partner = partnerSession.partner

    private val _errorMsg = MutableStateFlow<String?>(null)
    val errorMsg = _errorMsg.asStateFlow()

    fun login(login: String, password: String, onSuccess: () -> Unit) {
        if (login.isBlank() || password.isBlank()) {
            _errorMsg.value = "Заполните логин и пароль"
            return
        }

        viewModelScope.launch {
            val (user, message) = userRepository.login(login, password)
            if (message == null) {
                userSession.updateUser(user!!)
                val (partner, partnerMessage) = userRepository.getPartner()
                if (partnerMessage == null) {
                    partnerSession.updatePartner(partner!!)
                }
                onSuccess()
            } else {
                _errorMsg.value = message
            }
        }
    }
}