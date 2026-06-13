package com.dublee.app.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dublee.app.Nav
import com.dublee.app.ui.viewmodels.LoginViewModel
import com.dublee.app.ui.views.utils.theme.MyBeige
import com.dublee.app.ui.views.utils.theme.MyButton
import com.dublee.app.ui.views.utils.theme.MyCream
import com.dublee.app.ui.views.utils.theme.MyRed
import com.dublee.app.ui.views.utils.theme.MyText
import com.dublee.app.ui.views.utils.theme.MyTextField
import com.dublee.app.ui.views.utils.widgets.DubleeWidget
import com.dublee.app.ui.views.utils.widgets.NoAccountWidget
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel


@Composable
fun LoginView(
    navController: NavController = rememberNavController(),
    viewModel: LoginViewModel = koinViewModel(),
) {
    val partner by viewModel.partner.collectAsStateWithLifecycle()
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val errorMsg by viewModel.errorMsg.collectAsStateWithLifecycle()

    BaseView(
        navController = navController,
        currentRoute = Nav.Login.route,
        background = MyBeige,
        isVisibleBottom = true,
        bottom = {
            NoAccountWidget(navController)
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                DubleeWidget()

                if (errorMsg != null) {
                    MyText(
                        text = errorMsg!!,
                        style = typography.titleMedium,
                        color = MyRed
                    )
                } else {
                    Spacer(modifier = Modifier.height(32.dp))
                }

                MyTextField(
                    value = login,
                    onValueChange = { login = it },
                    prefix = "Логин",
                    backgroundColor = MyCream
                )

                MyTextField(
                    value = password,
                    onValueChange = { password = it },
                    prefix = "Пароль",
                    backgroundColor = MyCream
                )

                Spacer(modifier = Modifier.height(96.dp))

                MyButton(
                    onClick = {
                        viewModel.login(login, password) {
                            viewModel.viewModelScope.launch {
                                if (partner.id > 0) {
                                    navController.navigate(Nav.Main.route)
                                } else {
                                    navController.navigate(Nav.Pair.route)
                                }
                            }
                        }
                    },
                    text = "Войти",
                    backgroundColor = MyBeige,
                )
            }
        }
    )
}
