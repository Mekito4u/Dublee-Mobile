package com.app.ui.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.app.ui.theme.MyGreen
import com.app.ui.theme.MyText

@Composable
fun PersonInfoWidget(
    modifier: Modifier = Modifier,
    text: String = "login",
    icon: ImageVector = Icons.Default.Person,
    color: Color = MyGreen
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier
                .width(128.dp)
                .aspectRatio(1f),
            imageVector = icon,
            contentDescription = "icon",
            tint = color,
        )
        MyText(
            modifier = Modifier,
            text = text,
        )
    }
}