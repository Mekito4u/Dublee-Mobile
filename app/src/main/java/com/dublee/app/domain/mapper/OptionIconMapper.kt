package com.dublee.app.domain.mapper

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Casino
import androidx.compose.material.icons.filled.DinnerDining
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Games
import androidx.compose.material.icons.filled.LocalPizza
import androidx.compose.material.icons.filled.LunchDining
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.SetMeal
import androidx.compose.material.icons.filled.SoupKitchen
import androidx.compose.material.icons.filled.Theaters
import androidx.compose.material.icons.filled.Weekend
import androidx.compose.ui.graphics.vector.ImageVector

object OptionIconMapper {
    private val icons = mapOf(
        100 to Icons.Default.LocalPizza,
        101 to Icons.Default.SetMeal,
        102 to Icons.Default.LunchDining,
        103 to Icons.Default.DinnerDining,
        104 to Icons.Default.SoupKitchen,
        200 to Icons.Default.Movie,
        201 to Icons.Default.Theaters,
        300 to Icons.Default.Games,
        301 to Icons.Default.Casino,
        400 to Icons.Default.Explore,
        401 to Icons.Default.Weekend,
        500 to Icons.Default.Book,
        501 to Icons.Default.MusicNote
    )
    fun getIcon(iconId: Int): ImageVector = icons[iconId] ?: Icons.Default.Fastfood
}
