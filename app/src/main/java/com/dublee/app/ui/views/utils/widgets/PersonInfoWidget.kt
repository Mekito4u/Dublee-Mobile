package com.dublee.app.ui.views.utils.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dublee.app.ui.views.utils.theme.MyGreen
import com.dublee.app.ui.views.utils.theme.MyText

@Preview
@Composable
fun PersonInfoWidget(
    modifier: Modifier = Modifier,
    text: String = "login",
    icon: ImageVector = Icons.Default.Person,
    color: Color = MyGreen,
    height: Dp = 136.dp,
    width: Dp = 104.dp
) {
    Column(
        modifier = modifier
            .height(height)
            .width(width),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier
                .width(width-8.dp)
                .aspectRatio(1f),
            imageVector = icon,
            contentDescription = "icon",
            tint = color,
        )
        MyText(
            text = text,
        )
    }
}