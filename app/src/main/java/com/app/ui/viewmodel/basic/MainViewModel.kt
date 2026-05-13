package com.app.ui.viewmodel.basic

import androidx.lifecycle.ViewModel
import com.app.data.repositories.basic.CategoryRepository
import com.app.domain.models.basic.CategoryModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel() : ViewModel() {
    val repository = CategoryRepository()

    private val _categoryList = MutableStateFlow(emptyList<CategoryModel>())
    val categoryList = _categoryList.asStateFlow()

    init {
        updateCategory()
    }

    fun updateCategory() {
        _categoryList.value = repository.getCategories()
    }
}