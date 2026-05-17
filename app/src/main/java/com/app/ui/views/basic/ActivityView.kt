package com.app.ui.views.basic

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.Nav
import com.app.domain.models.basic.LikeModel
import com.app.domain.models.basic.MatchModel
import com.app.domain.util.formatTime
import com.app.ui.theme.MyText
import com.app.ui.viewmodel.basic.ActivityViewModel
import com.app.ui.views.BaseView
import com.app.ui.widgets.LikeWidget
import com.app.ui.widgets.MatchWidget

@Preview
@Composable
fun ActivityView(
    navController: NavController = rememberNavController(),
    viewModel: ActivityViewModel = viewModel()
) {
    val dataList by viewModel.dataList.collectAsStateWithLifecycle()

    BaseView(
        navController = navController,
        currentRoute = Nav.Activity.route,
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    MyText(
                        modifier = Modifier.padding(top = 24.dp),
                        text = "Недавняя активность:", style = typography.titleLarge,
                        textAlign = TextAlign.Start
                    )
                }
                items(dataList) { item ->
                    when (item) {
                        is LikeModel -> {
                            val category = viewModel.getCategoryById(item.categoryId)
                            LikeWidget(
                                categoryName = category?.title ?: "Ошибка",
                                time = formatTime(item.timestamp),
                                icon = category?.icon ?: Icons.Default.Error
                            ) {
                                viewModel.deleteLike(item.id)
                            }
                        }

                        is MatchModel -> {
                            val category = viewModel.getCategoryById(item.categoryId)
                            MatchWidget(
                                categoryName = category?.title ?: "Ошибка",
                                time = formatTime(item.timestamp),
                                icon = category?.icon ?: Icons.Default.Error
                            )
                        }
                    }
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