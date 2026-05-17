package com.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.ui.theme.DubleeTheme
import com.app.ui.views.CategoryView
import com.app.ui.views.PairView
import com.app.ui.views.LoginView
import com.app.ui.views.RegisterView
import com.app.ui.views.basic.ActivityView
import com.app.ui.views.basic.MainView
import com.app.ui.views.basic.ProfileView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DubleeTheme {
                AppNavigation()
            }
        }
    }
}

enum class Nav(val route: String) {
    // Основные
    Main("main"),
    Activity("activity"),
    Stats("stats"),
    Profile("profile"),

    // Авторизация
    Login("login"),
    Register("register"),

    // Пары
    Pair("pair"),

    // Дополнительные
    Settings("settings")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Nav.Profile.route) {
        // Основные
        composable(Nav.Main.route) { MainView(navController) }
        composable(Nav.Activity.route) { ActivityView(navController) }
        composable(Nav.Profile.route) { ProfileView(navController) }

        // Авторизация
        composable(Nav.Login.route) { LoginView(navController) }
        composable(Nav.Register.route) { RegisterView(navController) }

        // Пары
        composable(Nav.Pair.route) { PairView(navController) }

        // Категории
        composable("category/{categoryId}") { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId")
            CategoryView(navController, categoryId?.toIntOrNull() ?: 1)
        }
    }
}
