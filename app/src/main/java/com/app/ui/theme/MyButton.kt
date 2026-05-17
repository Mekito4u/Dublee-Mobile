package com.app.ui.theme

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MyButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    backgroundColor: Color = MyCream,
    text: String = "Button",
    style: TextStyle = typography.headlineLarge,
    content: @Composable RowScope.() -> Unit = {
        MyText(
            text = text,
            style = style,
            textAlign = TextAlign.Center,
            color = Color.Black
        )
    },
    contentPadding: PaddingValues = PaddingValues(4.dp),
    shape: CornerBasedShape = shapes.large,
    isBordered: Boolean = true
) {
    Button(
        shape = shape,
        modifier = when (isBordered) {
            true -> modifier.border(
                width = 1.dp,
                color = MyBrown,
                shape = shapes.large
            )
            else -> modifier
        },
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        ),
        content = content,
        contentPadding = contentPadding,
    )
}
