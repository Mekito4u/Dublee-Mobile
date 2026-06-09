package com.dublee.app.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dublee.app.domain.providers.Session
import com.dublee.app.domain.providers.UserAndPartnerLoader
import com.dublee.app.domain.providers.UserAuth
import com.dublee.app.domain.providers.UserIconProvider
import com.dublee.app.domain.providers.UserProviderImpl
import kotlinx.coroutines.launch

class ProfileViewModel(
    userProviderImpl: UserProviderImpl,
) : ViewModel(),
    Session by userProviderImpl,
    UserAndPartnerLoader by userProviderImpl,
    UserIconProvider by userProviderImpl,
    UserAuth by userProviderImpl {

    init {
        viewModelScope.launch {
            loadUserAndPartner()
        }
    }
}