package com.app.data.repositories.basic

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Games
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Weekend
import com.app.domain.models.basic.CategoryModel

class CategoryRepository {
    private val categoryList = listOf(
        CategoryModel(
            0,
            "Еда",
            "Выбирайте блюдо на ужин: от пиццы до суши",
            Icons.Default.Fastfood
        ),
        CategoryModel(
            1,
            "Фильм",
            "Найдите фильм, который хотите смотреть оба",
            Icons.Default.Movie
        ),
        CategoryModel(
            2,
            "Игра",
            "Настолки, видеоигры - выбирайте досуг для двоих",
            Icons.Default.Games
        ),
        CategoryModel(
            3,
            "Погулять",
            "Парк, кафе или музей - решите вместе",
            Icons.Default.Explore
        ),
        CategoryModel(
            4,
            "Досуг",
            "Всё для отдыха: книги, музыка, хобби",
            Icons.Default.Weekend
        )
    )

    fun getCategories(): List<CategoryModel> = categoryList

    fun getCategoryById(id: Int): CategoryModel? {
        return categoryList.find { it.id == id }
    }
}