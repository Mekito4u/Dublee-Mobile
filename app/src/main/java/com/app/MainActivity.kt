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

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginView(navController) }
        composable("register") { RegisterView(navController) }
//        composable("create_pair") { CreatePairView(navController) }
//        composable("join_pair") { JoinPairView(navController) }
//        composable("category") { CategoryView(navController) }
//        composable("swipe/{categoryId}") {
//            val categoryId = it.arguments?.getString("categoryId")
//            SwipeView(navController, categoryId)
//        }
    }
}