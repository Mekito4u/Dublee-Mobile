package com.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.app.ui.screens.LoginScreen
import com.app.ui.screens.RegisterScreen
import com.app.ui.theme.DubleeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DubleeTheme {
                LoginScreen()
                RegisterScreen()
            }
        }
    }
}