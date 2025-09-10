package com.elkite.warborn.presentation.widgets.card.drifter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.drifter.SupportStationBonus
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.widgets.utils.AttributeList
import com.elkite.warborn.presentation.widgets.utils.GearStylizedTextTitle

@Composable
fun DrifterSupportStationBonus(bonus: SupportStationBonus) {
    val attributes = listOf(
        bonus.supportBonus to bonus.supportBonusValue,
        bonus.supportMalus to bonus.supportMalusValue
    )
    val colors = listOf(
        WarborneColorTheme.textHealColor,
        WarborneColorTheme.textDamageColor,
    )

    Column(modifier = Modifier.fillMaxWidth()) {
        GearStylizedTextTitle(text = "Support station bonus")
        Divider(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 8.dp, bottom = 16.dp),
            color = WarborneColorTheme.borderSkillColor,
            thickness = 1.dp
        )
        AttributeList(attributes = attributes, colors = colors)
    }
}