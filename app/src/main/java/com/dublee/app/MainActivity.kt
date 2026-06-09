package com.dublee.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dublee.app.ui.viewmodels.SwipeViewModel
import com.dublee.app.ui.views.ActivityView
import com.dublee.app.ui.views.EditProfileView
import com.dublee.app.ui.views.LoginView
import com.dublee.app.ui.views.MainView
import com.dublee.app.ui.views.PairView
import com.dublee.app.ui.views.ProfileView
import com.dublee.app.ui.views.RegisterView
import com.dublee.app.ui.views.SettingsView
import com.dublee.app.ui.views.SplashView
import com.dublee.app.ui.views.SwipeView
import com.dublee.app.ui.views.utils.theme.DubleeTheme
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

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
    // Загрузка
    Splash("splash"),

    // Основные
    Main("main"),
    Activity("activity"),
    Stats("stats"),
    Profile("profile"),
    Swipe("swipe"),

    // Авторизация
    Login("login"),
    Register("register"),

    // Настройки
    Pair("pair"),
    Settings("settings"),
    EditProfile("edit_profile"),
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Nav.Splash.route) {
        // Загрузка
        composable(Nav.Splash.route) { SplashView(navController) }

        // Основные
        composable(Nav.Main.route) { MainView(navController) }
        composable(Nav.Activity.route) { ActivityView(navController) }
        composable(Nav.Profile.route) { ProfileView(navController) }

        // Авторизация
        composable(Nav.Login.route) { LoginView(navController) }
        composable(Nav.Register.route) { RegisterView(navController) }

        // Свайп
        composable("swipe/{categoryId}") { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId")?.toIntOrNull() ?: 0
            val viewModel: SwipeViewModel = koinViewModel(
                parameters = { parametersOf(categoryId) }
            )
            SwipeView(navController = navController, viewModel = viewModel)
        }


        // Настройки
        composable(Nav.Pair.route) { PairView(navController) }
        composable(Nav.Settings.route) { SettingsView(navController) }
        composable(Nav.EditProfile.route) { EditProfileView(navController) }
    }
}
