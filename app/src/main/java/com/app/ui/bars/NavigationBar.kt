package com.app.ui.bars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.Nav
import com.app.ui.theme.MyBrown
import com.app.ui.theme.MyButton
import com.app.ui.theme.MyCream

@Composable
fun NavigationButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    icon: ImageVector = Icons.Default.Home,
    text: String = "Главная",
    isSelected: Boolean = false
) {
    val color = if (isSelected) {
        Color.Black
    } else {
        MyBrown
    }

    MyButton(
        modifier = modifier.fillMaxSize(),
        onClick = onClick,
        content = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier,
                    imageVector = icon,
                    contentDescription = "",
                    tint = color,
                )
                Text(
                    modifier = Modifier,
                    textAlign = TextAlign.Center,
                    text = text,
                    style = typography.titleSmall,
                    color = color
                )
            }
        },
        contentPadding = PaddingValues(4.dp),
        backgroundColor = MyCream
    )
}

@Preview
@Composable
fun NavigationBar(
    navController: NavController = rememberNavController(),
    currentRoute: String = ""
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MyCream),
        verticalAlignment = Alignment.CenterVertically
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