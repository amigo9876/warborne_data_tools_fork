package com.elkite.warborn.presentation.widgets.card.drifter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.drifter.DrifterMainStatsMultiplier
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.widgets.utils.AttributeList

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

    Column(modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth()) {
        AttributeList(attributes = attributes, colors = colors)
    }
}