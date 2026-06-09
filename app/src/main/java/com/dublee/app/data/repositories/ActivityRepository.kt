package com.dublee.app.data.repositories

import com.dublee.app.data.remote.dto.LikeRequest
import com.dublee.app.data.remote.dto.LikeResponse
import com.dublee.app.data.remote.dto.MatchResponse
import com.dublee.app.data.remote.services.ActivityApiService
import com.dublee.app.domain.models.LikeModel
import com.dublee.app.domain.models.MatchModel
import kotlin.collections.map

class ActivityRepository(
    val activityApiService: ActivityApiService,
    val tokenRepository: TokenRepository
) {
    suspend fun getLikes(): List<LikeModel> {
        val token = tokenRepository.getToken() ?: return emptyList()
        return try {
            val response = activityApiService.getLikes(token)
            val list = response.map {
                it.toLikeModel()
            }
            println("=== $list")
            return list
        } catch (e: Exception) {
            println("Get likes failed: ${e.message}")
            emptyList()
        }
    }

    suspend fun getMatches(): List<MatchModel> {
        val token = tokenRepository.getToken() ?: return emptyList()
        return try {
            val response = activityApiService.getMatches(token)
            response.map { it.toMatchModel() }
        } catch (e: Exception) {
            println("Get matches failed: ${e.message}")
            emptyList()
        }
    }

    suspend fun deleteLike(id: Int): Boolean {
        try {
            val token = tokenRepository.getToken() ?: return false
            val response = activityApiService.deleteLike(token, id)
            return response
        } catch (e: Exception) {
            println("Like delete failed: ${e.message}")
            return false
        }
    }

    suspend fun addLike(optionId: Int): Boolean {
        try {
            val token = tokenRepository.getToken() ?: return false
            val response = activityApiService.addLike(token, LikeRequest(optionId))
            return response
        } catch (e: Exception) {
            println("Update user failed: ${e.message}")
            return false
        }
    }

    fun LikeResponse.toLikeModel() = LikeModel(
        id = id,
        optionId = optionId,
        categoryId = optionId / 100,
        createdAt = createdAt
    )

    fun MatchResponse.toMatchModel() = MatchModel(
        id = id,
        optionId = optionId,
        categoryId = optionId / 100,
        createdAt = matchedAt
    )
}