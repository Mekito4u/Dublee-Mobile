package com.app.ui.views

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.ui.theme.MyBeige
import com.app.ui.widgets.GoBackWidget

@Preview
@Composable
fun MainView(
    navController: NavController = rememberNavController()
) {
    BaseView(
        mod = Modifier.background(MyBeige),
        topBar = { GoBackWidget(navController) }
    ) {

    }
}