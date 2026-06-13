package com.dublee.app.domain.usecases

import com.dublee.app.domain.models.UserModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PartnerSession() {
    private val emptyPartner = UserModel.emptyPair().second
    private val _partner = MutableStateFlow(emptyPartner)
    val partner = _partner.asStateFlow()


    fun updatePartner(user: UserModel) {
        _partner.value = user
    }

    fun clearPartner() {
        _partner.value = emptyPartner
    }
}