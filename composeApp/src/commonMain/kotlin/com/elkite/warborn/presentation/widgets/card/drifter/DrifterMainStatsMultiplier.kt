package com.elkite.warborn.presentation.widgets.card.drifter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.elkite.warborn.domain.entities.drifter.BaseStats
import com.elkite.warborn.domain.entities.drifter.Drifter
import com.elkite.warborn.domain.entities.drifter.DrifterMainStatsMultiplier
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.widgets.card.common.CardDivider
import com.elkite.warborn.presentation.widgets.utils.AttributeList
import com.elkite.warborn.presentation.widgets.utils.GearStylizedTextTitle

@Composable
fun DrifterMainStatsMultiplier(drifter: DrifterMainStatsMultiplier) {
    val attributes = listOf(
        "Strength: " to drifter.strBonus,
        "Agility: " to drifter.dexBonus,
        "Intelligence: " to drifter.intBonus
    )
    val colors = listOf(
        WarborneColorTheme.strengthColor,
        WarborneColorTheme.dexterityColor,
        WarborneColorTheme.intelligenceColor
    )

    Column(modifier = Modifier.fillMaxWidth()) {
        GearStylizedTextTitle(text = "Stats multiplier")
        CardDivider()
        AttributeList(attributes = attributes, colors = colors)
    }
}

@Composable
fun DrifterBaseStats(drifter: BaseStats) {
    val attributes = listOf(
        "Strength: " to drifter.str,
        "Agility: " to drifter.dex,
        "Intelligence: " to drifter.int
    )
    val colors = listOf(
        WarborneColorTheme.strengthColor,
        WarborneColorTheme.dexterityColor,
        WarborneColorTheme.intelligenceColor
    )

    Column(modifier = Modifier.fillMaxWidth()) {
        GearStylizedTextTitle(text = "Base stats")
        CardDivider()
        AttributeList(attributes = attributes, colors = colors)
    }
}