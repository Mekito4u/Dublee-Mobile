package com.app.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun MyButton(
    modifier: Modifier,
    onClick: () -> Unit,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    text: String,
    navController: NavController = rememberNavController(),
    style: TextStyle = MaterialTheme.typography.titleLarge,
) {
    Button(
        shape = shapes.large,
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        )
    ) {
        Text(
            text,
            style = style
        )
    }
}
