package com.app.ui.views.basic

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.Nav
import com.app.ui.theme.MyBeige
import com.app.ui.theme.MyButton
import com.app.ui.theme.MyRed
import com.app.ui.viewmodel.basic.SettingsViewModel
import com.app.ui.views.BaseView
import com.app.ui.widgets.DubleeWidget

@Preview
@Composable
fun SettingsView(
    navController: NavController = rememberNavController(),
    viewModel: SettingsViewModel = viewModel()
) {
    val theme by viewModel.isLightTheme.collectAsStateWithLifecycle()
    val notificationEnabled by viewModel.notificationEnabled.collectAsStateWithLifecycle()

    BaseView(
        navController = navController,
        currentRoute = Nav.Settings.route,
        background = MyBeige,
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier.weight(0.20f),
                ) {
                    DubleeWidget()
                }

                Box(
                    modifier = Modifier
                        .weight(0.25f)
                        .fillMaxSize()
                )

                MyButton(
                    modifier = Modifier.weight(0.1f),
                    text = "Сменить аватар",
                    onClick = { navController.navigate(Nav.Pair.route) },
                )



                Box(
                    modifier = Modifier.weight(0.35f),
                    contentAlignment = Alignment.Center
                ) {
                    MyButton(
                        modifier = Modifier.width(128.dp),
                        onClick = {

                        },
                        text = "Выйти",
                        backgroundColor = MyRed
                    )
                }

            }
        },
    )
}