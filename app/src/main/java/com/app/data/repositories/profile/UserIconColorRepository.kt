package com.app.data.repositories.profile

import androidx.compose.ui.graphics.Color
import com.app.ui.theme.MyBlue
import com.app.ui.theme.MyBrown
import com.app.ui.theme.MyGreen
import com.app.ui.theme.MyPurple
import com.app.ui.theme.MyRed
import com.app.ui.theme.MyYellow

enum class IconColor(val color: Color) {
    Brown(MyBrown),
    Red(MyRed),
    Green(MyGreen),
    Yellow(MyYellow),
    Blue(MyBlue),
    Purple(MyPurple)
}

class UserIconColorRepository {
    init {
        println("=== icon_color_repository")
    }
    fun getColor(colorId: Int): Color {
        return IconColor.entries.find { it.ordinal == colorId }?.color ?: Color(0xFFFF6B6B)
    }
}