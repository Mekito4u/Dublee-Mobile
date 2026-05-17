package com.app.ui.viewmodel.basic

import androidx.lifecycle.ViewModel
import com.app.domain.usecases.PartnerSession
import com.app.domain.usecases.UserSession

abstract class BasePairViewModel() : ViewModel() {
    protected val userSession = UserSession()
    protected val partnerSession = PartnerSession()

    val user = userSession.user
    val partner = partnerSession.partner
    val userIcon = userSession.icon
    val userColor = userSession.iconColor
    val partnerIcon = partnerSession.icon
    val partnerColor = partnerSession.iconColor

    init {
        loadData()
    }

    private fun loadData() {
        userSession.loadUser(1)
        partnerSession.loadPartner(1)
    }
}