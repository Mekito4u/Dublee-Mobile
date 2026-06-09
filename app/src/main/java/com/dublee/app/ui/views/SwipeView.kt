package com.dublee.app.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.NotInterested
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dublee.app.Nav
import com.dublee.app.ui.viewmodels.SwipeViewModel
import com.dublee.app.ui.views.utils.theme.MyBeige
import com.dublee.app.ui.views.utils.theme.MyButton
import com.dublee.app.ui.views.utils.theme.MyGreen
import com.dublee.app.ui.views.utils.theme.MyRed
import com.dublee.app.ui.views.utils.widgets.DubleeWidget
import com.dublee.app.ui.views.utils.widgets.InfoWidget
import org.koin.androidx.compose.koinViewModel


@Composable
fun SwipeView(
    navController: NavController = rememberNavController(),
    viewModel: SwipeViewModel = koinViewModel()
) {
    val options = viewModel.options.collectAsStateWithLifecycle()
    val currentIndex = viewModel.currentIndex.collectAsStateWithLifecycle()
    val option = viewModel.option.collectAsStateWithLifecycle()

    BaseView(
        navController = navController,
        currentRoute = Nav.Swipe.route,
        background = MyBeige,
        content = {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item { DubleeWidget() }

                item { }

                if (currentIndex.value != -1) {
                    item {
                        InfoWidget(
                            iconSize = 128.dp,
                            iconAlign = Alignment.CenterHorizontally,
                            title = option.value.title,
                            description = option.value.description,
                            icon = viewModel.getOptionIcon(option.value.iconId)
                        )
                    }

                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 24.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            MyButton(
                                modifier = Modifier
                                    .height(96.dp)
                                    .weight(0.45f),
                                text = "Dislike",
                                backgroundColor = MyRed,
                                onClick = {
                                    viewModel.dislikeOption(option.value.id)
                                }
                            ) {
                                Icon(
                                    modifier = Modifier.fillMaxSize(),
                                    imageVector = Icons.Default.NotInterested,
                                    contentDescription = "dislike",
                                    tint = Color.Black
                                )
                            }

                            Spacer(modifier = Modifier.weight(0.1f))

                            MyButton(
                                modifier = Modifier
                                    .height(96.dp)
                                    .weight(0.45f),
                                text = "Like",
                                backgroundColor = MyGreen,
                                onClick = {
                                    viewModel.likeOption(option.value.id)
                                }
                            ) {
                                Icon(
                                    modifier = Modifier.fillMaxSize(),
                                    imageVector = Icons.Default.Favorite,
                                    contentDescription = "dislike",
                                    tint = Color.Black
                                )
                            }
                        }
                    }
                } else {
                    item {
                        MyButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 24.dp)
                                .height(96.dp),
                            text = "Exit",
                            onClick = {
                                navController.navigate(Nav.Main.route)
                            }
                        ) {
                            Icon(
                                modifier = Modifier.fillMaxSize(),
                                imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                                contentDescription = "dislike",
                                tint = Color.Black
                            )
                        }
                    }
                }
            }
        },
    )
}