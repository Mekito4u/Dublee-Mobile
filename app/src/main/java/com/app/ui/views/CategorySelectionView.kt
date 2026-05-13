package com.app.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.Nav
import com.app.domain.models.basic.CategoryModel
import com.app.ui.theme.MyCream
import com.app.ui.theme.MyBeige
import com.app.ui.theme.MyButton
import com.app.ui.widgets.CategoryWidget
import com.app.ui.widgets.DubleeWidget

@Preview
@Composable
fun CategorySelectionView(
    navController: NavController = rememberNavController()
) {
    val exList = List(5) { index ->
        CategoryModel(
            index,
            "Бебра",
            "Крутая",
            Icons.Default.Home
        )
    }
    var categoryList by remember { mutableStateOf(exList) }

    BaseView(
        modifier = Modifier.background(MyCream),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Box(
                modifier = Modifier.weight(0.20f),
            ) {
                DubleeWidget()
            }

            LazyRow(
                modifier = Modifier
                    .weight(0.50f)
                    .fillMaxSize()
                    .padding(start = 24.dp, end = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                items(categoryList) { item ->
                    CategoryWidget(
                        title = item.title,
                        description = item.description,
                    )
                }
            }

            Spacer(modifier = Modifier.weight(0.05f))

            MyButton(
                onClick = { navController.navigate(Nav.Main.route) },
                text = "Выбрать",
                backgroundColor = MyBeige,
                modifier = Modifier
                    .weight(0.1f)
                    .width(256.dp)
            )

            Spacer(modifier = Modifier.weight(0.05f))
            Spacer(modifier = Modifier.weight(0.05f))
        }
    }
}