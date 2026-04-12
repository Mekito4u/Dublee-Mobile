package com.dublee.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NoAccountWidget() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("У вас нет аккаунта?")
        Text(
            text = "Регистрация",
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.clickable {
            }
        )
    }
}