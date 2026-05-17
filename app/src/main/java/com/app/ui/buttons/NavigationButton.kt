package com.app.ui.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.ui.theme.MyBeige
import com.app.ui.theme.MyBrown
import com.app.ui.theme.MyButton
import com.app.ui.theme.MyCream

@Preview
@Composable
fun NavigationButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    icon: ImageVector = Icons.Default.Home,
    text: String? = "Главная",
    isSelected: Boolean = false,
    backgroundColor: Color = MyBeige,
    shape: CornerBasedShape = shapes.large
) {
    val color = if (isSelected) {
        MyCream
    } else {
        MyBrown
    }

    MyButton(
        modifier = modifier.fillMaxSize(),
        onClick = onClick,
        shape = shape,
        isBordered = false,
        content = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier,
                    imageVector = icon,
                    contentDescription = "",
                    tint = color,
                )
                if (text != null) {
                    Text(
                        modifier = Modifier,
                        textAlign = TextAlign.Center,
                        text = text,
                        style = typography.titleSmall,
                        color = color
                    )
                }
            }
        },
        contentPadding = PaddingValues(4.dp),
        backgroundColor = backgroundColor
    )
}