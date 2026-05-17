package com.app.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.app.ui.theme.MyBeige
import com.app.ui.theme.MyButton
import com.app.ui.theme.MyCream
import com.app.ui.theme.MyGreen
import com.app.ui.theme.MyRed
import com.app.ui.theme.MyText
import com.app.ui.theme.MyTextField
import com.app.ui.viewmodel.basic.PairViewModel
import com.app.ui.widgets.DubleeWidget
import com.app.ui.widgets.PersonInfoWidget

@Preview
@Composable
fun PairView(
    navController: NavController = rememberNavController(),
    viewModel: PairViewModel = viewModel(),
) {
    val user by viewModel.user.collectAsStateWithLifecycle()

    val partner by viewModel.partner.collectAsStateWithLifecycle()
    val partnerIcon by viewModel.partnerIcon.collectAsStateWithLifecycle()
    val partnerColor by viewModel.partnerColor.collectAsStateWithLifecycle()

    val inviteCode by viewModel.inviteCode.collectAsStateWithLifecycle()
    var partnerCode by remember { mutableStateOf("") }

    BaseView(
        navController = navController,
        currentRoute = Nav.Pair.route,
        background = MyBeige,
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                DubleeWidget()

                MyText(
                    text = "Настройки пары",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(horizontal = 32.dp)
                        .padding(bottom = 96.dp)
                )

                if (user.pairId == null) {
                    MyText(
                        text = "Ваш код: $inviteCode"
                    )
                    MyTextField(
                        modifier = Modifier
                            .width(256.dp)
                            .height(160.dp),
                        value = partnerCode,
                        onValueChange = { partnerCode = it },
                        prefix = "Код партнера",
                        backgroundColor = MyCream,
                    )
                    MyButton(
                        onClick = {
                            viewModel.joinPair(partnerCode)
                        },
                        text = "Пригласить",
                        backgroundColor = MyGreen,
                        modifier = Modifier
                            .padding(top = 64.dp)
                            .width(256.dp)
                            .height(64.dp)
                    )
                } else {
                    MyText(
                        text = "Ваша пара:"
                    )
                    PersonInfoWidget(
                        modifier = Modifier.height(160.dp),
                        text = partner.login,
                        icon = partnerIcon,
                        color = partnerColor
                    )
                    MyButton(
                        onClick = {
                            viewModel.leavePair()
                            println("=== leave v")
                        },
                        text = "Выйти из пары",
                        backgroundColor = MyRed,
                        modifier = Modifier
                            .padding(top = 64.dp)
                            .width(256.dp)
                            .height(64.dp)
                    )
                }
            }
        }
    )
}