package com.app.ui.viewmodel.basic

import androidx.lifecycle.ViewModel
import com.app.data.repositories.basic.CategoryRepository
import com.app.data.repositories.basic.LikeRepository
import com.app.data.repositories.basic.MatchRepository
import com.app.domain.models.basic.CategoryModel
import com.app.domain.models.basic.LikeModel
import com.app.domain.models.basic.MatchModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ActivityViewModel() : ViewModel() {
    val likeRepository = LikeRepository()
    val matchRepository = MatchRepository()
    val categoryRepository = CategoryRepository()

    private val _dataList = MutableStateFlow(emptyList<Any>())
    val dataList = _dataList.asStateFlow()

    private val _likeList = MutableStateFlow(emptyList<LikeModel>())
    val likeList = _likeList.asStateFlow()

    private val _matchList = MutableStateFlow(emptyList<MatchModel>())
    val matchList = _matchList.asStateFlow()

    init {
        updateData()
    }

    private fun combineLists() = (_likeList.value + _matchList.value)
        .sortedByDescending {
            when (it) {
                is LikeModel -> it.timestamp
                is MatchModel -> it.timestamp
            }
        }

    private fun updateData() {
        updateLikes()
        updateMatches()
        _dataList.value = combineLists()
    }

    private fun updateLikes() {
        _likeList.value = likeRepository.getLikes()
    }

    private fun updateMatches() {
        _matchList.value = matchRepository.getMatches()
    }

    fun deleteLike(id: Int) {
        likeRepository.deleteLike(id)
        _likeList.value = _likeList.value.filter { it.id != id }
        _dataList.value = combineLists()
    }

    fun getCategoryById(id: Int): CategoryModel? {
        return categoryRepository.getCategoryById(id)
    }
}