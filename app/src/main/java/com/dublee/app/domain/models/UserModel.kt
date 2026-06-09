package com.dublee.app.domain.models


data class UserModel(
    val id: Int,
    val login: String,
    var pairId: Int? = null,
    var iconId: Int = 0,
    var colorId: Int = 0
) {
    companion object {
        fun empty() = UserModel(id = -1, login = "login", pairId = null, iconId = 0, colorId = 0)
        fun emptyPair() = Pair(
            UserModel(id = -1, login = "user", pairId = 2, iconId = 1, colorId = 0),
            UserModel(id = -2, login = "partner", pairId = 1, iconId = 2, colorId = 1)
        )
    }
}