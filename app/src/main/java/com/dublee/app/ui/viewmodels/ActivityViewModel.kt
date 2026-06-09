package com.dublee.app.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dublee.app.domain.models.LikeModel
import com.dublee.app.domain.models.MatchModel
import com.dublee.app.domain.providers.ActivityData
import com.dublee.app.domain.providers.ActivityManager
import com.dublee.app.domain.providers.ActivityProviderImpl
import com.dublee.app.domain.providers.CategoryProvider
import com.dublee.app.domain.providers.ContentProviderImpl
import com.dublee.app.domain.providers.OptionProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ActivityViewModel(
    contentProviderImpl: ContentProviderImpl,
    activityProviderImpl: ActivityProviderImpl,
) : ViewModel(),
    ActivityData by activityProviderImpl,
    ActivityManager by activityProviderImpl,
    CategoryProvider by contentProviderImpl,
    OptionProvider by contentProviderImpl {

    private val _dataList = MutableStateFlow(emptyList<Any>())
    val dataList = _dataList.asStateFlow()

    private val _likeList = MutableStateFlow(emptyList<LikeModel>())
    private val _matchList = MutableStateFlow(emptyList<MatchModel>())


    init {
        viewModelScope.launch {
            updateData()
        }
    }

    private fun combineLists() = (_likeList.value + _matchList.value)
        .sortedByDescending {
            when (it) {
                is LikeModel -> it.createdAt
                is MatchModel -> it.createdAt
            }
        }

    suspend fun updateData() {
        _likeList.value = getLikes()
        _matchList.value = getMatches()
        _dataList.value = combineLists()
    }
}