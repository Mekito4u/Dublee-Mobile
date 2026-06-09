package com.dublee.app.data.repositories

import com.dublee.app.domain.models.OptionModel

open class OptionRepository {
    private val optionsMap = mapOf(
        1 to listOf(
            OptionModel(
                id = 100,
                categoryId = 0,
                iconId = 0,
                title = "Пицца",
                description = "Итальянская классика с хрустящей корочкой"
            ),
            OptionModel(
                id = 101,
                categoryId = 0,
                iconId = 1,
                title = "Суши",
                description = "Свежие роллы и сашими"
            ),
            OptionModel(
                id = 102,
                categoryId = 0,
                iconId = 2,
                title = "Бургер",
                description = "Сочная котлета с овощами"
            ),
            OptionModel(
                id = 103,
                categoryId = 0,
                iconId = 3,
                title = "Паста",
                description = "Итальянская паста с разными соусами"
            ),
            OptionModel(
                id = 104,
                categoryId = 0,
                iconId = 4,
                title = "Рыба",
                description = "Запечённая рыба с овощами"
            ),
            OptionModel(
                id = 105,
                categoryId = 0,
                iconId = 5,
                title = "Стейк",
                description = "Мраморная говядина на гриле"
            ),
        )
    )

    fun getOptionsByCategory(categoryId: Int): List<OptionModel> {
        return optionsMap[categoryId] ?: emptyList()
    }

    fun getOptionById(optionId: Int): OptionModel? {
        return optionsMap.values.flatten().firstOrNull { it.id == optionId }
    }
}