package com.dublee.app.ui.views.utils.bars

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dublee.app.Nav
import com.dublee.app.ui.views.utils.theme.MyBrown
import com.dublee.app.ui.views.utils.theme.MyNavigationButton

@Composable
fun TopBar(
    navController: NavController = rememberNavController(),
    onClickLogout: () -> Unit
) {
    val myShape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)

    Row(
        modifier = Modifier
            .clip(shape = myShape),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Spacer(
            modifier = Modifier
                .weight(0.75f)
        )


        MyNavigationButton(
            modifier = Modifier
                .weight(0.25f)
                .border(
                    width = 1.dp,
                    color = MyBrown,
                    shape = myShape
                ),
            onClick = {
                onClickLogout()
                navController.navigate(Nav.Login.route)
            },
            icon = Icons.Default.Logout,

            text = null,
            shape = myShape
        )
    }
}