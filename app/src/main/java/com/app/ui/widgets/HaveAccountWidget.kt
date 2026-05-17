package com.app.ui.widgets

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.ui.theme.MyBeige
import com.app.ui.theme.MyBrown

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
        Text("У вас уже есть аккаунта?", style = myStyle)
        Text(
            text = "Войти",
            style = myStyle,
            color = MyBrown,
            modifier = Modifier.clickable {
                Log.d("Navigation", "switch to login")
                navController.navigate("login")
            }
        )
    }
}