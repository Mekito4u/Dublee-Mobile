package com.app.ui.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.ui.theme.MyBrown

@Preview
@Composable
fun GoBackWidget(
    navController: NavController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .padding(start = 28.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        MyButton(
            onClick = { navController.navigate("category") },
            text = "<-",
            modifier = modifier,
            backgroundColor = MyBrown,
        )
    }
}