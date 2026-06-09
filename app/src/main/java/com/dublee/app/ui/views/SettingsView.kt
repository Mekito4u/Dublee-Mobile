package com.dublee.app.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dublee.app.Nav
import com.dublee.app.ui.viewmodels.SettingsViewModel
import com.dublee.app.ui.views.utils.theme.MyBeige
import com.dublee.app.ui.views.utils.theme.MyButton
import com.dublee.app.ui.views.utils.theme.MyGreen
import com.dublee.app.ui.views.utils.widgets.ButtonItem
import com.dublee.app.ui.views.utils.widgets.DubleeWidget
import com.dublee.app.ui.views.utils.widgets.MyButtonsBlockWidget
import org.koin.androidx.compose.koinViewModel


@Composable
fun SettingsView(
    navController: NavController = rememberNavController(),
    viewModel: SettingsViewModel = koinViewModel()
) {
    val isDarkTheme by viewModel.isDarkTheme.collectAsStateWithLifecycle()
    val isNotificationsEnabled by viewModel.isNotificationsEnabled.collectAsStateWithLifecycle()
    val isMusicPlayback by viewModel.isMusicPlayback.collectAsStateWithLifecycle()

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
                DubleeWidget()

                MyButtonsBlockWidget(
                    title = "Настройки",
                    buttons = listOf(
                        ButtonItem(
                            text = "Тема: " + when (isDarkTheme) {
                                true -> "Темная"
                                false -> "Светлая"
                            },
                            icon = when (isDarkTheme) {
                                true -> Icons.Default.DarkMode
                                false -> Icons.Default.LightMode
                            }
                        ) {
                            viewModel.toggleTheme()
                        },
                        ButtonItem(
                            text = "Уведомления: " + when (isNotificationsEnabled) {
                                true -> "Вкл"
                                false -> "Выкл"
                            },
                            icon = Icons.Default.Notifications
                        ) {
                            viewModel.toggleNotifications()
                        },
                        ButtonItem(
                            text = "Музыка: " + when (isMusicPlayback) {
                                true -> "Вкл"
                                false -> "Выкл"
                            },
                            icon = Icons.Default.MusicNote
                        ) {
                            viewModel.toggleMusic()
                        },
                    )
                )

                Spacer(modifier = Modifier.height(96.dp))

                Box(
                    contentAlignment = Alignment.Center
                ) {
                    MyButton(
                        modifier = Modifier
                            .width(256.dp)
                            .height(64.dp),
                        onClick = {
                            navController.navigate(Nav.Profile.route)
                        },
                        text = "Сохранить",
                        backgroundColor = MyGreen
                    )
                }

            }
        },
    )
}