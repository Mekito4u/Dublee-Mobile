package com.dublee.app.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dublee.app.Nav
import com.dublee.app.ui.viewmodels.SplashViewModel
import com.dublee.app.ui.views.utils.theme.MyBeige
import com.dublee.app.ui.views.utils.theme.MyBrown
import com.dublee.app.ui.views.utils.theme.MyText
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashView(
    navController: NavController = rememberNavController(),
    viewModel: SplashViewModel = koinViewModel(),
) {
    LaunchedEffect(Unit) {
        delay(1000)
        val route = viewModel.getStartRoute()
        navController.navigate(route) {
            popUpTo(Nav.Splash.route) { inclusive = true }
        }
    }


    BaseView(
        navController = navController,
        currentRoute = Nav.Splash.route,
        background = MyBeige,
        isVisibleBottom = false,
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MyText(
                    text = "Dublee",
                    style = typography.displaySmall
                )

                Spacer(modifier = Modifier.height(120.dp))

                CircularProgressIndicator(
                    modifier = Modifier
                        .size(64.dp),
                    color = MyBrown
                )
            }
        }
    )
}
