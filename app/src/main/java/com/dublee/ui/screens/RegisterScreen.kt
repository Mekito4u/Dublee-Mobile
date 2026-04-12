package com.dublee.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
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

@Composable
fun RegisterScreen() {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    BaseScreen(
        topBar = {},
        bottomBar = {},
    ) {
        BaseScreen(
            topBar = { DubleeWidget() },
            bottomBar = {},
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box(
                    modifier = Modifier.weight(0.4f)
                ) {
                    DubleeImageWidget()
                }

                Spacer(modifier=Modifier.weight(0.05f))

                Column(
                    modifier = Modifier.weight(0.40f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    TextField(
                        modifier = Modifier.weight(0.3f),
                        value = login,
                        onValueChange = { login = it },
                        label = { Text("Логин") }
                    )

                    Spacer(modifier=Modifier.weight(0.05f))

                    TextField(
                        modifier = Modifier.weight(0.3f),
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Пароль") }
                    )

                    Spacer(modifier=Modifier.weight(0.05f))

                    TextField(
                        modifier = Modifier.weight(0.3f),
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Повторите пароль") }
                    )
                }

                Spacer(modifier=Modifier.weight(0.05f))

                Button(
                    modifier = Modifier
                        .weight(0.10f)
                        .width(256.dp),
                    onClick = {}
                ) {
                    Text("Регистрация", style = MaterialTheme.typography.titleLarge)
                }

                Spacer(modifier=Modifier.weight(0.05f))
            }
        }
    }
}