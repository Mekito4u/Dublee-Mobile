package com.dublee.app.ui.views.utils.widgets

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dublee.app.ui.views.utils.theme.MyBrown
import com.dublee.app.ui.views.utils.theme.MyCream
import com.dublee.app.ui.views.utils.theme.MyText

@Preview
@Composable
fun InfoWidget(
    modifier: Modifier = Modifier,
    iconSize: Dp = 36.dp,
    iconAlign: Alignment.Horizontal = Alignment.Start,
    title: String = "title",
    description: String = "description",
    icon: ImageVector = Icons.Default.Home,
    onClicked: () -> Unit = {}
) {
    Surface(
        shape = shapes.large,
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 24.dp,
                end = 24.dp,
            )
            .border(
                width = 1.dp,
                color = MyBrown,
                shape = shapes.large
            ),
        color = MyCream,
        onClick = onClicked
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
        ) {
            Icon(
                modifier = Modifier
                    .size(iconSize)
                    .align(iconAlign),
                imageVector = icon,
                tint = Color.Black,
                contentDescription = "icon",
            )
            MyText(
                text = title,
                modifier =Modifier.fillMaxWidth(),
            )
            MyText(
                text = description,
                style = typography.headlineSmall,
                textAlign = TextAlign.Start
            )
        }
    }
}