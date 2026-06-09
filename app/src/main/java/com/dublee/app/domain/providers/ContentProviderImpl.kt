package com.dublee.app.domain.providers

import androidx.compose.ui.graphics.vector.ImageVector
import com.dublee.app.data.repositories.CategoryRepository
import com.dublee.app.data.repositories.OptionRepository
import com.dublee.app.domain.mapper.CategoryIconMapper
import com.dublee.app.domain.mapper.OptionIconMapper
import com.dublee.app.domain.models.CategoryModel
import com.dublee.app.domain.models.OptionModel

interface CategoryProvider {
    fun getCategoryIcon(id: Int): ImageVector
    fun getCategory(id: Int): CategoryModel
    fun getAllCategories(): List<CategoryModel>
}

interface OptionProvider {
    fun getOptionsByCategory(id: Int): List<OptionModel>
    fun getOptionIcon(id: Int): ImageVector
    fun getOption(id: Int): OptionModel
    fun getOptionsSize(): Int
}


class ContentProviderImpl(
    val categoryRepository: CategoryRepository,
    val optionRepository: OptionRepository,
) : CategoryProvider, OptionProvider {
    override fun getCategoryIcon(id: Int) = CategoryIconMapper.getIcon(id)
    override fun getCategory(id: Int): CategoryModel {
        return categoryRepository.getCategoryById(id) ?: CategoryModel.empty()
    }

    override fun getAllCategories(): List<CategoryModel> {
        return categoryRepository.getCategories()
    }

    override fun getOptionsByCategory(id: Int): List<OptionModel> {
        return optionRepository.getOptionsByCategory(id)
    }

    override fun getOptionIcon(id: Int) = OptionIconMapper.getIcon(id)
    override fun getOption(id: Int): OptionModel {
        return optionRepository.getOptionById(id) ?: OptionModel.empty()
    }
    override fun getOptionsSize(): Int {
        return optionRepository.getOptionsSize()
    }
}