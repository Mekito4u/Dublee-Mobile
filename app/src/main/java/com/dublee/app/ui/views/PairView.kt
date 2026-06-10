package com.dublee.app.ui.views

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dublee.app.Nav
import com.dublee.app.data.remote.services.AuthApiService
import com.dublee.app.data.remote.services.PairApiService
import com.dublee.app.data.remote.services.UserApiService
import com.dublee.app.data.repositories.PairRepository
import com.dublee.app.data.repositories.TokenRepository
import com.dublee.app.data.repositories.UserRepository
import com.dublee.app.domain.models.UserModel
import com.dublee.app.domain.providers.PairProviderImpl
import com.dublee.app.domain.providers.UserProviderImpl
import com.dublee.app.domain.usecases.PartnerSession
import com.dublee.app.domain.usecases.UserSession
import com.dublee.app.ui.viewmodels.PairViewModel
import com.dublee.app.ui.views.utils.bars.TopBar
import com.dublee.app.ui.views.utils.theme.MyBeige
import com.dublee.app.ui.views.utils.theme.MyButton
import com.dublee.app.ui.views.utils.theme.MyCream
import com.dublee.app.ui.views.utils.theme.MyGreen
import com.dublee.app.ui.views.utils.theme.MyRed
import com.dublee.app.ui.views.utils.theme.MyText
import com.dublee.app.ui.views.utils.theme.MyTextField
import com.dublee.app.ui.views.utils.widgets.DubleeWidget
import com.dublee.app.ui.views.utils.widgets.PersonInfoWidget
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun PairViewPreview() {
    PairView(
        viewModel = PairViewModel(
            userProviderImpl = UserProviderImpl(
                userRepository = UserRepository(
                    userSession = UserSession(),
                    partnerSession = PartnerSession(),
                    tokenRepository = TokenRepository(
                        context = LocalContext.current
                    ),
                    userApiService = UserApiService(),
                    authApiService = AuthApiService()
                )
            ),
            pairProviderImpl = PairProviderImpl(
                pairRepository = PairRepository(
                    pairApiService = PairApiService(),
                    userRepository = UserRepository(
                        userSession = UserSession(),
                        partnerSession = PartnerSession(),
                        tokenRepository = TokenRepository(
                            context = LocalContext.current
                        ),
                        userApiService = UserApiService(),
                        authApiService = AuthApiService()
                    )
                )
            )
        )
    )
}

@Composable
fun PairView(
    navController: NavController = rememberNavController(),
    viewModel: PairViewModel = koinViewModel(),
) {
    val partner by viewModel.partner.collectAsStateWithLifecycle()
    val hasPair = partner.id > 0

    BackHandler(enabled = partner.id < 0) {
    }

    val myCode by viewModel.myCode.collectAsStateWithLifecycle()
    var partnerCode by remember { mutableStateOf("") }
    val errorMsg by viewModel.errorMsg.collectAsStateWithLifecycle()
    val scope = rememberCoroutineScope()
    BaseView(
        navController = navController,
        currentRoute = Nav.Pair.route,
        background = MyBeige,
        isVisibleTop = true,
        top = { TopBar(navController, { scope.launch { viewModel.clearToken() } }) },
        isVisibleBottom = hasPair,
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                DubleeWidget()

                if (errorMsg != null) {
                    MyText(
                        text = errorMsg!!,
                        style = typography.titleMedium,
                        color = MyRed
                    )
                } else {
                    Spacer(modifier = Modifier.height(32.dp))
                }

                MyText(
                    text = "Настройки пары",
                    modifier = Modifier
                        .height(96.dp)
                )

                if (!hasPair) {
                    NoHavePairView(
                        myCode = myCode,
                        partnerCode = partnerCode,
                        onPartnerCodeChange = { partnerCode = it },
                        viewModel = viewModel
                    )
                } else {
                    HavePairView(
                        partner = partner,
                        viewModel = viewModel
                    )
                }
            }
        }
    )
}

@Composable
fun NoHavePairView(
    myCode: String,
    partnerCode: String,
    onPartnerCodeChange: (String) -> Unit,
    viewModel: PairViewModel,
) {
    MyText(
        text = "Ваш код пары: $myCode",
        modifier = Modifier
            .height(32.dp)
    )

    MyTextField(
        value = partnerCode,
        onValueChange = onPartnerCodeChange,
        prefix = "Код другой пары",
        backgroundColor = MyCream,
    )

    Spacer(modifier = Modifier.height(16.dp))

    MyButton(
        onClick = {
            viewModel.tryJoinPair(
                inviteCode = partnerCode,
                onSuccess = { }
            )
        },
        text = "Присоединиться",
        backgroundColor = MyGreen,
    )
}

@Composable
fun HavePairView(
    partner: UserModel,
    viewModel: PairViewModel,
) {
    MyText(
        text = "Ваша пара:",
        modifier = Modifier
            .height(32.dp)
    )

    PersonInfoWidget(
        modifier = Modifier.height(136.dp),
        text = partner.login,
        icon = viewModel.getUserIcon(partner.iconId),
        color = viewModel.getColor(partner.colorId)
    )

    MyButton(
        onClick = {
            viewModel.tryLeavePair(
                onSuccess = {
                    viewModel.viewModelScope.launch {
                        viewModel.tryCreatePair()
                        viewModel.tryGetCode()
                    }
                }
            )
        },
        text = "Выйти из пары",
        backgroundColor = MyRed,
    )
}