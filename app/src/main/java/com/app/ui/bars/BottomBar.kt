package com.app.ui.bars

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.MaterialTheme.shapes
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
fun BottomBar(
    navController: NavController = rememberNavController(),
    currentRoute: String = "main"
) {
    val myShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
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
        verticalAlignment = Alignment.CenterVertically,
    ) {
        NavigationButton(
            modifier = Modifier.weight(0.25f),
            onClick = {
                navController.navigate(Nav.Main.route)
            },
            icon = Icons.Default.Home,
            text = "Главная",
            isSelected = currentRoute == Nav.Main.route
        )
        NavigationButton(
            modifier = Modifier.weight(0.25f),
            onClick = {
                navController.navigate(Nav.Likes.route)
            },
            icon = Icons.Default.Favorite,
            text = "Избранное",
            isSelected = currentRoute == Nav.Likes.route
        )
        NavigationButton(
            modifier = Modifier.weight(0.25f),
            onClick = {
                navController.navigate(Nav.Stats.route)
            },
            icon = Icons.Default.Analytics,
            text = "Статистика",
            isSelected = currentRoute == Nav.Stats.route
        )
        NavigationButton(
            modifier = Modifier.weight(0.25f),
            onClick = {
                navController.navigate(Nav.Profile.route)
            },
            icon = Icons.Default.Person,
            text = "Профиль",
            isSelected = currentRoute == Nav.Profile.route
        )
    }
}