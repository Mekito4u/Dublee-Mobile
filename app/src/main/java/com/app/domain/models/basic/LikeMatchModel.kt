package com.app.domain.models.basic

sealed interface TimestampInterface {
    val id: Int
    val categoryId: Int
    val optionId: Int
    val pairId: Int
    val timestamp: Long
}

data class LikeModel(
    override val id: Int,
    val userId: Int,
    override val categoryId: Int,
    override val optionId: Int,
    override val pairId: Int,
    override val timestamp: Long = System.currentTimeMillis(),
) : TimestampInterface

data class MatchModel(
    override val id: Int,
    override val categoryId: Int,
    override val optionId: Int,
    override val pairId: Int,
    override val timestamp: Long = System.currentTimeMillis(),
) : TimestampInterface