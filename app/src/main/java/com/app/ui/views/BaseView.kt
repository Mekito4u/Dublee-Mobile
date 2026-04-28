package com.app.ui.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun BaseView(
    mod: Modifier = Modifier,
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    content: @Composable () -> Unit,
) {
    Column(
        modifier = mod
            .fillMaxSize()
    ) {
        // Верх 10%
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.1f),
            contentAlignment = Alignment.Center
        ) {
            topBar()
        }

        // Контент 80%
        Box(
            modifier = Modifier
                .weight(0.8f),
            contentAlignment = Alignment.Center
        ) {
            content()
        }

        // Низ 10%
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.1f),
            contentAlignment = Alignment.Center
        ) {
            bottomBar()
        }
    }
}