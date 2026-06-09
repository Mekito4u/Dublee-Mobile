package com.dublee.app.domain.usecases

import com.dublee.app.domain.models.UserModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

open class UserSession() {
    private val emptyUser = UserModel.emptyPair().first
    private val _user = MutableStateFlow(emptyUser)
    open val user = _user.asStateFlow()


    fun loadUser(user: UserModel) {
        _user.value = user
    }
}