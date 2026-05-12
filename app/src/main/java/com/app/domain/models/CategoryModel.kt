package com.app.domain.models

import androidx.compose.ui.graphics.vector.ImageVector

data class CategoryModel(
    val id: Int,
    val title: String,
    val description: String,
    val icon: ImageVector,
)