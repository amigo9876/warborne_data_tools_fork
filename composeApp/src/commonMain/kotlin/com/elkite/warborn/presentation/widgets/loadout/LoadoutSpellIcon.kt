package com.elkite.warborn.presentation.widgets.loadout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.data.WeaponType
import com.elkite.warborn.domain.entities.drifter.Drifter
import com.elkite.warborn.domain.entities.gear.BootsGear
import com.elkite.warborn.domain.entities.gear.ChestGear
import com.elkite.warborn.domain.entities.gear.HeadGear
import com.elkite.warborn.domain.entities.gear.WeaponGear
import com.elkite.warborn.domain.entities.spells.BasicSpell
import com.elkite.warborn.domain.entities.spells.CommonSpell
import com.elkite.warborn.domain.entities.spells.PassiveSpell
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.theme.WarborneColorTheme.borderSkillColor
import com.elkite.warborn.presentation.theme.spellBorderPassive
import com.elkite.warborn.presentation.widgets.icons.BootsGearIcon
import com.elkite.warborn.presentation.widgets.icons.ChestGearIcon
import com.elkite.warborn.presentation.widgets.icons.DrifterPassiveIcon
import com.elkite.warborn.presentation.widgets.icons.DrifterSpellIcon
import com.elkite.warborn.presentation.widgets.icons.HeadGearIcon
import com.elkite.warborn.presentation.widgets.icons.IconType
import com.elkite.warborn.presentation.widgets.icons.WeaponSkillIcon

@Composable
fun LoadoutHeadGearSkillIcon(
    headGear: HeadGear?,
    onClick: () -> Unit,
    isSelected: Boolean,
    modifier: Modifier = Modifier.size(48.dp),
) {
    HeadGearIcon(
        modifier = modifier
            .spellBorderPassive(
                isSelected = isSelected,
            )
            .background(Color.Black)
            .clickable {
                onClick()
            },
        headGear = headGear,
        iconType = IconType.SKILL,
    )
}

@Composable
fun LoadoutChestGearSkillIcon(
    chestGear: ChestGear?,
    onClick: () -> Unit,
    isSelected: Boolean,
    modifier: Modifier = Modifier.size(48.dp),
) {
    ChestGearIcon(
        modifier = modifier
            .background(Color.Black)
            .let {
                if (isSelected) {
                    it.border(
                        width = 2.dp,
                        brush = WarborneColorTheme.selectionBrush,
                        shape = RectangleShape
                    )
                } else {
                    it.border(
                        width = 1.dp,
                        color = borderSkillColor,
                    )
                }
            }
            .clickable {
                onClick()
            },
        chestGear = chestGear,
        iconType = IconType.SKILL,
    )
}

@Composable
fun LoadoutBootsGearSkillIcon(
    bootsGear: BootsGear?,
    onClick: () -> Unit,
    isSelected: Boolean,
    modifier: Modifier = Modifier.size(48.dp),
) {
    BootsGearIcon(
        modifier = modifier
            .background(Color.Black)
            .let {
                if (isSelected) {
                    it.border(
                        width = 2.dp,
                        brush = WarborneColorTheme.selectionBrush,
                        shape = RectangleShape
                    )
                } else {
                    it.border(
                        width = 1.dp,
                        color = borderSkillColor,
                    )
                }
            }
            .clickable {
                onClick()
            },
        bootsGear = bootsGear,
        iconType = IconType.SKILL,
    )
}

@Composable
fun LoadoutWeaponPassiveIcon(
    passiveSpell: PassiveSpell?,
    weaponType: WeaponType,
    onClick: () -> Unit,
    isSelected: Boolean,
    modifier: Modifier = Modifier.size(48.dp),
) {
    WeaponSkillIcon(
        modifier = modifier
            .spellBorderPassive(
                isSelected = isSelected,
            )
            .background(Color.Black)
            .clickable {
                onClick()
            },
       weaponType = weaponType, spell = passiveSpell,
    )
}

@Composable
fun LoadoutWeaponBasicIcon(
    basicSpell: BasicSpell?,
    onClick: () -> Unit,
    isSelected: Boolean,
    weaponType: WeaponType,
    modifier: Modifier = Modifier.size(48.dp),
) {
    WeaponSkillIcon(
        modifier = modifier
            .background(Color.Black)
            .let {
                if (isSelected) {
                    it.border(
                        width = 2.dp,
                        brush = WarborneColorTheme.selectionBrush,
                        shape = RectangleShape
                    )
                } else {
                    it.border(
                        width = 1.dp,
                        color = borderSkillColor,
                    )
                }
            }
            .clickable {
                onClick()
            },
        weaponType = weaponType,
        spell = basicSpell,
    )
}

@Composable
fun LoadoutWeaponCommonIcon(
    commonSpell: CommonSpell?,
    onClick: () -> Unit,
    isSelected: Boolean,
    weaponType: WeaponType,
    modifier: Modifier = Modifier.size(48.dp),
) {
    WeaponSkillIcon(
        modifier = modifier
            .background(Color.Black)
            .let {
                if (isSelected) {
                    it.border(
                        width = 2.dp,
                        brush = WarborneColorTheme.selectionBrush,
                        shape = RectangleShape
                    )
                } else {
                    it.border(
                        width = 1.dp,
                        color = borderSkillColor,
                    )
                }
            }
            .clickable {
                onClick()
            },
        weaponType = weaponType,
        spell = commonSpell,
    )
}

@Composable
fun LoadoutWeaponSkillIcon(
    spell: WeaponGear?,
    weaponType: WeaponType,
    onClick: () -> Unit,
    isSelected: Boolean,
    modifier: Modifier = Modifier.size(48.dp),
) {
    WeaponSkillIcon(
        modifier = modifier
            .background(Color.Black)
            .let {
                if (isSelected) {
                    it.border(
                        width = 2.dp,
                        brush = WarborneColorTheme.selectionBrush,
                        shape = RectangleShape
                    )
                } else {
                    it.border(
                        width = 1.dp,
                        color = borderSkillColor,
                    )
                }
            }
            .clickable {
                onClick()
            },
        weaponType = weaponType,
        spell = spell,
    )
}

@Composable
fun LoadoutDrifterSkillIcon(
    drifter: Drifter?,
    onClick: () -> Unit,
    isSelected: Boolean,
    modifier: Modifier = Modifier.size(48.dp),
) {
    DrifterSpellIcon(
        modifier = modifier
            .background(Color.Black)
            .let {
                if (isSelected) {
                    it.border(
                        width = 2.dp,
                        brush = WarborneColorTheme.selectionBrush,
                        shape = RectangleShape
                    )
                } else {
                    it.border(
                        width = 1.dp,
                        color = borderSkillColor,
                    )
                }
            }
            .clickable {
                onClick()
            },
        drifter = drifter,
    )
}


@Composable
fun LoadoutDrifterPassiveIcon(
    drifter: Drifter?,
    onClick: () -> Unit,
    isSelected: Boolean,
    modifier: Modifier = Modifier.size(48.dp),
) {
    DrifterPassiveIcon(
        modifier = modifier
            .spellBorderPassive(
                isSelected = isSelected,
            )
            .background(Color.Black)
            .clickable {
                onClick()
            },
        drifter = drifter,
    )
}
