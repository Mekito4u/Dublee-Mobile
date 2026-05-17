package com.app.ui.widgets

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.ui.theme.MyBrown
import com.app.ui.theme.MyCream
import com.app.ui.theme.MyText

@Preview
@Composable
fun CategoryWidget(
    title: String = "title",
    description: String = "description",
    icon: ImageVector = Icons.Default.Home,
    onClicked: () -> Unit = {}
) {
    Surface(
        shape = shapes.large,
        modifier = Modifier
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
            verticalArrangement = Arrangement.Top,
        ) {
            Icon(
                modifier = Modifier.size(36.dp),
                imageVector = icon,
                contentDescription = "",
            )
            MyText(
                Modifier.fillMaxWidth(),
                text = title,
            )
            MyText(
                text = description,
                style = typography.headlineSmall
            )
        }
    }
}