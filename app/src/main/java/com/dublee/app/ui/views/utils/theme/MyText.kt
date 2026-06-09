package com.dublee.app.ui.views.utils.theme

import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MyText(
    text: String = "Hello",
    modifier: Modifier = Modifier,
    style: TextStyle = typography.headlineMedium,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = Color.Black
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textAlign = textAlign,
        style = style
    )
}