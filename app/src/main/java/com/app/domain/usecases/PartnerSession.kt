package com.app.domain.usecases

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.app.data.repositories.PairRepository
import com.app.data.repositories.profile.UserRepository
import com.app.domain.models.basic.UserModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PartnerSession() {
    private val repo = PairRepository()
    private val userRepo = UserRepository()


    private val emptyPartner = UserModel.empty()
    private val _partner = MutableStateFlow(emptyPartner)
    val partner = _partner.asStateFlow()

    private val _icon = MutableStateFlow<ImageVector>(userRepo.getUserIcon(partner.value.iconId))
    val icon = _icon.asStateFlow()

    private val _iconColor =
        MutableStateFlow<Color>(userRepo.getUserIconColor(partner.value.iconColorId))
    val iconColor = _iconColor.asStateFlow()

    fun loadPartner(userId: Int) {
        val partnerId = repo.getPartnerId(userId) ?: return
        _partner.value = userRepo.getUserById(partnerId)
    }

    fun clearPartner() {
        _partner.value = UserModel.empty()
        _icon.value = userRepo.getUserIcon(partner.value.iconId)
        _iconColor.value = userRepo.getUserIconColor(partner.value.iconColorId)
    }
}