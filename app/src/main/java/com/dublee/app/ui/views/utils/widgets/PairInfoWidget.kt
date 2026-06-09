package com.dublee.app.ui.views.utils.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.dublee.app.ui.views.utils.theme.MyText

@Composable
fun PairInfoWidget(
    userLogin: String,
    userIcon: ImageVector,
    userColor: Color,
    partnerLogin: String? = null,
    partnerIcon: ImageVector? = null,
    partnerColor: Color? = null,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom
    ) {
        PersonInfoWidget(
            text = userLogin,
            icon = userIcon,
            color = userColor
        )

        if (partnerLogin != null) {
            MyText(
                modifier = Modifier.padding(bottom = 4.dp),
                text = "и",
            )
            PersonInfoWidget(
                text = partnerLogin,
                icon = partnerIcon!!,
                color = partnerColor!!
            )
        }
    }
}