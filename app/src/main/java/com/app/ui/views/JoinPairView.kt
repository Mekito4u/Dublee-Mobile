package com.app.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import com.app.ui.components.DubleeWidget
import com.app.ui.components.MyButton
import com.app.ui.theme.MyBeige
import com.app.ui.theme.MyGreen
import com.app.ui.theme.MyRed

@Preview
@Composable
fun JoinPairView(
    navController: NavController = rememberNavController()
) {
    var arriveId by remember { mutableStateOf("#2") }

    BaseView(
        mod = Modifier.background(MyBeige),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                modifier = Modifier.weight(0.25f),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DubleeWidget()
                Text(
                    modifier = Modifier.padding(horizontal = 28.dp),
                    text = "Вам пришло приглашение!\nПринять его?",
                    style = MaterialTheme.typography.headlineSmall
                )
            }

            Spacer(modifier = Modifier.weight(0.05f))

            Column(
                modifier = Modifier
                    .weight(0.40f)
                    .width(512.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.weight(0.2f))

                Text(
                    text = "id пригласившего: $arriveId",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.weight(0.1f)
                )

                Spacer(modifier = Modifier.weight(0.05f))

                Spacer(modifier = Modifier.weight(0.3f))

                Spacer(modifier = Modifier.weight(0.35f))
            }

            Spacer(modifier = Modifier.weight(0.05f))

            Row(
                modifier = Modifier
                    .weight(0.1f),
                horizontalArrangement = Arrangement.Center
            ) {
                MyButton(
                    onClick = { navController.navigate("category") },
                    text = "Да",
                    backgroundColor = MyGreen,
                    modifier = Modifier
                        .width(128.dp)
                        .fillMaxHeight()
                )

                Spacer(modifier = Modifier.width(24.dp))

                MyButton(
                    onClick = { navController.navigate("category") },
                    text = "Нет",
                    backgroundColor = MyRed,
                    modifier = Modifier
                        .width(128.dp)
                        .fillMaxHeight()
                )
            }


            Spacer(modifier = Modifier.weight(0.05f))
            Spacer(modifier = Modifier.weight(0.05f))
        }
    }
}