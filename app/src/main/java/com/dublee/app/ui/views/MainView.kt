package com.dublee.app.ui.views

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dublee.app.Nav
import com.dublee.app.ui.viewmodels.MainViewModel
import com.dublee.app.ui.views.utils.theme.MyBeige
import com.dublee.app.ui.views.utils.theme.MyText
import com.dublee.app.ui.views.utils.widgets.DubleeWidget
import com.dublee.app.ui.views.utils.widgets.InfoWidget
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainView(
    navController: NavController = rememberNavController(),
    viewModel: MainViewModel = koinViewModel()
) {
    val context = LocalContext.current
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            viewModel.registerFcmToken()
        } else {
        }
    }

    LaunchedEffect(Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            when (ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS)) {
                PackageManager.PERMISSION_GRANTED -> viewModel.registerFcmToken()
                else -> permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        } else {
            viewModel.registerFcmToken()
        }
    }

    val categoryList by viewModel.categoryList.collectAsStateWithLifecycle()

    BaseView(
        navController = navController,
        currentRoute = Nav.Main.route,
        background = MyBeige,
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item { DubleeWidget() }

                item {
                    MyText(
                        text = "Выберите категорию:",
                        style = typography.titleLarge
                    )
                }

                items(categoryList) { item ->
                    InfoWidget(
                        title = item.title,
                        description = item.description,
                        icon = viewModel.getCategoryIcon(item.iconId),
                        onClicked = {
                            navController.navigate("swipe/${item.id}")
                        }
                    )
                }

                item {  }
            }
        }
    )
}