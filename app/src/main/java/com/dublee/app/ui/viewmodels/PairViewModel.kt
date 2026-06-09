package com.dublee.app.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dublee.app.domain.providers.PairManager
import com.dublee.app.domain.providers.PairProviderImpl
import com.dublee.app.domain.providers.Session
import com.dublee.app.domain.providers.UserIconProvider
import com.dublee.app.domain.providers.UserProviderImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PairViewModel(
    userProviderImpl: UserProviderImpl,
    pairProviderImpl: PairProviderImpl
) : ViewModel(),
    Session by userProviderImpl,
    UserIconProvider by userProviderImpl,
    PairManager by pairProviderImpl {
    private val _errorMsg = MutableStateFlow<String?>(null)
    val errorMsg = _errorMsg.asStateFlow()
    private val _myCode = MutableStateFlow("")
    val myCode = _myCode.asStateFlow()


    init {
        if (partner.value.id < 0) {
            tryGetCode()
        }
    }

    fun tryJoinPair(inviteCode: String, onSuccess: () -> Unit) {
        if (inviteCode.isBlank()) {
            _errorMsg.value = "Заполните код пары"
            return
        }
        viewModelScope.launch {
            val success = joinPair(inviteCode)
            if (success) {
                onSuccess()
            } else {
                _errorMsg.value = "Неверный код или пара заполнена"
            }
        }
    }

    fun tryLeavePair(onSuccess: () -> Unit) {
        viewModelScope.launch {
            val success = leavePair()
            if (success) onSuccess()
            else _errorMsg.value = "Не удалось покинуть пару"
        }
    }

    fun tryCreatePair() {
        viewModelScope.launch {
            val success = createPair()
            if (success.first) {
                _myCode.value = success.second!!
            } else _errorMsg.value = "Не удалось создать пару"
        }
    }

    fun tryGetCode() {
        viewModelScope.launch {
            val success = getCode()
            if (success.first) {
                if (success.second == null) {
                    tryCreatePair();
                } else {
                    _myCode.value = success.second!!
                }
            } else _errorMsg.value = "Не удалось создать пару"
        }
    }
}