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
import com.elkite.warborn.domain.entities.gear.WeaponGear
import com.elkite.warborn.domain.entities.loadout.SelectedLoadoutType
import com.elkite.warborn.presentation.theme.getRarityBorder
import com.elkite.warborn.presentation.theme.spellBorder
import com.elkite.warborn.presentation.widgets.card.common.Description
import com.elkite.warborn.presentation.widgets.card.common.GearAttributes
import com.elkite.warborn.presentation.widgets.card.common.HeaderCard
import com.elkite.warborn.presentation.widgets.card.common.SpellAttributes
import com.elkite.warborn.presentation.widgets.icons.WeaponGearIcon
import com.elkite.warborn.presentation.widgets.icons.WeaponSkillIcon
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText

@Composable
fun ColumnScope.WeaponCard(
    weaponGear: WeaponGear?,
    selectedLoadoutType: SelectedLoadoutType
) {
    val compact = remember { mutableStateOf(true) }

    if (weaponGear == null) return

    HeaderCard(
        title = weaponGear.gearName,
        subtitle = weaponGear.weaponType.name.lowercase().capitalize(),
        icon = {
            WeaponGearIcon(
                modifier = Modifier.getRarityBorder(weaponGear.rarity).size(64.dp),
                weaponGear = weaponGear
            )
        }
    )
    if (!compact.value) {
        GearAttributes(
            weaponGear.gearStats
        )
        Spacer(Modifier.size(32.dp))
    }

    val currentSpell = when (selectedLoadoutType) {
        SelectedLoadoutType.WEAPON -> weaponGear
        SelectedLoadoutType.PASSIVE -> weaponGear.passiveSpell
        SelectedLoadoutType.BASIC_ATTACK -> weaponGear.activeBasicSpell ?: weaponGear.basicSpells.first()
        SelectedLoadoutType.COMMON_SKILL -> weaponGear.activeCommonSpell ?: weaponGear.commonSpells.first()
        else -> weaponGear
    }

    HeaderCard(
        title = currentSpell.spellName,
        subtitle = weaponGear.gearName,
        icon = {
            WeaponSkillIcon(
                modifier = Modifier.spellBorder().size(48.dp),
                weaponType = weaponGear.weaponType,
                spell = currentSpell
            )
        }
    )
    SpellAttributes(
        manaCost = currentSpell.manaCost,
        cooldown = currentSpell.cooldown,
        range = currentSpell.castingRange,
    )
    Spacer(Modifier.size(32.dp))
    Description(currentSpell.description)
    Spacer(Modifier.size(16.dp))
    if (!compact.value)
        GearStylizedText(
            text = "Skill available at ${currentSpell.tierUnlock.name} and above.",
            maxLines = 2,
            style = MaterialTheme.typography.caption.copy(
                fontWeight = FontWeight.ExtraLight,
            ),
        )
}