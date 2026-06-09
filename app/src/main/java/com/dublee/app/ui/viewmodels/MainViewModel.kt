package com.dublee.app.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dublee.app.domain.models.CategoryModel
import com.dublee.app.domain.providers.CategoryProvider
import com.dublee.app.domain.providers.ContentProviderImpl
import com.dublee.app.domain.providers.Session
import com.dublee.app.domain.providers.UserFcmToken
import com.dublee.app.domain.providers.UserIconProvider
import com.dublee.app.domain.providers.UserProviderImpl
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class MainViewModel(
    userProviderImpl: UserProviderImpl,
    categoryProviderImpl: ContentProviderImpl
) : ViewModel(),
    Session by userProviderImpl,
    UserIconProvider by userProviderImpl,
    CategoryProvider by categoryProviderImpl,
    UserFcmToken by userProviderImpl {
    private val _categoryList = MutableStateFlow(emptyList<CategoryModel>())
    val categoryList = _categoryList.asStateFlow()

    init {
        _categoryList.value = getAllCategories()
    }

    fun registerFcmToken() {
        viewModelScope.launch {
            val token = FirebaseMessaging.getInstance().token.await()
            sendFcmToken(token)
        }
    }
}