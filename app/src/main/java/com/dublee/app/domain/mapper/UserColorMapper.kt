package com.dublee.app.domain.mapper

import androidx.compose.ui.graphics.Color
import com.dublee.app.ui.views.utils.theme.MyBlue
import com.dublee.app.ui.views.utils.theme.MyGreen
import com.dublee.app.ui.views.utils.theme.MyPink
import com.dublee.app.ui.views.utils.theme.MyRed
import com.dublee.app.ui.views.utils.theme.MyYellow

enum class ColorIcon(val color: Color) {
    Blue(MyBlue),
    Pink(MyPink),
    Red(MyRed),
    Green(MyGreen),
    Yellow(MyYellow),
}

object UserColorMapper {
    fun getColor(colorId: Int): Color {
        return ColorIcon.entries.find { it.ordinal == colorId }?.color ?: Color(0xFFFF6B6B)
    }
}