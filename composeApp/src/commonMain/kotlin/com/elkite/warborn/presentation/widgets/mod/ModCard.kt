package com.elkite.warborn.presentation.widgets.mod

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.mods.Mod
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.theme.spellBorder
import com.elkite.warborn.presentation.widgets.utils.GearStylizedCard
import com.elkite.warborn.presentation.widgets.utils.GearStylizedTextTitle
import com.elkite.warborn.presentation.widgets.utils.MultiPatternHighlightedText

@Composable
fun ModCard(
    mod: Mod,
    onModClick: (Mod) -> Unit,
) {
    GearStylizedCard(
        modifier = Modifier.clickable { onModClick(mod) },
        composable = @Composable {
            ModCardContent(mod)
        },
    )
}

@Composable
fun ModCardList(
    modifier: Modifier = Modifier,
    mods: List<Mod>,
    onModClick: (Mod) -> Unit,
) {
    Column(
        modifier = modifier.width(600.dp).background(color = Color.Transparent)
            .padding(horizontal = 16.dp),
    ) {
        mods.forEach { mod ->
            Spacer(Modifier.size(12.dp))
            ModCard(mod = mod, onModClick = onModClick)
            Spacer(Modifier.size(12.dp))
        }
    }
}

@Composable
fun ModCardContent(
    mod: Mod,
) {
    Column(
        modifier = Modifier.wrapContentSize().padding(vertical = 16.dp, horizontal = 16.dp),
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start,
        ) {
            ModImage(
                modifier = Modifier.size(64.dp).spellBorder(), mod = mod
            )
            Spacer(Modifier.size(16.dp))
            GearStylizedTextTitle(text = mod.name)
        }
        Divider(
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp, bottom = 16.dp),
            color = WarborneColorTheme.borderSkillColor,
            thickness = 1.dp
        )
        val description =
            formatDescription(description = mod.description, arguments = mod.arguments)
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

            )
        )
    }
}


fun formatDescription(description: String, arguments: List<Pair<String, String>>): String {
    var formattedDescription = description
    arguments.forEach { (key, value) ->
        if (value.isNotEmpty()) {
            formattedDescription = formattedDescription.replace("%$key%", value)
        }
    }
    return formattedDescription
}