package com.elkite.warborn.presentation.widgets.drifter

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.drifter.Drifter
import com.elkite.warborn.domain.entities.gear.drifter.DrifterStats
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.widgets.spell.SpellCardContent
import com.elkite.warborn.presentation.widgets.utils.AttributeList
import com.elkite.warborn.presentation.widgets.utils.GearStylizedCard
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText
import com.elkite.warborn.presentation.widgets.utils.GearStylizedTextTitle
import com.elkite.warborn.presentation.widgets.utils.MoreDetails


@Composable
fun DrifterCard(
    modifier: Modifier = Modifier,
    drifter: Drifter,
    onDrifterClick: (Drifter) -> Unit,
    isCompact: Boolean = false,
) {

    GearStylizedCard(
        modifier = modifier.clickable { onDrifterClick(drifter) },
        composable = @Composable { DrifterCardContent(drifter, isCompact) },
    )
}

@Composable
private fun DrifterCardContent(
    drifter: Drifter,
    isCompact: Boolean = false,
) {
    Column(
        modifier = Modifier.wrapContentSize().padding(vertical = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            DrifterIcon(
                Modifier.size(64.dp).border(
                    width = 1.dp,
                    brush = WarborneColorTheme.legendaryBrush,
                    shape = RectangleShape
                ), drifterId = drifter.gameId
            )
            Spacer(Modifier.size(16.dp))
            GearStylizedTextTitle(text = drifter.name)
        }
        Divider(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 8.dp, bottom = 16.dp, start = 16.dp, end = 16.dp),
            color = WarborneColorTheme.borderSkillColor,
            thickness = 1.dp
        )
        if (!isCompact) {
            DrifterBonusStats(drifter)
            DrifterStats(drifter.drifterStats)
            LinksCard(drifter)
            SupportCard(drifter)
        }
        SpellCardContent(
            spell = drifter.spell,
            isCompact = isCompact,
        )
        SpellCardContent(
            spell = drifter.passive,
            isCompact = isCompact,
        )
    }
}

@Composable
private fun LinksCard(drifter: Drifter) {
    Column(modifier = Modifier.fillMaxWidth().padding(top = 16.dp, start = 16.dp, end = 16.dp)) {
        GearStylizedTextTitle(text = "Links")
        Divider(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 8.dp, bottom = 16.dp),
            color = WarborneColorTheme.borderSkillColor,
            thickness = 1.dp
        )
        drifter.links.forEach {
            Column {
                GearStylizedTextTitle(
                    text = it.name,
                    style = MaterialTheme.typography.h5
                )
                Spacer(Modifier.size(8.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    it.driftersId.forEach {
                        DrifterIcon(
                            drifterId = it
                        )
                    }
                }
                Spacer(Modifier.size(8.dp))
                GearStylizedText(
                    text = it.description,
                    color = WarborneColorTheme.textDescriptionColor,
                    style = MaterialTheme.typography.body1
                )
                Spacer(Modifier.size(16.dp))
            }
        }
    }
}

@Composable
private fun SupportCard(drifter: Drifter) {
    val attributes = listOf(
        drifter.supportBonus to drifter.supportBonusValue,
        drifter.supportMalus to drifter.supportMalusValue
    )
    val colors = listOf(
        WarborneColorTheme.textHealColor,
        WarborneColorTheme.textDamageColor,
    )

    Column(modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth()) {
        GearStylizedTextTitle(text = "Support")
        Divider(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 8.dp, bottom = 16.dp),
            color = WarborneColorTheme.borderSkillColor,
            thickness = 1.dp
        )
        AttributeList(attributes = attributes, colors = colors)
    }
}

@Composable
private fun DrifterBonusStats(drifter: Drifter) {
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
        Column(modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth()) {
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
        }
}


