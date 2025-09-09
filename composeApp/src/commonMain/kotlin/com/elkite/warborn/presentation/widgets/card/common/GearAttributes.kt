package com.elkite.warborn.presentation.widgets.card.common

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.GearStats
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.widgets.utils.AttributeList
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText

@Composable
fun ColumnScope.GearAttributes(stats: GearStats) {
    val attributes = mutableListOf<Pair<String, String>>()

    if (!stats.bonusDamage.isNullOrEmpty()) {
        attributes.add("Damage & Heal bonus: " to "${stats.bonusDamage}%")
    }
    if (!stats.attackPower.isNullOrEmpty()) {
        attributes.add("Attack Power: " to stats.attackPower)
    }
    if (!stats.hp.isNullOrEmpty()) {
        attributes.add("HP: " to stats.hp)
    }
    if (!stats.armor.isNullOrEmpty()) {
        attributes.add("Armor: " to stats.armor)
    }
    if (!stats.magicResist.isNullOrEmpty()) {
        attributes.add("Magic resistance: " to stats.magicResist)
    }
    if (!stats.tenacity.isNullOrEmpty()) {
        attributes.add("Tenacity penetration: " to "${stats.tenacity}%")
    }
    if (!stats.mpRecovery.isNullOrEmpty()) {
        attributes.add("Mana recovery bonus: " to "${stats.mpRecovery}%")
    }
    if (!stats.ms.isNullOrEmpty()) {
        attributes.add("Movement Speed: " to "${stats.ms} m/s")
    }
    if (!stats.attackSpeed.isNullOrEmpty()) {
        attributes.add("Attack Speed: " to "${stats.attackSpeed}/s")
    }

    if (attributes.isNotEmpty())
        GearStylizedText(
            text = "All stats are based on Tier IV",
            style = MaterialTheme.typography.caption.copy(
                fontWeight = FontWeight.ExtraLight,
                color = WarborneColorTheme.textDescriptionColor
            ), modifier = Modifier.padding(bottom = 8.dp)
        )
    AttributeList(attributes = attributes)
}