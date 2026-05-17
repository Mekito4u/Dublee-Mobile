package com.app.data.repositories

import com.app.domain.models.basic.PairModel

class PairRepository {
    private val pairs = mutableListOf(
        PairModel(1, 1, 2),
    )

    fun getPairByUserId(userId: Int): PairModel? {
        return pairs.find { it.user1Id == userId || it.user2Id == userId }
    }

    fun getPartnerId(userId: Int): Int? {
        val pair = getPairByUserId(userId) ?: return null
        return if (pair.user1Id == userId) pair.user2Id else pair.user1Id
    }
}