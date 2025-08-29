package com.elkite.warborn.presentation.widgets.spell

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.domain.entities.gear.spell.Spell
import com.elkite.warborn.domain.entities.gear.spell.Stats
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.widgets.balance.BalanceIcon
import com.elkite.warborn.presentation.widgets.gear.ArmorImage
import com.elkite.warborn.presentation.widgets.utils.AttributeList
import com.elkite.warborn.presentation.widgets.utils.GearStylizedCard
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText
import com.elkite.warborn.presentation.widgets.utils.GearStylizedTextTitle
import com.elkite.warborn.presentation.widgets.utils.MoreDetails
import com.elkite.warborn.presentation.widgets.utils.MultiPatternHighlightedText


@Composable
fun SpellCard(
    modifier: Modifier = Modifier,
    onSpellClick: (Spell) -> Unit,
    isCompact: Boolean,
    spell: Spell
) {
    GearStylizedCard(
        modifier = modifier.clickable { onSpellClick(spell) },
        composable = @Composable { SpellCardContent(spell, isCompact) },
    )
}

@Composable
fun SpellCardContent(
    spell: Spell,
    isCompact: Boolean
) {
    Column(
        modifier = Modifier.wrapContentSize().padding(vertical = 16.dp, horizontal = 16.dp)
    ) {
        if (!spell.gearName.isNullOrEmpty() && spell.associatedGearType != GearType.DRIFTER) {
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Start,
            ) {
                ArmorImage(
                    gearName = spell.gearName,
                    gearType = spell.associatedGearType,
                    rarity = spell.rarity
                )
                Spacer(Modifier.size(16.dp))
                Column {
                    GearStylizedTextTitle(text = spell.gearName)
                    GearStylizedText(
                        text = spell.associatedGearType.name.lowercase().capitalize(),
                        style = MaterialTheme.typography.caption.copy(
                            fontWeight = FontWeight.ExtraLight,
                        ),
                    )
                }
            }
            Divider(
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp, bottom = 16.dp),
                color = WarborneColorTheme.borderSkillColor,
                thickness = 1.dp
            )
            if (!isCompact) {
                SpellStats(stats = spell.stats)
                Spacer(Modifier.size(32.dp))
            }
        }
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start,
        ) {
            SpellIcon(
                Modifier.size(64.dp).border(
                    1.dp,
                    color = WarborneColorTheme.borderSkillColor,
                ), gearType = spell.associatedGearType, spellType = spell.type, id = spell.gameId
            )
            Spacer(Modifier.size(16.dp))
            Column {
                GearStylizedTextTitle(text = spell.name)
                if (!spell.gearName.isNullOrEmpty())
                    GearStylizedText(
                        text = spell.gearName,
                        style = MaterialTheme.typography.caption.copy(
                            fontWeight = FontWeight.ExtraLight,
                        ),
                    ) else {
                    GearStylizedText(
                        text = spell.associatedGearType.name.lowercase().capitalize(),
                        style = MaterialTheme.typography.caption.copy(
                            fontWeight = FontWeight.ExtraLight,
                        ),
                    )
                }
            }
        }
        Divider(
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp, bottom = 16.dp),
            color = WarborneColorTheme.borderSkillColor,
            thickness = 1.dp
        )
        SpellAttributes(spell)
        Spacer(Modifier.size(16.dp))
        MultiPatternHighlightedText(
            baseTextStyle = MaterialTheme.typography.body1.copy(color = WarborneColorTheme.textDescriptionColor)
                .copy(
                    fontFamily = FontFamily.Monospace
                ),
            text = spell.description,
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
        Spacer(Modifier.size(16.dp))
        Spacer(Modifier.size(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            ) {
            if (!spell.gearName.isNullOrEmpty() && spell.associatedGearType != GearType.DRIFTER && !isCompact) {
                ArmorImage(
                    gearName = spell.gearName,
                    gearType = spell.associatedGearType,
                    rarity = spell.rarity
                )
                Spacer(Modifier.size(16.dp))
            }
            if (!isCompact)
                GearStylizedText(
                    text = if (spell.gearName.isNullOrEmpty()) "Skill available at ${spell.requiredGearLevel.textValue} and above."
                    else "Skill available at ${spell.requiredGearLevel.textValue} and above for ${spell.gearName}",
                    maxLines = 2,
                    style = MaterialTheme.typography.caption.copy(
                        fontWeight = FontWeight.ExtraLight,
                    ),
                )
        }
        SpellBalance(spell, isCompact)
    }
}

@Composable
private fun SpellBalance(spell: Spell, isCompact: Boolean) {
    if (spell.balance.lastUpdate.isNotEmpty() && !isCompact) {
        Spacer(Modifier.size(32.dp))
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start,
        ) {
            BalanceIcon(
                balanceStatus = spell.balance.status
            )
            GearStylizedText(
                text = "Latest changes on patch: ${spell.balance.lastUpdate}",
            )
        }
        Divider(
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp, bottom = 16.dp),
            color = WarborneColorTheme.borderSkillColor,
            thickness = 1.dp
        )
        GearStylizedText(
            text = spell.balance.changes,
            maxLines = Int.MAX_VALUE
        )
    }
}

@Composable
fun SpellAttributes(spell: Spell) {
    val attributes = mutableListOf<Pair<String, String>>()

    if (spell.manaCost.isNotEmpty()) {
        attributes.add("Mana: " to spell.manaCost)
    }
    if (spell.cooldown.isNotEmpty()) {
        attributes.add("Cooldown: " to "${spell.cooldown}s")
    }
    if (spell.castingRange.isNotEmpty()) {
        attributes.add("Range: " to "${spell.castingRange} m")
    }

    AttributeList(attributes = attributes)
}

@Composable
fun SpellStats(stats: Stats) {
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




