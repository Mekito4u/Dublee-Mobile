package com.dublee.app.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val id: Int,
    val login: String,
    val pairId: Int?,
    val iconId: Int,
    val colorId: Int
)