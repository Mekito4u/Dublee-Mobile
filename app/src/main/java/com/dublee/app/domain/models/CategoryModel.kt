package com.dublee.app.domain.models

data class CategoryModel(
    val id: Int,
    val title: String,
    val description: String,
    val iconId: Int,
) {
    companion object {
        fun empty() =
            CategoryModel(id = 0, title = "title", description = "description", iconId = 0)
    }
}