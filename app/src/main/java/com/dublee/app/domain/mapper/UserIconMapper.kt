package com.dublee.app.domain.mapper

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Face2
import androidx.compose.material.icons.filled.Face3
import androidx.compose.material.icons.filled.Face4
import androidx.compose.material.icons.filled.Face5
import androidx.compose.material.icons.filled.Face6
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

enum class UserIcon(val icon: ImageVector) {
    Person(Icons.Default.Person),
    Face1(Icons.Default.Face),
    Face2(Icons.Default.Face2),
    Face3(Icons.Default.Face3),
    Face4(Icons.Default.Face4),
    Face5(Icons.Default.Face5),
    Face6(Icons.Default.Face6),
}

object UserIconMapper {
    val size = UserIcon.entries.size

    fun getIcon(iconId: Int): ImageVector {
        return UserIcon.entries.find { it.ordinal == iconId }?.icon ?: Icons.Default.Person
    }
}