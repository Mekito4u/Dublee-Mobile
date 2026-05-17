package com.app.ui.viewmodel.basic

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PairViewModel() : BasePairViewModel() {
    private val _inviteCode = MutableStateFlow("")
    val inviteCode = _inviteCode.asStateFlow()

    fun generateCode() {
        val code = (100000..999999).random().toString()
        _inviteCode.value = "1"
        // TODO: потом отправить на сервер
    }

    fun joinPair(code: String) {
        // TODO: Если код верный, то добавить в пару
        if (code == _inviteCode.value) {
            userSession.joinPair()
        }
    }

    fun leavePair() {
        userSession.leavePair()
    }
}