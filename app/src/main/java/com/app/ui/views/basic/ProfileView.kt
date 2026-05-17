package com.app.ui.views.basic

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ManageAccounts
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
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
import com.app.ui.viewmodel.basic.ProfileViewModel
import com.app.ui.views.BaseView
import com.app.ui.widgets.ButtonItem
import com.app.ui.widgets.DubleeWidget
import com.app.ui.widgets.MyButtonsBlockWidget
import com.app.ui.widgets.PairInfoWidget

@Preview
@Composable
fun ProfileView(
    navController: NavController = rememberNavController(),
    viewModel: ProfileViewModel = viewModel()
) {
    val user by viewModel.user.collectAsStateWithLifecycle()
    val userIcon by viewModel.userIcon.collectAsStateWithLifecycle()
    val userColor by viewModel.userColor.collectAsStateWithLifecycle()

    val partner by viewModel.partner.collectAsStateWithLifecycle()
    val partnerIcon by viewModel.partnerIcon.collectAsStateWithLifecycle()
    val partnerColor by viewModel.partnerColor.collectAsStateWithLifecycle()

    BaseView(
        navController = navController,
        currentRoute = Nav.Profile.route,
        isVisibleTop = true,
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
                    PairInfoWidget(
                        userLogin = user.login,
                        userIcon = userIcon,
                        userColor = userColor,
                        partnerLogin = partner.login,
                        partnerIcon = partnerIcon,
                        partnerColor = partnerColor
                    )
                }

                item {
                    MyButtonsBlockWidget(
                        title = "Мой профиль",
                        buttons = listOf(
                            ButtonItem(
                                text = "Редактировать профиль",
                                icon = Icons.Default.Person
                            ) {

                            },
                            ButtonItem(
                                text = "Настройки пары",
                                icon = Icons.Default.People
                            ) {
                                navController.navigate(Nav.Pair.route)
                            },
                            ButtonItem(
                                text = "Мой аккаунт",
                                icon = Icons.Default.ManageAccounts
                            ) {

                            },
                            ButtonItem(
                                text = "Уведомления",
                                icon = Icons.Default.Notifications
                            ) {

                            }
                        )
                    )
                }
            }
        },
    )
}