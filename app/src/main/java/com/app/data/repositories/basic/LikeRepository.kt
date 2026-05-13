package com.app.data.repositories.basic

import com.app.domain.models.basic.LikeModel

class LikeRepository {
    private var _likes = mutableListOf(
        LikeModel(
            id = 1,
            userId = 1,
            categoryId = 1,
            optionId = 1,
            pairId = 1,
            timestamp = 1746280000000
        ),
        LikeModel(
            id = 2,
            userId = 1,
            categoryId = 1,
            optionId = 3,
            pairId = 1,
            timestamp = 1746283600000
        ),
        LikeModel(
            id = 3,
            userId = 1,
            categoryId = 1,
            optionId = 5,
            pairId = 1,
            timestamp = 1746287200000
        )
    )

    fun getLikes(): List<LikeModel> = _likes

    fun deleteLike(id: Int) {
        _likes.removeAll { it.id == id }
    }
}