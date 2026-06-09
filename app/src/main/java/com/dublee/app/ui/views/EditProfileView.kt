package com.dublee.app.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Login
import androidx.compose.material.icons.filled.ColorLens
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dublee.app.Nav
import com.dublee.app.data.remote.services.AuthApiService
import com.dublee.app.data.remote.services.UserApiService
import com.dublee.app.data.repositories.TokenRepository
import com.dublee.app.data.repositories.UserRepository
import com.dublee.app.domain.mapper.ColorIcon
import com.dublee.app.domain.mapper.UserIcon
import com.dublee.app.domain.providers.UserProviderImpl
import com.dublee.app.domain.usecases.PartnerSession
import com.dublee.app.domain.usecases.UserSession
import com.dublee.app.ui.views.utils.theme.MyBeige
import com.dublee.app.ui.views.utils.theme.MyButton
import com.dublee.app.ui.views.utils.theme.MyGreen
import com.dublee.app.ui.views.utils.widgets.ButtonItem
import com.dublee.app.ui.views.utils.widgets.DubleeWidget
import com.dublee.app.ui.views.utils.widgets.MyButtonsBlockWidget
import com.dublee.app.ui.views.utils.widgets.PairInfoWidget
import com.dublee.app.ui.viewmodels.EditProfileViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun EditProfileViewPreview() {
    EditProfileView(
        viewModel = EditProfileViewModel(
            userProviderImpl = UserProviderImpl(
                userRepository = UserRepository(
                    userSession = UserSession(),
                    partnerSession = PartnerSession(),
                    tokenRepository = TokenRepository(
                        context = LocalContext.current
                    ),
                    userApiService = UserApiService(),
                    authApiService = AuthApiService()
                )
            )
        )
    )
}

@Composable
fun EditProfileView(
    navController: NavController = rememberNavController(),
    viewModel: EditProfileViewModel = koinViewModel()
) {
    val scope = rememberCoroutineScope()
    val user = remember { viewModel.user.value }
    var tempIconId by remember { mutableStateOf(viewModel.user.value.iconId) }
    var tempColorId by remember { mutableStateOf(viewModel.user.value.colorId) }

    BaseView(
        navController = navController,
        currentRoute = Nav.Settings.route,
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
                        userIcon = viewModel.getUserIcon(tempIconId),
                        userColor = viewModel.getColor(tempColorId)
                    )
                }

                item {
                    MyButtonsBlockWidget(
                        title = "Профиль",
                        buttons = listOf(
                            ButtonItem(
                                text = "Сменить аватар",
                                icon = Icons.Default.Person
                            ) {
                                tempIconId = (tempIconId + 1) % UserIcon.entries.size
                            },
                            ButtonItem(
                                text = "Сменить цвет:",
                                icon = Icons.Default.ColorLens
                            ) {
                                tempColorId = (tempColorId + 1) % ColorIcon.entries.size
                            },
                            ButtonItem(
                                text = "Сменить логин",
                                icon = Icons.AutoMirrored.Filled.Login
                            ) {

                            },
                            ButtonItem(
                                text = "Сменить пароль",
                                icon = Icons.Default.Password
                            ) {

                            },
                        )
                    )
                }

                item {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        MyButton(
                            modifier = Modifier
                                .width(256.dp)
                                .height(64.dp),
                            onClick = {
                                scope.launch {
                                    viewModel.updateUser(
                                        iconId = tempIconId,
                                        colorId = tempColorId
                                    )
                                    navController.navigate(Nav.Profile.route)
                                }
                            },
                            text = "Сохранить",
                            backgroundColor = MyGreen
                        )
                    }
                }

                item { }
            }
        },
    )
}