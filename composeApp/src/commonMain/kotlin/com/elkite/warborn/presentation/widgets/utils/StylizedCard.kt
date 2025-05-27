package com.elkite.warborn.presentation.widgets.utils

import androidx.compose.foundation.border
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.elkite.warborn.presentation.theme.WarborneColorTheme

@Composable
fun GearStylizedCard(
    borderColor: Color = WarborneColorTheme.borderSkillColor,
    modifier: Modifier = Modifier,
    composable: @Composable () -> Unit,
) {
    Card(
        modifier = modifier
            .border(
                1.dp,
                borderColor,
            ),
        backgroundColor = WarborneColorTheme.textBackgroundColor.copy(
            alpha = 0.8f
        ),
    ) {
        composable()
    }
}

@Composable
fun GearStylizedText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = MaterialTheme.typography.body1,
    color: Color = WarborneColorTheme.textDescriptionColor,
    maxLines: Int = 1,
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        style = style.copy(
            fontFamily = FontFamily.Monospace
        ),
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
fun GearStylizedTextTitle(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = MaterialTheme.typography.h4,
) {
    Text(
        modifier = modifier,
        text = text,
        color = WarborneColorTheme.textDescriptionColor,
        style = style.copy(
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold
        ),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}