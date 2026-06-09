package com.dublee.app.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dublee.app.Nav
import com.dublee.app.domain.models.LikeModel
import com.dublee.app.domain.models.MatchModel
import com.dublee.app.domain.util.formatTime
import com.dublee.app.ui.viewmodels.ActivityViewModel
import com.dublee.app.ui.views.utils.theme.MyText
import com.dublee.app.ui.views.utils.widgets.LikeWidget
import com.dublee.app.ui.views.utils.widgets.MatchWidget
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel


@Composable
fun ActivityView(
    navController: NavController = rememberNavController(),
    viewModel: ActivityViewModel = koinViewModel()
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
                if (dataList.isEmpty()) {
                    item {
                        MyText(text = "Пока что здесь пусто")
                    }
                } else {
                    items(dataList) { item ->
                        when (item) {
                            is LikeModel -> {
                                val category = viewModel.getCategory(item.categoryId)
                                val option = viewModel.getOption(item.optionId)
                                LikeWidget(
                                    categoryName = category.title,
                                    optionName = option.title,
                                    time = formatTime(item.createdAt),
                                    icon = viewModel.getCategoryIcon(category.iconId)
                                ) {
                                    viewModel.viewModelScope.launch {
                                        viewModel.deleteLike(item.id)
                                        viewModel.updateData()
                                    }
                                }
                            }

                            is MatchModel -> {
                                val category = viewModel.getCategory(item.categoryId)
                                val option = viewModel.getOption(item.optionId)
                                MatchWidget(
                                    categoryName = category.title,
                                    optionName = option.title,
                                    time = formatTime(item.createdAt),
                                    icon = viewModel.getCategoryIcon(category.iconId)
                                )
                            }
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