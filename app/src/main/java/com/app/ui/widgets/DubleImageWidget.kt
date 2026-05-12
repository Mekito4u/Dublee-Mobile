package com.app.ui.widgets

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.ui.theme.MyPink


@Preview
@Composable
fun DubleeIconWidget() {
    Icon(
        modifier = Modifier
            .size(256.dp),
        imageVector = Icons.Default.Favorite,
        contentDescription = "Dublee",
        tint = MyPink,
    )
}