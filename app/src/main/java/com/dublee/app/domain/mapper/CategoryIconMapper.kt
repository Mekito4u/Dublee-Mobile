package com.dublee.app.domain.mapper

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Games
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Weekend
import androidx.compose.ui.graphics.vector.ImageVector

enum class CategoryIcon(val icon: ImageVector) {
    Eat(Icons.Default.Fastfood),
    Movie(Icons.Default.Movie),
    Game(Icons.Default.Games),
    Explore(Icons.Default.Explore),
    Weekend(Icons.Default.Weekend),
}

object CategoryIconMapper {
    fun getIcon(iconId: Int): ImageVector {
        return CategoryIcon.entries.find { it.ordinal == iconId }?.icon ?: Icons.Default.Fastfood
    }
}