package com.dublee.app.domain.usecases

import com.dublee.app.domain.models.UserModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class UserSession() {
    private val emptyUser = UserModel.emptyPair().first
    private val _user = MutableStateFlow(emptyUser)
    val user = _user.asStateFlow()


    fun updateUser(user: UserModel) {
        _user.value = user
    }

    fun clearUser() {
        _user.value = emptyUser
    }
}