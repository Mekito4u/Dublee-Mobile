package com.dublee.app.ui.views.utils.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MyIconButton(
    icon: ImageVector = Icons.Default.Person,
    text: String = "text",
    onClick: () -> Unit = {},
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier,
            imageVector = icon,
            contentDescription = "icon",
            tint = Color.Black
        )
        MyButton(
            modifier = Modifier,
            height = 52.dp,
            text = text,
            textAlign = TextAlign.Start,
            style = typography.titleLarge,
            backgroundColor = MyCream,
            isBordered = false,
            onClick = onClick
        )
    }
}