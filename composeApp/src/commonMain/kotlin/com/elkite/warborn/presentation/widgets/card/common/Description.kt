package com.elkite.warborn.presentation.widgets.card.common

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.widgets.utils.MultiPatternHighlightedText

@Composable
fun ColumnScope.Description(
    description: String
) {
    MultiPatternHighlightedText(
        baseTextStyle = MaterialTheme.typography.body1.copy(color = WarborneColorTheme.textDescriptionColor)
            .copy(
                fontFamily = FontFamily.Monospace
            ),
        text = description,
        patternsWithStyles = listOf(
            Regex("""\[Damage Rate: [^\]]+]""") to SpanStyle(
                color = WarborneColorTheme.textDamageColor,
                fontWeight = FontWeight.Bold
            ),
            Regex("""\[Healing Rate: [^\]]+]""") to SpanStyle(
                color = WarborneColorTheme.textHealColor,
                fontWeight = FontWeight.Bold
            ),
            Regex("""\[Target-based Max HP [^\]]+]""") to SpanStyle(
                color = WarborneColorTheme.textShieldColor,
                fontWeight = FontWeight.Bold
            )
        )
    )
}