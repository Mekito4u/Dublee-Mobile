package com.dublee.app.data.repositories

import com.dublee.app.domain.models.OptionModel

open class OptionRepository {
    private val optionsMap = mapOf(
        1 to listOf( // Еда
            OptionModel(100, 1, 100, "Пицца", "Итальянская классика с хрустящей корочкой"),
            OptionModel(101, 1, 101, "Суши", "Свежие роллы и сашими"),
            OptionModel(102, 1, 102, "Бургер", "Сочная котлета с овощами"),
            OptionModel(103, 1, 103, "Паста", "Итальянская паста с разными соусами"),
            OptionModel(104, 1, 104, "Суп", "Горячий, сытный, с душой")
        ),
        2 to listOf( // Фильм
            OptionModel(200, 2, 200, "Дюна 2", "Эпическая фантастика о пустынной планете"),
            OptionModel(201, 2, 201, "Оппенгеймер", "История создателя атомной бомбы")
        ),
        3 to listOf( // Игра
            OptionModel(300, 3, 300, "Монополия", "Классическая настольная игра про бизнес"),
            OptionModel(301, 3, 301, "UNO", "Быстрая карточная игра для компании")
        ),
        4 to listOf( // Погулять
            OptionModel(400, 4, 400, "Парк", "Прогулка на свежем воздухе среди деревьев"),
            OptionModel(401, 4, 401, "Музей", "Погружение в искусство и историю")
        ),
        5 to listOf( // Досуг
            OptionModel(500, 5, 500, "Книга", "Чтение уютным вечером вдвоём"),
            OptionModel(501, 5, 501, "Музыка", "Совместное прослушивание плейлиста")
        )
    )

    fun getOptionsSize(): Int {
        return if (optionsMap.isEmpty()) -1 else this.optionsMap.size
    }

    fun getOptionsByCategory(categoryId: Int): List<OptionModel> {
        return optionsMap[categoryId] ?: emptyList()
    }

    fun getOptionById(optionId: Int): OptionModel? {
        return optionsMap.values.flatten().firstOrNull { it.id == optionId }
    }
}