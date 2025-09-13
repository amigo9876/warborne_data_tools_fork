package com.elkite.warborn.presentation.widgets.card

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.mod.IMod
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.widgets.card.common.HeaderCard
import com.elkite.warborn.presentation.widgets.icons.ModIcon
import com.elkite.warborn.presentation.widgets.utils.MultiPatternHighlightedText

@Composable
fun ColumnScope.ModCard(
    modifier: Modifier = Modifier,
    mod: IMod?
) {
    if (mod == null) return
        HeaderCard(
            title = mod.name,
            subtitle = mod.slot.name.lowercase().capitalize(),
            rarity = mod.rarity,
            icon = {
                ModIcon(
                    modGameId = mod.iconName,
                    modifier = modifier.size(64.dp),
                    modType = mod.type
                )
            }
        )
    val description = mod.formatDescription()
    MultiPatternHighlightedText(
        baseTextStyle = MaterialTheme.typography.body1.copy(color = WarborneColorTheme.textDescriptionColor)
            .copy(
                fontFamily = FontFamily.Monospace
            ),
        text = description,
        patternsWithStyles = listOf(
            Regex("""\[Damage Rate: [^\]]+]]""") to SpanStyle(
                color = WarborneColorTheme.textDamageColor,
                fontWeight = FontWeight.Bold
            ),
            Regex("""\[Healing Rate: [^\]]+]]""") to SpanStyle(
                color = WarborneColorTheme.textHealColor,
                fontWeight = FontWeight.Bold
            ),
            Regex("""\[Target-based Max HP [^\]]+]]""") to SpanStyle(
                color = WarborneColorTheme.textShieldColor,
                fontWeight = FontWeight.Bold
            ),
            Regex("""\[\s*[^a-zA-Z\]]*](?!])""") to SpanStyle(
                fontWeight = FontWeight.Bold,
                color = WarborneColorTheme.legendaryBorderMidColor
            )
        ))
    }


private fun IMod.formatDescription(): String {
    var formattedDescription = this.description
    this.arguments.forEach { (key, value) ->
        if (value.isNotEmpty()) {
            formattedDescription = formattedDescription.replace("%$key%", value)
        }
    }
    return formattedDescription
}