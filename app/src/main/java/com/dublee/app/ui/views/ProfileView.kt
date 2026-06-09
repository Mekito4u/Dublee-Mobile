package com.dublee.app.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dublee.app.Nav
import com.dublee.app.ui.viewmodels.ProfileViewModel
import com.dublee.app.ui.views.utils.bars.TopBar
import com.dublee.app.ui.views.utils.theme.MyBeige
import com.dublee.app.ui.views.utils.widgets.ButtonItem
import com.dublee.app.ui.views.utils.widgets.DubleeWidget
import com.dublee.app.ui.views.utils.widgets.MyButtonsBlockWidget
import com.dublee.app.ui.views.utils.widgets.PairInfoWidget
import org.koin.androidx.compose.koinViewModel


@Composable
fun ProfileView(
    navController: NavController = rememberNavController(),
    viewModel: ProfileViewModel = koinViewModel()
) {
    val user by viewModel.user.collectAsStateWithLifecycle()
    val partner by viewModel.partner.collectAsStateWithLifecycle()

    BaseView(
        navController = navController,
        currentRoute = Nav.Profile.route,
        isVisibleTop = true,
        top = { TopBar(navController, viewModel) },
        background = MyBeige,
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item { DubleeWidget() }

                item {
                    when (user.pairId) {
                        null -> {
                            PairInfoWidget(
                                userLogin = user.login,
                                userIcon = viewModel.getUserIcon(user.iconId),
                                userColor = viewModel.getColor(user.colorId)
                            )
                        }
                        else -> {
                            PairInfoWidget(
                                userLogin = user.login,
                                userIcon = viewModel.getUserIcon(user.iconId),
                                userColor = viewModel.getColor(user.colorId),
                                partnerLogin = partner.login,
                                partnerIcon = viewModel.getUserIcon(partner.iconId),
                                partnerColor = viewModel.getColor(partner.colorId)
                            )
                        }
                    }
                }

                item {
                    MyButtonsBlockWidget(
                        title = "Мой профиль",
                        buttons = listOf(
                            ButtonItem(
                                text = "Редактировать профиль",
                                icon = Icons.Default.Person
                            ) {
                                navController.navigate(Nav.EditProfile.route)
                            },
                            ButtonItem(
                                text = "Настройки пары",
                                icon = Icons.Default.People
                            ) {
                                navController.navigate(Nav.Pair.route)
                            },
                            ButtonItem(
                                text = "Настройки",
                                icon = Icons.Default.Settings
                            ) {
                                navController.navigate(Nav.Settings.route)
                            }
                        )
                    )
                }
            }
        },
    )
}