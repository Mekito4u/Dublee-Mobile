package com.app.ui.views.basic

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.Nav
import com.app.ui.theme.MyText
import com.app.ui.viewmodel.basic.MainViewModel
import com.app.ui.views.BaseView
import com.app.ui.widgets.CategoryWidget
import com.app.ui.widgets.DubleeIconWidget
import com.app.ui.widgets.DubleeWidget

@Preview
@Composable
fun MainView(
    navController: NavController = rememberNavController(),
    viewModel: MainViewModel = viewModel()
) {
    val categoryList by viewModel.categoryList.collectAsStateWithLifecycle()

    BaseView(
        navController = navController,
        currentRoute = Nav.Main.route
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item { DubleeWidget() }
            item {
                Spacer(
                    modifier = Modifier
                        .height(64.dp)
                )
            }
            item { DubleeIconWidget() }
            item {
                Spacer(
                    modifier = Modifier
                        .height(64.dp)
                )
            }
            item { MyText(text = "Выберите категорию:", style = typography.titleLarge) }
            items(categoryList) { item ->
                CategoryWidget(
                    title = item.title,
                    description = item.description,
                    icon = item.icon,
                    onClicked = {
                        navController.navigate("category/${item.id}")
                    }
                )
            }
            item {
                Spacer(
                    modifier = Modifier
                        .height(0.dp)
                )
            }
        }
    }
}