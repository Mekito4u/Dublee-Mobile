package com.dublee.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dublee.ui.components.DubleeImageWidget
import com.dublee.ui.components.DubleeWidget
import com.dublee.ui.components.NoAccountWidget

@Composable
fun LoginScreen() {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    BaseScreen(
        topBar = {},
        bottomBar = {},
    ) {
        BaseScreen(
            topBar = { DubleeWidget() },
            bottomBar = { NoAccountWidget() },
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround,
            ) {
                DubleeImageWidget(256.dp)

                TextField(
                    value = login,
                    onValueChange = { login = it },
                    label = { Text("Логин") }
                )

                TextField(
                    modifier=Modifier,
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Пароль") }
                )

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    modifier = Modifier
                        .width(256.dp)
                        .height(64.dp),
                    onClick = {}
                ) {
                    Text("Войти")
                }

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}