package com.elkite.warborn.presentation.widgets.loadout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.LoadoutType
import com.elkite.warborn.domain.entities.gear.spell.Spell
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.theme.WarborneColorTheme.borderSkillColor
import com.elkite.warborn.presentation.theme.spellBorderPassive
import com.elkite.warborn.presentation.widgets.spell.SpellIcon
import com.elkite.warborn.presentation.widgets.tooltip.TooltipBox

@Composable
fun LoadoutSpellIconWithTooltip(
    isSelected: Boolean,
    loadoutType: LoadoutType,
    tooltipState: com.elkite.warborn.presentation.widgets.tooltip.TooltipState,
    spell: Spell?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (spell != null) {
        TooltipBox(
            tooltipState = tooltipState,
            gear = spell,
            modifier = modifier
        ) {
            LoadoutSpellIcon(
                isSelected = isSelected,
                loadoutType = loadoutType,
                spell = spell,
                onClick = onClick,
                modifier = Modifier.fillMaxSize()
            )
        }
    } else {
        LoadoutSpellIcon(
            isSelected = isSelected,
            loadoutType = loadoutType,
            spell = null,
            onClick = onClick,
            modifier = modifier
        )
    }
}

@Composable
fun LoadoutSpellIcon(
    loadoutType: LoadoutType,
    onClick: () -> Unit,
    spell: Spell?,
    isSelected: Boolean = false,
    modifier: Modifier = Modifier.size(64.dp),
) {
    val transformModifier = when (loadoutType) {
        LoadoutType.PASSIVE -> modifier
            .spellBorderPassive(
                isSelected = isSelected,
            )
            .background(Color.Black)
            .clickable {
                onClick()
            }

        else -> modifier
            .background(Color.Black)
            .let {
                if (isSelected) {
                    it.border(
                        width = 3.dp,
                        brush = WarborneColorTheme.legendaryBrush,
                        shape = RectangleShape
                    )
                } else {
                    it.border(
                        width = 2.dp,
                        color = borderSkillColor,
                    )
                }
            }
            .clickable {
                onClick()
            }
    }

    spell?.let {
        SpellIcon(
            modifier = transformModifier,
            gearType = spell.associatedGearType,
            spellType = spell.type,
            id = spell.gameId
        )
    } ?: Box(
        modifier = transformModifier
            .clickable {
                onClick()
            }
    )
}