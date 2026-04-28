package com.app.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.ui.components.DubleeWidget
import com.app.ui.components.MyButton
import com.app.ui.components.MyTextField
import com.app.ui.components.NoAccountWidget
import com.app.ui.theme.MyBeige
import com.app.ui.theme.MyBlue
import com.app.ui.theme.MyCream
import com.app.ui.theme.MyCyan

@Preview
@Composable
fun LoginView(
    navController: NavController = rememberNavController()
) {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val hideLine = TextFieldDefaults.colors(
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
        errorIndicatorColor = Color.Transparent
    )

    BaseView(
        mod = Modifier.background(MyBeige),
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
                onClick = { navController.navigate("register") },
                text = "Войти",
                backgroundColor = MyBlue,
                modifier = Modifier.weight(0.1f).width(256.dp)
            )

            Spacer(modifier = Modifier.weight(0.05f))

            NoAccountWidget(navController)
        }
    }
}