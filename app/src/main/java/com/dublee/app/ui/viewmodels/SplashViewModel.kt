package com.dublee.app.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.dublee.app.Nav
import com.dublee.app.domain.providers.PairManager
import com.dublee.app.domain.providers.PairProviderImpl
import com.dublee.app.domain.providers.Session
import com.dublee.app.domain.providers.UserAndPartnerLoader
import com.dublee.app.domain.providers.UserAuth
import com.dublee.app.domain.providers.UserProviderImpl

class SplashViewModel(
    userProviderImpl: UserProviderImpl,
    pairProviderImpl: PairProviderImpl
) : ViewModel(),
    UserAuth by userProviderImpl,
    UserAndPartnerLoader by userProviderImpl,
    Session by userProviderImpl,
    PairManager by pairProviderImpl {

    suspend fun getStartRoute(): String {
        val token = getToken()
        if (token != null) {
            loadUserAndPartner()
            if (partner.value.id < 0) {
                return Nav.Pair.route
            }
            return Nav.Main.route
        } else {
            return Nav.Login.route
        }
    }
}