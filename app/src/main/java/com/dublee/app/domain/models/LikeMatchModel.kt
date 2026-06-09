package com.dublee.app.domain.models

sealed interface TimestampInterface {
    val id: Int
    val categoryId: Int
    val optionId: Int
    val createdAt: Long
}

data class LikeModel(
    override val id: Int = -1,
    override val categoryId: Int,
    override val optionId: Int,
    override val createdAt: Long = System.currentTimeMillis(),
) : TimestampInterface

data class MatchModel(
    override val id: Int = -1,
    override val categoryId: Int,
    override val optionId: Int,
    override val createdAt: Long = System.currentTimeMillis(),
) : TimestampInterface