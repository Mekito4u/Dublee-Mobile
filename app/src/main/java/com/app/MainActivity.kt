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
import com.app.ui.views.CreatePairView
import com.app.ui.views.JoinPairView
import com.app.ui.views.LoginView
import com.app.ui.views.MainView
import com.app.ui.views.RegisterView

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
    Likes("likes"),
    Stats("stats"),
    Profile("profile"),

    // Авторизация
    Login("login"),
    Register("register"),

    // Пары
    CreatePair("create_pair"),
    JoinPair("join_pair"),

    // Дополнительные
    Settings("settings")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Nav.Login.route) {
        composable(Nav.Main.route) { MainView(navController) }
        composable(Nav.Login.route) { LoginView(navController) }
        composable(Nav.Register.route) { RegisterView(navController) }
        composable(Nav.CreatePair.route) { CreatePairView(navController) }
        composable(Nav.JoinPair.route) { JoinPairView(navController) }
        composable("category/{categoryId}") { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId")
            CategoryView(navController, categoryId?.toIntOrNull() ?: 1)
        }
    }
}
