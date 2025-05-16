package com.elkite.warborn.presentation.widgets.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.elkite.warborn.presentation.theme.WarborneTheme
import com.elkite.warborn.resources.Res
import com.elkite.warborn.resources.skin_image_tabBg
import org.jetbrains.compose.resources.painterResource

@Composable
fun GearStylizedCard(
    modifier: Modifier = Modifier,
    composable: @Composable () -> Unit,
    backgroundAlpha: Float = 0.1f
) {
    Card(
        modifier = modifier
            .border(
                1.dp,
                color = WarborneTheme.borderSkillColor,
            ),
    ) {
        Box(
            modifier = Modifier.wrapContentHeight()
                .background(color = WarborneTheme.textBackgroundColor) // Background color
                .paint(
                    painter = painterResource(Res.drawable.skin_image_tabBg),
                    contentScale = ContentScale.FillBounds, // Ensures the vector scales proportionally to fill the area
                    alignment = Alignment.Center,
                    alpha = backgroundAlpha
                ),
            contentAlignment = Alignment.Center,
        ) {
            composable()
        }
    }
}

@Composable
fun GearStylizedCardRow(
    modifier: Modifier = Modifier.height(64.dp),
    composable: @Composable () -> Unit,
    text: String? = null,
    onClick: () -> Unit,
) {
    GearStylizedCard(
        modifier = modifier.clickable { onClick() },
        composable = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                composable()
                text?.let {
                    Spacer(Modifier.weight(1f))
                    GearStylizedTextTitle(
                        text = text,
                        style = MaterialTheme.typography.body1
                    )
                    Spacer(Modifier.weight(1f))
                }
            }
        },
        backgroundAlpha = 0.1f
    )
}

@Composable
fun GearStylizedText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = MaterialTheme.typography.body1,
    color: Color =  WarborneTheme.textDescriptionColor,
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
        color = WarborneTheme.textDescriptionColor,
        style = style.copy(
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold
        ),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}