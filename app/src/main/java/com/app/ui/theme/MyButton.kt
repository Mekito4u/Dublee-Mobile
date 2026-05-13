package com.app.ui.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Text
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
    backgroundColor: Color = MyBeige,
    text: String = "-",
    style: TextStyle = MaterialTheme.typography.titleLarge,
    content: @Composable RowScope.() -> Unit = {
        Text(
            text,
            style = style,
            textAlign = TextAlign.Center
        )
    },
    contentPadding: PaddingValues = PaddingValues(4.dp),
) {
    Button(
        shape = shapes.large,
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        ),
        content = content,
        contentPadding = contentPadding,
    )
}
