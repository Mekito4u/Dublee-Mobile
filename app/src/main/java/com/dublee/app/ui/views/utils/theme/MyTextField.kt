package com.dublee.app.ui.views.utils.theme

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun MyTextField(
    value: String,
    onValueChange: (String) -> Unit,
    backgroundColor: Color = Color.Transparent,
    modifier: Modifier = Modifier,
    height: Dp = 96.dp,
    width: Dp = 280.dp,
    prefix: String
) {
    TextField(
        shape = shapes.large,
        modifier = modifier
            .height(height)
            .width(width),
        value = value,
        onValueChange = onValueChange,
        label = {
            MyText(
                text = prefix,
                style = typography.headlineSmall
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = backgroundColor,
            unfocusedContainerColor = backgroundColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent
        ),
        textStyle = typography.titleLarge.copy(
            color = Color.Black
        )
    )
}