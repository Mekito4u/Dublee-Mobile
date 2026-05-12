package com.app.ui.bars

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.Nav
import com.app.ui.buttons.NavigationButton
import com.app.ui.theme.MyBeige
import com.app.ui.theme.MyBrown

@Preview
@Composable
fun TopBar(
    navController: NavController = rememberNavController(),
) {
    val myShape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = myShape)
            .background(MyBeige)
            .border(
                width = 1.dp,
                color = MyBrown,
                shape = myShape
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        NavigationButton(
            modifier = Modifier.weight(0.25f),
            onClick = {
                when (navController.currentDestination?.route) {
                    Nav.Login.route, Nav.Register.route -> navController.navigate(Nav.Main.route)
                    else -> navController.popBackStack()
                }
            },
            icon = Icons.AutoMirrored.Filled.ArrowBack,
            text = null,
        )

        Spacer(
            modifier = Modifier
                .weight(0.5f)
        )


        NavigationButton(
            modifier = Modifier.weight(0.25f),
            onClick = {
                navController.navigate(Nav.Settings.route)
            },
            icon = Icons.Default.Settings,
            text = null,
        )
    }
}