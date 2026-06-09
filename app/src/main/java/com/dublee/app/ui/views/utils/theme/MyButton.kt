package com.dublee.app.ui.views.utils.theme

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MyButton(
    modifier: Modifier = Modifier,
    height: Dp = 72.dp,
    width: Dp = 280.dp,
    onClick: () -> Unit = {},
    backgroundColor: Color = MyCream,
    text: String = "Button",
    style: TextStyle = typography.headlineLarge,
    contentPadding: PaddingValues = PaddingValues(4.dp),
    shape: CornerBasedShape = shapes.large,
    isBordered: Boolean = true,
    textAlign: TextAlign = TextAlign.Center,
    content: @Composable RowScope.() -> Unit = {
        MyText(
            modifier = Modifier.fillMaxWidth(),
            text = text,
            style = style,
            textAlign = textAlign,
            color = Color.Black
        )
    },
) {
    Button(
        shape = shape,
        modifier = modifier
            .width(width)
            .height(height)
            .let {
                if (isBordered) {
                    it.border(
                        1.dp,
                        MyBrown,
                        shapes.large
                    )
                } else it
            },
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        ),
        content = content,
        contentPadding = contentPadding,
    )
}
