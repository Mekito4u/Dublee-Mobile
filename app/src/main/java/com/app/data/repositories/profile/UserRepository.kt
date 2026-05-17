package com.app.data.repositories.profile

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.app.data.repositories.PairRepository
import com.app.domain.models.basic.UserModel

class UserRepository() {
    private val pairRepo = PairRepository()
    private val iconRepo = UserIconRepository()
    private val colorRepo = UserIconColorRepository()

    private val userList = listOf(
        UserModel.empty(),
        UserModel(id = 1, login = "alex", pairId = 1, iconId = 0, iconColorId = 1),
        UserModel(id = 2, login = "victoria", pairId = 1, iconId = 2, iconColorId = 0),
        UserModel(id = 3, login = "vasya", pairId = null, iconId = 2, iconColorId = 0),
        UserModel(id = 4, login = "lina", pairId = null, iconId = 2, iconColorId = 0),
    )

    fun getUserById(id: Int): UserModel {
        return userList.first { it.id == id }
    }

    fun getUserIcon(userId: Int): ImageVector {
        val user = getUserById(userId)
        return iconRepo.getIcon(user.iconId)
    }

    fun getUserIconColor(userId: Int): Color {
        val user = getUserById(userId)
        return colorRepo.getColor(user.iconColorId)
    }

    fun setUserIcon(userId: Int, iconId: Int) {
        val user = getUserById(userId)
        user.iconId = iconId
    }

    fun setUserIconColor(userId: Int, colorId: Int) {
        val user = getUserById(userId)
        user.iconColorId = colorId
    }

    fun setPairId(userId: Int, pairId: Int?) {
        val user = getUserById(userId)
        user.pairId = pairId
    }
}