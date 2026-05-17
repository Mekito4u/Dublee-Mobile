package com.app.ui.viewmodel.basic

import androidx.lifecycle.ViewModel
import com.app.data.repositories.basic.CategoryRepository
import com.app.domain.models.basic.CategoryModel
import com.app.domain.usecases.PartnerSession
import com.app.domain.usecases.UserSession
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel() : ViewModel() {
    private val repository = CategoryRepository()

    private val _categoryList = MutableStateFlow(emptyList<CategoryModel>())
    val categoryList = _categoryList.asStateFlow()

    private val userSession = UserSession()
    private val pairSession = PartnerSession()

    val user = userSession.user
    val icon = userSession.icon
    val iconColor = userSession.iconColor

    val partner = pairSession.partner
    val partnerIcon = pairSession.icon
    val partnerColor = pairSession.iconColor

    init {
        loadData()
        updateCategory()
    }

    fun loadData() {
        userSession.loadUser(1)
        pairSession.loadPartner(1)
    }

    fun updateCategory() {
        _categoryList.value = repository.getCategories()
    }
}