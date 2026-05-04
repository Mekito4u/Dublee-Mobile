package com.app.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.ui.theme.MyBlue
import com.app.ui.theme.MyBrown
import com.app.ui.theme.MyCream
import com.app.ui.theme.MyCyan

@Preview
@Composable
fun CategoryWidget(
    title: String = "title",
    description: String = "description",
    imageUrl: String = "\uD83C\uDFA8",
    isSelected: Boolean = false,
    onClicked: () -> Unit = {}
) {
    Surface(
        shape = shapes.large,
        modifier = Modifier.width(256.dp),
        color = if (isSelected) MyCream else MyBrown,
        onClick = onClicked
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = imageUrl,
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = title,
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center
            )
            Text(
                text = description,
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}