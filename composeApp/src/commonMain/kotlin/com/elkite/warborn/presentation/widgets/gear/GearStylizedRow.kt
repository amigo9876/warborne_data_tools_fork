package com.elkite.warborn.presentation.widgets.gear

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GearStylizedRow(
    modifier: Modifier = Modifier,
    text: String,
    composable: @Composable () -> Unit,
    rowOnClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .background(Color.Transparent)
            .border(
                width = 2.dp,
                color = Color.LightGray,
                shape = MaterialTheme.shapes.small
            ).clickable {
                rowOnClick()
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        composable()
        Spacer(Modifier.size(16.dp))
        GearStylizedText(
            text = text.capitalize(),
        )
    }
}

@Composable
fun GearStylizedText(
    modifier: Modifier = Modifier,
    text: String,
) {
    Text(
        modifier = modifier,
        text = text,
        color = Color.LightGray,
        style = MaterialTheme.typography.h6,
    )
}