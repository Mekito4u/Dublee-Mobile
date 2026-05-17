package com.app.domain.usecases

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.app.data.repositories.profile.UserRepository
import com.app.domain.models.basic.UserModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class UserSession() {
    private val repo = UserRepository()
    private val pairSession = PartnerSession()


    private val emptyUser = UserModel.empty()
    private val _user = MutableStateFlow(emptyUser)
    val user = _user.asStateFlow()

    private val _icon = MutableStateFlow<ImageVector>(repo.getUserIcon(user.value.iconId))
    val icon = _icon.asStateFlow()

    private val _iconColor = MutableStateFlow<Color>(repo.getUserIconColor(user.value.iconColorId))
    val iconColor = _iconColor.asStateFlow()

    fun loadUser(userId: Int) {
        val curr = repo.getUserById(userId)
        _user.value = curr
        _icon.value = repo.getUserIcon(curr.iconId)
        _iconColor.value = repo.getUserIconColor(curr.iconColorId)
        pairSession.loadPartner(curr.id)
    }

    fun updateIcon(iconId: Int) {
        _user.value.let { user ->
            _user.value = user.copy(iconId = iconId)
            repo.setUserIcon(user.id, iconId)
        }
    }

    fun updateColor(colorId: Int) {
        _user.value.let { user ->
            _user.value = user.copy(iconColorId = colorId)
            repo.setUserIconColor(user.id, colorId)
        }
    }

    fun leavePair() {
        val currentUser = _user.value
        val updatedUser = currentUser.copy(pairId = null)
        _user.value = updatedUser
        repo.setPairId(currentUser.id, null)
    }

    fun joinPair() {
        val currentUser = _user.value
        val updatedUser = currentUser.copy(pairId = 2)
        _user.value = updatedUser
        repo.setPairId(currentUser.id, 2)
    }
}