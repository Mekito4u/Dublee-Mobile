package com.dublee.app.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dublee.app.domain.models.OptionModel
import com.dublee.app.domain.providers.ActivityManager
import com.dublee.app.domain.providers.ActivityProviderImpl
import com.dublee.app.domain.providers.CategoryProvider
import com.dublee.app.domain.providers.ContentProviderImpl
import com.dublee.app.domain.providers.OptionProvider
import com.dublee.app.domain.providers.Session
import com.dublee.app.domain.providers.UserProviderImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SwipeViewModel(
    private val categoryId: Int,
    contentProviderImpl: ContentProviderImpl,
    activityProviderImpl: ActivityProviderImpl,
    userProviderImpl: UserProviderImpl
) : ViewModel(),
    CategoryProvider by contentProviderImpl,
    OptionProvider by contentProviderImpl,
    ActivityManager by activityProviderImpl,
    Session by userProviderImpl {
    private val _options = MutableStateFlow(emptyList<OptionModel>())
    val options = _options.asStateFlow()

    private val _option = MutableStateFlow(OptionModel.empty())
    val option = _option.asStateFlow()

    private val _currentIndex = MutableStateFlow(0)
    val currentIndex = _currentIndex.asStateFlow()

    init {
        _options.value = getOptionsByCategory(categoryId)
        setCurrentOption(_currentIndex.value)
    }

    fun setCurrentOption(index: Int) {
        _option.value = _options.value[index]
    }

    fun nextOption() {
        if (_currentIndex.value + 1 < _options.value.size) {
            _currentIndex.value += 1
            setCurrentOption(_currentIndex.value)
        } else {
            _currentIndex.value = -1
        }
    }

    fun likeOption(optionId: Int) {
        viewModelScope.launch {
            addLike(optionId)
        }
        nextOption()
    }

    fun dislikeOption(id: Int) {
        nextOption()
    }
}