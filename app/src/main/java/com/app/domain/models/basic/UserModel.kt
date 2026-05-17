package com.app.domain.models.basic


data class UserModel(
    val id: Int,
    val login: String,
    var pairId: Int? = null,
    var iconId: Int = 0,
    var iconColorId: Int = 0
) {
    companion object {
        fun empty() = UserModel(id = 0, login = "login", pairId = null, iconId = 0, iconColorId = 0)
    }
}