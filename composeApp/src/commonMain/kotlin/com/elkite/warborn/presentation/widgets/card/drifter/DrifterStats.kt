package com.elkite.warborn.presentation.widgets.card.drifter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.drifter.DrifterStats
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.widgets.utils.AttributeList
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText
import com.elkite.warborn.presentation.widgets.utils.GearStylizedTextTitle

@Composable
fun DrifterStats(stats: DrifterStats) {
    val attributes = mutableListOf<Pair<String, String>>()

    if (stats.maxHpBonus.isNotEmpty()) {
        attributes.add("Max HP Bonus: " to stats.maxHpBonus)
    }
    if (stats.maxMpBonus.isNotEmpty()) {
        attributes.add("Max MP Bonus: " to stats.maxMpBonus)
    }
    if (stats.attackSpeedBonus.isNotEmpty()) {
        attributes.add("Attack Speed Bonus: " to stats.attackSpeedBonus)
    }
    if (stats.castingSpeedBonus.isNotEmpty()) {
        attributes.add("Casting Speed Bonus: " to stats.castingSpeedBonus)
    }
    if (stats.skillCooldownRateBonus.isNotEmpty()) {
        attributes.add("Skill Cooldown Rate Bonus: " to stats.skillCooldownRateBonus)
    }
    if (stats.physicalDamageBonus.isNotEmpty()) {
        attributes.add("Physical Damage Bonus: " to stats.physicalDamageBonus)
    }
    if (stats.magicDamageBonus.isNotEmpty()) {
        attributes.add("Magic Damage Bonus: " to stats.magicDamageBonus)
    }
    if (stats.healingBonus.isNotEmpty()) {
        attributes.add("Healing Bonus: " to stats.healingBonus)
    }
    if (stats.damageBonusPvE.isNotEmpty()) {
        attributes.add("Damage Bonus (PvE): " to stats.damageBonusPvE)
    }
    if (stats.criticalRate.isNotEmpty()) {
        attributes.add("Critical Rate: " to stats.criticalRate)
    }
    if (stats.tenacityPenetration.isNotEmpty()) {
        attributes.add("Tenacity Penetration" to stats.tenacityPenetration)
    }
    if (stats.armor.isNotEmpty()) {
        attributes.add("Armor: " to stats.armor)
    }
    if (stats.magicResistance.isNotEmpty()) {
        attributes.add("Magic Resistance: " to stats.magicResistance)
    }
    if (stats.block.isNotEmpty()) {
        attributes.add("Block: " to stats.block)
    }
    if (stats.controlResistance.isNotEmpty()) {
        attributes.add("Control Resistance: " to stats.controlResistance)
    }


    if (attributes.isNotEmpty())
        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer(Modifier.size(16.dp))
            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                GearStylizedTextTitle(text = "Stats")
                Spacer(Modifier.weight(1f))
                GearStylizedText(
                    text = "All stats are based on Mastery Level 1",
                    style = MaterialTheme.typography.caption.copy(
                        fontWeight = FontWeight.ExtraLight,
                        color = WarborneColorTheme.textDescriptionColor
                    ), modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            Divider(
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 8.dp, bottom = 16.dp),
                color = WarborneColorTheme.borderSkillColor,
                thickness = 1.dp
            )
            AttributeList(attributes = attributes)
            Spacer(Modifier.size(16.dp))
        }
}