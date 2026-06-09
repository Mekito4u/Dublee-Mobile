package com.dublee.app.data.repositories

import com.dublee.app.data.remote.dto.JoinPairRequest
import com.dublee.app.data.remote.services.PairApiService

class PairRepository(
    val pairApiService: PairApiService,
    val userRepository: UserRepository,
) {
    suspend fun joinPair(inviteCode: String): Boolean {
        return try {
            val token = userRepository.getToken() ?: return false
            val response = pairApiService.joinPair(token, JoinPairRequest(inviteCode))
            if (response.status == "joined") {
                userRepository.getMe()
                true
            } else {
                false
            }
        } catch (e: Exception) {
            println("=== Error joining pair: ${e.message}")
            false
        }
    }

    suspend fun leavePair(): Boolean {
        return try {
            val token = userRepository.getToken() ?: return false
            val response = pairApiService.leavePair(token)
            if (response.status == "left") {
                userRepository.getMe()
                true
            } else {
                false
            }
        } catch (e: Exception) {
            println("=== Error leaving pair: ${e.message}")
            false
        }
    }

    suspend fun createPair(): Pair<Boolean, String?> {
        return try {
            val token = userRepository.getToken() ?: return Pair(false, null)
            val response = pairApiService.createPair(token)
            if (response.id > 0) {
                userRepository.getMe()
                Pair(true, response.inviteCode)
            } else {
                Pair(false, null)
            }
        } catch (e: Exception) {
            println("Create pair error: ${e.message}")
            Pair(false, null)
        }
    }

    suspend fun getCode(): Pair<Boolean, String?> {
        return try {
            val token = userRepository.getToken() ?: return Pair(false, null)
            val response = pairApiService.getCode(token)
            if (response != null) {
                Pair(true, response)
            } else {
                Pair(true, null)
            }
        } catch (e: Exception) {
            println("Get code error: ${e.message}")
            Pair(false, null)
        }
    }
}