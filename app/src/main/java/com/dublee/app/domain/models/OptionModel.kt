package com.dublee.app.domain.models

data class OptionModel(
    val id: Int,
    val categoryId: Int,
    val iconId: Int,
    val title: String,
    val description: String,
) {
    companion object {
        fun empty() = OptionModel(-1, 0, 0, "title", "description")
    }
}
