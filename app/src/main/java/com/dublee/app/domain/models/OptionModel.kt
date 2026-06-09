package com.dublee.app.domain.models

data class OptionModel(
    val id: Int,
    val categoryId: Int,
    val iconId: Int = id,
    val title: String,
    val description: String,
) {
    companion object {
        fun empty() = OptionModel(-1, -1, -1, "title", "description")
    }
}
