package com.app.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.ui.bars.BottomBar
import com.app.ui.bars.TopBar
import com.app.ui.theme.MyCream

@Preview
@Composable
fun BaseView(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
    content: @Composable () -> Unit = {}
) {
    val currentRoute = navController.currentDestination?.route ?: ""

    Scaffold { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MyCream)
        ) {
            // Верх 10%
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.1f),
                contentAlignment = Alignment.Center
            ) {
                TopBar(navController)
            }

            // Контент 80%
            Box(
                modifier = Modifier
                    .fillMaxWidth()
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
                BottomBar(navController, currentRoute)
            }
        }
    }
}