package com.app.ui.widgets

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.ui.theme.MyBrown
import com.app.ui.theme.MyButton
import com.app.ui.theme.MyCream
import com.app.ui.theme.MyRed
import com.app.ui.theme.MyText

@Preview
@Composable
fun LikeWidget(
    categoryName: String = "Category",
    optionName: String = "option",
    time: String = "time",
    icon: ImageVector = Icons.Default.Home,
    onClicked: () -> Unit = {}
) {
    Surface(
        shape = shapes.large,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 24.dp,
                end = 24.dp,
            )
            .border(
                width = 1.dp,
                color = MyBrown,
                shape = shapes.large
            ),
        color = MyCream,
    ) {
        Column(
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    modifier = Modifier
                        .weight(0.1f)
                        .aspectRatio(1f)
                        .fillMaxSize(),
                    imageVector = icon,
                    contentDescription = "like",
                )
                MyText(
                    modifier = Modifier.weight(0.3f),
                    text = "Лайк",
                    textAlign = TextAlign.Start,
                    style = typography.headlineSmall
                )
                MyText(
                    modifier = Modifier.weight(0.6f),
                    text = time,
                    textAlign = TextAlign.End,
                    style = typography.titleMedium
                )

            }

            Row(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                MyText(
                    modifier = Modifier.weight(0.7f),
                    text = "$categoryName: $optionName",
                    textAlign = TextAlign.Start,
                    style = typography.headlineSmall
                )

                Spacer(modifier = Modifier.weight(0.1f))

                MyButton(
                    modifier = Modifier.weight(0.2f),
                    text = "-",
                    backgroundColor = MyRed,
                    contentPadding = PaddingValues(4.dp),
                    onClick = onClicked
                )
            }
        }
    }
}