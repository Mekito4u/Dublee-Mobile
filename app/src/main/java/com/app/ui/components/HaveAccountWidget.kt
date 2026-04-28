package com.app.ui.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.ui.theme.MyBlue

@Preview
@Composable
fun HaveAccountWidget(
    navController: NavController = rememberNavController()
) {
    val myStyle = MaterialTheme.typography.titleMedium

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("У вас уже есть аккаунта?", style = myStyle)
        Text(
            text = "Войти",
            style = myStyle,
            color = MyBlue,
            modifier = Modifier.clickable {
                Log.d("Navigation", "switch to login")
                navController.navigate("login")
            }
        )
    }
}