package com.dublee.app.ui.views

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
import com.dublee.app.ui.viewmodels.MainViewModel
import com.dublee.app.ui.views.utils.theme.MyText
import com.dublee.app.ui.views.utils.widgets.DubleeIconWidget
import com.dublee.app.ui.views.utils.widgets.DubleeWidget
import com.dublee.app.ui.views.utils.widgets.InfoWidget

@Preview
@Composable
fun StatsView(
    navController: NavController = rememberNavController(),
    viewModel: MainViewModel = viewModel()
) {
    val categoryList by viewModel.categoryList.collectAsStateWithLifecycle()

    BaseView(
        content = {
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
                    InfoWidget(
                        title = item.title,
                        description = item.description,
                        icon = viewModel.getCategoryIcon(item.iconId),
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
    )
}