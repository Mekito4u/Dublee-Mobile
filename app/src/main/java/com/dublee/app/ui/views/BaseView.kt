package com.dublee.app.ui.views

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
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dublee.app.Nav
import com.dublee.app.ui.views.utils.bars.BottomBar
import com.dublee.app.ui.views.utils.theme.MyBeige

@Composable
fun BaseView(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
    currentRoute: String = Nav.Main.route,
    isVisibleTop: Boolean = false,
    isVisibleBottom: Boolean = true,
    background: Color = MyBeige,
    bottom: @Composable () -> Unit = {
        BottomBar(navController, currentRoute)
    },
    top: @Composable () -> Unit = {

    },
    content: @Composable () -> Unit = {},
) {
    Scaffold { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(background)
        ) {
            // Верх 10%
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.1f),
                contentAlignment = Alignment.Center
            ) {
                if(isVisibleTop){
                    top()
                }
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
                if (isVisibleBottom) {
                    bottom()
                }
            }
        }
    }
}