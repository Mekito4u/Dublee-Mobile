package com.app.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.Nav
import com.app.ui.theme.MyBeige
import com.app.ui.theme.MyBlue
import com.app.ui.theme.MyCream
import com.app.ui.widgets.DubleeWidget
import com.app.ui.widgets.MyButton
import com.app.ui.widgets.MyTextField
import com.app.ui.widgets.NoAccountWidget

@Preview
@Composable
fun LoginView(
    navController: NavController = rememberNavController()
) {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    BaseView(
        mod = Modifier.background(MyBeige),
        bottomBar = { NoAccountWidget(navController) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Box(
                modifier = Modifier.weight(0.25f),
            ) {
                DubleeWidget()
            }

            Spacer(modifier = Modifier.weight(0.05f))

            Column(
                modifier = Modifier
                    .weight(0.40f)
                    .width(512.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                MyTextField(
                    modifier = Modifier.weight(0.3f),
                    value = login,
                    onValueChange = { login = it},
                    prefix = "Логин",
                    backgroundColor = MyCream
                )

                Spacer(modifier = Modifier.weight(0.05f))

                MyTextField(
                    modifier = Modifier.weight(0.3f),
                    value = password,
                    onValueChange = { password = it},
                    prefix = "Пароль",
                    backgroundColor = MyCream
                )

                Spacer(modifier = Modifier.weight(0.35f))
            }

            Spacer(modifier = Modifier.weight(0.05f))

            MyButton(
                onClick = { navController.navigate(Nav.Main.route) },
                text = "Войти",
                backgroundColor = MyBlue,
                modifier = Modifier.weight(0.1f).width(256.dp)
            )

            Spacer(modifier = Modifier.weight(0.05f))
            Spacer(modifier = Modifier.weight(0.05f))
        }
    }
}