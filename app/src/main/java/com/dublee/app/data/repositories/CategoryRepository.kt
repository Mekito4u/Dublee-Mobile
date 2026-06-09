package com.dublee.app.data.repositories

import com.dublee.app.domain.models.CategoryModel

open class CategoryRepository {
    private val categoryList = listOf(
        CategoryModel(
            1,
            "Еда",
            "Выбирайте блюдо на ужин: от пиццы до суши",
            0
        ),
        CategoryModel(
            2,
            "Фильм",
            "Найдите фильм, который хотите смотреть оба",
            1
        ),
        CategoryModel(
            3,
            "Игра",
            "Настолки, видеоигры - выбирайте досуг для двоих",
            2
        ),
        CategoryModel(
            4,
            "Погулять",
            "Парк, кафе или музей - решите вместе",
            3
        ),
        CategoryModel(
            5,
            "Досуг",
            "Всё для отдыха: книги, музыка, хобби",
            4
        )
    )

    fun getCategories(): List<CategoryModel> = categoryList

    fun getCategoryById(id: Int): CategoryModel? {
        return categoryList.firstOrNull { it.id == id }
    }
}