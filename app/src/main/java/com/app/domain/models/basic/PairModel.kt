package com.app.domain.models.basic

data class PairModel(
    val id: Int,
    val user1Id: Int,
    val user2Id: Int? = null,
)