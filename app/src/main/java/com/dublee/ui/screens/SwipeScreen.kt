package com.dublee.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable

@Composable
fun SwipeScreen(
    topBar: @Composable () -> Unit,
    content: @Composable (PaddingValues) -> Unit,
    bottomBar: @Composable () -> Unit,
) {
}