package com.elkite.warborn.presentation.widgets.search

import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.data.WeaponType
import com.elkite.warborn.domain.entities.drifter.Drifter
import com.elkite.warborn.domain.entities.gear.BootsGear
import com.elkite.warborn.domain.entities.gear.ChestGear
import com.elkite.warborn.domain.entities.gear.GearSlot
import com.elkite.warborn.domain.entities.gear.HeadGear
import com.elkite.warborn.domain.entities.gear.IGear
import com.elkite.warborn.domain.entities.mod.IMod
import com.elkite.warborn.domain.entities.spells.ISpell
import com.elkite.warborn.domain.entities.spells.SpellType
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.theme.spellBorder
import com.elkite.warborn.presentation.widgets.card.common.CardContainer
import com.elkite.warborn.presentation.widgets.card.common.Description
import com.elkite.warborn.presentation.widgets.card.common.HeaderCard
import com.elkite.warborn.presentation.widgets.icons.BootsGearIcon
import com.elkite.warborn.presentation.widgets.icons.ChestGearIcon
import com.elkite.warborn.presentation.widgets.icons.DrifterPassiveIcon
import com.elkite.warborn.presentation.widgets.icons.DrifterSpellIcon
import com.elkite.warborn.presentation.widgets.icons.HeadGearIcon
import com.elkite.warborn.presentation.widgets.icons.IconType
import com.elkite.warborn.presentation.widgets.icons.ModIcon
import com.elkite.warborn.presentation.widgets.icons.WeaponSkillIcon
import com.elkite.warborn.presentation.widgets.utils.MultiPatternHighlightedText

@Composable
fun SearchDrifterCard(
    spell: ISpell,
    drifter: Drifter,
) {
    CardContainer(modifier = Modifier) {
        HeaderCard(
            title = spell.spellName,
            subtitle = drifter.name,
            icon = {
                if (spell.type == SpellType.passive)
                    DrifterPassiveIcon(
                        modifier = Modifier.size(64.dp),
                        drifter = drifter
                    )
                else
                    DrifterSpellIcon(
                        modifier = Modifier.size(64.dp),
                        drifter = drifter,
                    )
            }
        )
        Description(spell.description)
    }
}

@Composable
fun SearchArmorCard(
    gearSlot: GearSlot,
    gear: IGear
) {
    CardContainer(modifier = Modifier) {
        HeaderCard(
            title = gear.spellName,
            subtitle = gearSlot.name,
            icon = {
                when (gearSlot) {
                    GearSlot.HEAD -> HeadGearIcon(
                        modifier = Modifier.size(64.dp),
                        headGear = gear as? HeadGear,
                        iconType = IconType.SKILL
                    )

                    GearSlot.CHEST -> ChestGearIcon(
                        modifier = Modifier.size(64.dp),
                        chestGear = gear as? ChestGear,
                        iconType = IconType.SKILL
                    )

                    GearSlot.BOOTS -> BootsGearIcon(
                        modifier = Modifier.size(64.dp),
                        bootsGear = gear as? BootsGear,
                        iconType = IconType.SKILL
                    )

                    else -> {}
                }
            }
        )
        Description(gear.description)
    }
}


@Composable
fun SearchWeaponCard(
    weaponType: WeaponType,
    spell: ISpell
) {
    CardContainer(modifier = Modifier) {
        HeaderCard(
            title = spell.spellName,
            subtitle = weaponType.name,
            icon = {
                WeaponSkillIcon(
                    modifier = Modifier.spellBorder().size(48.dp),
                    weaponType = weaponType,
                    spell = spell
                )
            }
        )
        Description(spell.description)
    }
}

@Composable
fun SearchMod(
    modifier: Modifier,
    mod: IMod
) {
    CardContainer(modifier = Modifier) {
        HeaderCard(
            title = mod.name,
            subtitle = mod.slot.name.lowercase().capitalize(),
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
            )
        )
    }
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