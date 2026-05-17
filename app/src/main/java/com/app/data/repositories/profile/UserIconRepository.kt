package com.app.data.repositories.profile

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AssignmentInd
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.EmojiEmotions
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.PermIdentity
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Tag
import androidx.compose.ui.graphics.vector.ImageVector

enum class UserIcon(val icon: ImageVector) {
    Person(Icons.Default.Person),
    AccountCircle(Icons.Default.AccountCircle),
    Face(Icons.Default.Face),
    EmojiEmotions(Icons.Default.EmojiEmotions),
    Tag(Icons.Default.Tag),
    PermIdentity(Icons.Default.PermIdentity),
    AssignmentInd(Icons.Default.AssignmentInd),
    Badge(Icons.Default.Badge),
}

class UserIconRepository {
    init {
        println("=== icon_repository")
    }
    fun getIcon(iconId: Int): ImageVector {
        return UserIcon.entries.find { it.ordinal == iconId }?.icon ?: Icons.Filled.Person
    }
}