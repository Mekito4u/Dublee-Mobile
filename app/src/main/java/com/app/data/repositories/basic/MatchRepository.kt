package com.app.data.repositories.basic

import com.app.domain.models.basic.MatchModel

class MatchRepository {
    private val matches = listOf(
        MatchModel(id = 1, categoryId = 1, optionId = 1, pairId = 1, timestamp = 1746287200000)
    )

    fun getMatches(): List<MatchModel> {
        return this.matches
    }
}