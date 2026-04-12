package com.dublee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.dublee.ui.screens.LoginScreen
import com.dublee.ui.screens.RegisterScreen
import com.dublee.ui.theme.DubleeTheme

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