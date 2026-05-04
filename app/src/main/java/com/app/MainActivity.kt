package com.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.ui.views.*
import com.app.ui.theme.DubleeTheme

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
    Login("login"),
    Register("register"),
    CreatePair("create_pair"),
    JoinPair("join_pair"),
    CategorySelection("category_selection"),
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Nav.Login.route) {
        composable(Nav.Login.route) { LoginView(navController) }
        composable(Nav.Register.route) { RegisterView(navController) }
        composable(Nav.CreatePair.route) { CreatePairView(navController) }
        composable(Nav.JoinPair.route) { JoinPairView(navController) }
        composable(Nav.CategorySelection.route) { CategorySelectionView(navController) }
//        composable("swipe/{categoryId}") {
//            val categoryId = it.arguments?.getString("categoryId")
//            SwipeView(navController, categoryId)
//        }
    }
}