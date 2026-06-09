package com.dublee.app.domain.providers

import com.dublee.app.data.repositories.ActivityRepository
import com.dublee.app.domain.models.LikeModel
import com.dublee.app.domain.models.MatchModel


interface ActivityData {
    suspend fun getLikes(): List<LikeModel>
    suspend fun getMatches(): List<MatchModel>

}

interface ActivityManager {
    suspend fun addLike(optionId: Int)
    suspend fun deleteLike(id: Int)
}

class ActivityProviderImpl(
    val activityRepository: ActivityRepository,
) : ActivityData, ActivityManager {
    override suspend fun getLikes(): List<LikeModel>{
        return activityRepository.getLikes()
    }
    override suspend fun getMatches(): List<MatchModel>{
        return activityRepository.getMatches()
    }
    override suspend fun addLike(optionId: Int) {
        activityRepository.addLike(optionId)
    }


    override suspend fun deleteLike(id: Int) {
        activityRepository.deleteLike(id)
    }
}