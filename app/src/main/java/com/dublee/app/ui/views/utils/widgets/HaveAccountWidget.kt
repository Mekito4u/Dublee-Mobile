package com.dublee.app.ui.views.utils.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dublee.app.Nav
import com.dublee.app.ui.views.utils.theme.MyBrown
import com.dublee.app.ui.views.utils.theme.MyText

@Preview
@Composable
fun HaveAccountWidget(
    navController: NavController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    val myStyle = MaterialTheme.typography.titleMedium

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyText(
            text = "У вас уже есть аккаунта?",
            style = myStyle
        )
        MyText(
            text = "Войти",
            style = myStyle,
            color = MyBrown,
            modifier = Modifier.clickable {
                navController.navigate(Nav.Login.route)
            }
        )
    }
}