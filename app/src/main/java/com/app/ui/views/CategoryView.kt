package com.app.ui.views

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.ui.viewmodel.basic.MainViewModel

@Composable
fun CategoryView(
    navController: NavController = rememberNavController(),
    categoryId: Int? = null,
    viewModel: MainViewModel = viewModel()
) {
}