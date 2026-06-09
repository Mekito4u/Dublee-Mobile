package com.dublee.app.domain.models

data class PairModel(
    val id: Int,
    val user1Id: Int,
    val user2Id: Int? = null,
)