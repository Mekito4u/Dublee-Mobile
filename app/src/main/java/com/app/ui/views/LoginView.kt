package com.app.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.app.ui.theme.MyCream
import com.app.ui.theme.MyRed
import com.app.ui.theme.MyText
import com.app.ui.theme.MyTextField
import com.app.ui.viewmodel.basic.LoginViewModel
import com.app.ui.widgets.DubleeWidget
import com.app.ui.widgets.NoAccountWidget

@Preview
@Composable
fun LoginView(
    navController: NavController = rememberNavController(),
    viewModel: LoginViewModel = viewModel(),
) {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val errorMsg by viewModel.errorMsg.collectAsStateWithLifecycle()

    BaseView(
        navController = navController,
        currentRoute = Nav.Login.route,
        background = MyBeige,
        isVisibleBottom = false,
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                DubleeWidget()

                Spacer(modifier = Modifier.height(32.dp))

                if (errorMsg != null) {
                    MyText(
                        text = errorMsg!!,
                        modifier = Modifier.height(32.dp),
                        color = MyRed
                    )
                } else {
                    Spacer(modifier = Modifier.height(32.dp))
                }

                MyTextField(
                    value = login,
                    onValueChange = { login = it },
                    prefix = "Логин",
                    backgroundColor = MyCream,
                    modifier = Modifier
                        .width(256.dp)
                        .height(96.dp)
                )

                MyTextField(
                    value = password,
                    onValueChange = { password = it },
                    prefix = "Пароль",
                    backgroundColor = MyCream,
                    modifier = Modifier
                        .width(256.dp)
                        .height(96.dp)
                )

                Spacer(modifier = Modifier.height(96.dp))

                MyButton(
                    onClick = { navController.navigate(Nav.Main.route) },
                    text = "Войти",
                    backgroundColor = MyBeige,
                    modifier = Modifier.width(256.dp)
                )

                NoAccountWidget(navController)
            }
        }
    )
}
