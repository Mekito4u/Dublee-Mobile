package com.dublee.app.domain.usecases

import com.dublee.app.domain.models.UserModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

open class PartnerSession() {
    private val emptyPartner = UserModel.emptyPair().second
    private val _partner = MutableStateFlow(emptyPartner)
    open val partner: StateFlow<UserModel> = _partner.asStateFlow()


    fun loadPartner(partner: UserModel) {
        _partner.value = partner
    }
}