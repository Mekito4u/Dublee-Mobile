package com.dublee.app.domain.mapper

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BreakfastDining
import androidx.compose.material.icons.filled.Cake
import androidx.compose.material.icons.filled.Dining
import androidx.compose.material.icons.filled.DinnerDining
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.LocalPizza
import androidx.compose.material.icons.filled.LunchDining
import androidx.compose.material.icons.filled.RamenDining
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material.icons.filled.SetMeal
import androidx.compose.material.icons.filled.SoupKitchen
import androidx.compose.ui.graphics.vector.ImageVector

enum class OptionIcon(val icon: ImageVector) {
    Pizza(Icons.Default.LocalPizza),           // Пицца
    Dining(Icons.Default.Dining),               // Суши
    RestaurantMenu(Icons.Default.RestaurantMenu), // Бургер
    SetMeal(Icons.Default.SetMeal),             // Паста
    LunchDining(Icons.Default.LunchDining),     // Салат
    SoupKitchen(Icons.Default.SoupKitchen),     // Суп
    DinnerDining(Icons.Default.DinnerDining),   // Стейк
    RamenDining(Icons.Default.RamenDining),     // Рыба
    BreakfastDining(Icons.Default.BreakfastDining), // Завтрак
    Cake(Icons.Default.Cake)                    // Десерт
}

object OptionIconMapper {
    fun getIcon(iconId: Int): ImageVector {
        return OptionIcon.entries.find { it.ordinal == iconId }?.icon ?: Icons.Default.Fastfood
    }
}