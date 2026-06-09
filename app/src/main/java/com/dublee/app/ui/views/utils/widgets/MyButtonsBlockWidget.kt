package com.dublee.app.ui.views.utils.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dublee.app.ui.views.utils.theme.MyCream
import com.dublee.app.ui.views.utils.theme.MyIconButton
import com.dublee.app.ui.views.utils.theme.MyText

data class ButtonItem(
    val text: String,
    val icon: ImageVector,
    val onClick: () -> Unit
)

@Preview
@Composable
fun MyButtonsBlockWidget(
    title: String = "title",
    buttons: List<ButtonItem> = listOf(
        ButtonItem(
            text = "item",
            icon = Icons.Default.Person,
            onClick = {}
        )
    )
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp)
            .clip(shapes.large)
            .background(MyCream)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        MyText(
            text = title
        )

        Spacer(modifier = Modifier.height(8.dp))

        buttons.forEach { button ->
            MyIconButton(
                text = button.text,
                icon = button.icon,
                onClick = button.onClick
            )
        }
    }
}