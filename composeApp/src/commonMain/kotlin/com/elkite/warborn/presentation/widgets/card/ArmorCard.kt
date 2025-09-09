package com.elkite.warborn.presentation.widgets.card

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.ArmorSlot
import com.elkite.warborn.domain.entities.gear.BootsGear
import com.elkite.warborn.domain.entities.gear.ChestGear
import com.elkite.warborn.domain.entities.gear.HeadGear
import com.elkite.warborn.domain.entities.gear.IGear
import com.elkite.warborn.presentation.theme.spellBorder
import com.elkite.warborn.presentation.widgets.card.common.Description
import com.elkite.warborn.presentation.widgets.card.common.GearAttributes
import com.elkite.warborn.presentation.widgets.card.common.HeaderCard
import com.elkite.warborn.presentation.widgets.card.common.SpellAttributes
import com.elkite.warborn.presentation.widgets.icons.BootsGearIcon
import com.elkite.warborn.presentation.widgets.icons.ChestGearIcon
import com.elkite.warborn.presentation.widgets.icons.HeadGearIcon
import com.elkite.warborn.presentation.widgets.icons.IconType
import com.elkite.warborn.presentation.widgets.loadout.getModifierForRarity
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText

@Composable
fun ColumnScope.ArmorCard(
    gear: IGear?,
    armorSlot: ArmorSlot
) {
    val compact = remember { mutableStateOf(true) }

    if (gear == null) return

        HeaderCard(
            title = gear.gearName,
            subtitle = gear.gearSlot.name.lowercase().capitalize(),
            icon = {
                when (armorSlot)
                {
                    ArmorSlot.HEAD -> {
                        HeadGearIcon(
                            modifier = Modifier.getModifierForRarity(gear).size(64.dp),
                            headGear = gear as HeadGear,
                            iconType = IconType.ARMOR
                        )
                    }
                    ArmorSlot.CHEST -> {
                        ChestGearIcon(
                            modifier = Modifier.getModifierForRarity(gear).size(64.dp),
                            chestGear = gear as ChestGear,
                            iconType = IconType.ARMOR
                        )
                    }
                    ArmorSlot.BOOTS -> {
                        BootsGearIcon(
                            modifier = Modifier.getModifierForRarity(gear).size(64.dp),
                            bootsGear = gear as BootsGear,
                            iconType = IconType.ARMOR
                        )
                    }
                }
            }
        )
        if (!compact.value)
        {
            GearAttributes(
                gear.gearStats
            )
            Spacer(Modifier.size(32.dp))
        }

        HeaderCard(
            title = gear.spellName,
            subtitle = gear.gearName,
            icon = {
                when (armorSlot)
                {
                    ArmorSlot.HEAD -> {
                        HeadGearIcon(
                            modifier = Modifier.spellBorder().size(48.dp),
                            headGear = gear as HeadGear,
                            iconType = IconType.SKILL
                        )
                    }
                    ArmorSlot.CHEST -> {
                        ChestGearIcon(
                            modifier = Modifier.spellBorder().size(48.dp),
                            chestGear = gear as ChestGear,
                            iconType = IconType.SKILL
                        )
                    }
                    ArmorSlot.BOOTS -> {
                        BootsGearIcon(
                            modifier = Modifier.spellBorder().size(48.dp),
                            bootsGear = gear as BootsGear,
                            iconType = IconType.SKILL
                        )
                    }
                }
            }
        )
            SpellAttributes(
                manaCost = gear.manaCost,
                cooldown = gear.cooldown,
                range = gear.castingRange,
            )
            Spacer(Modifier.size(32.dp))
            Description(gear.description)
        Spacer(Modifier.size(16.dp))
        if (!compact.value)
            GearStylizedText(
                text = "Skill available at ${gear.tierUnlock.name} and above.",
                maxLines = 2,
                style = MaterialTheme.typography.caption.copy(
                    fontWeight = FontWeight.ExtraLight,
                ),
            )
}