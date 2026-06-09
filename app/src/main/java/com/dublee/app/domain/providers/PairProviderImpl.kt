package com.dublee.app.domain.providers

import com.dublee.app.data.repositories.PairRepository

interface PairManager {
    suspend fun joinPair(inviteCode: String): Boolean
    suspend fun leavePair(): Boolean
    suspend fun createPair(): Pair<Boolean, String?>
    suspend fun getCode(): Pair<Boolean, String?>
}


class PairProviderImpl(
    val pairRepository: PairRepository,
) : PairManager {
    override suspend fun joinPair(inviteCode: String): Boolean {
        return pairRepository.joinPair(inviteCode)
    }

    override suspend fun leavePair(): Boolean {
        return pairRepository.leavePair()
    }

    override suspend fun createPair(): Pair<Boolean, String?> {
        return pairRepository.createPair()
    }

    override suspend fun getCode(): Pair<Boolean, String?> {
        return pairRepository.getCode()
    }
}