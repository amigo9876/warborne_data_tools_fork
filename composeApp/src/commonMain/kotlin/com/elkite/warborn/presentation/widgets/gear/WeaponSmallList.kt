package com.elkite.warborn.presentation.widgets.gear

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.data.DataWeapons
import com.elkite.warborn.domain.entities.data.WeaponType
import com.elkite.warborn.domain.entities.gear.WeaponGear
import com.elkite.warborn.domain.entities.loadout.Loadout
import com.elkite.warborn.domain.entities.loadout.SelectedLoadoutType
import com.elkite.warborn.domain.entities.spells.SpellType
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.theme.spellBorder
import com.elkite.warborn.presentation.widgets.icons.WeaponSlotIcon
import com.elkite.warborn.presentation.widgets.loadout.LoadoutWeaponBasicIcon
import com.elkite.warborn.presentation.widgets.loadout.LoadoutWeaponCommonIcon
import com.elkite.warborn.presentation.widgets.loadout.LoadoutWeaponGearIcon
import com.elkite.warborn.presentation.widgets.loadout.LoadoutWeaponPassiveIcon
import com.elkite.warborn.presentation.widgets.loadout.LoadoutWeaponSkillIcon
import com.elkite.warborn.presentation.widgets.utils.GearStylizedCard
import com.elkite.warborn.presentation.widgets.utils.isCompact
import com.elkite.warborn.presentation.widgets.utils.isMedium

@Composable
fun WeaponSmallList(
    modifier: Modifier = Modifier,
    data: DataWeapons,
    loadout: Loadout,
    onUpdateWeapon: (SelectedLoadoutType, WeaponGear) -> Unit,
) {
    val selectedWeaponType = remember {
        when (loadout.weapon?.weaponType) {
            null -> mutableStateOf(WeaponType.sword)
            else -> mutableStateOf(loadout.weapon.weaponType)
        }
    }
    val filteredSpells by remember {
        derivedStateOf {
            when (selectedWeaponType.value) {
                WeaponType.sword -> data.sword
                WeaponType.axe -> data.axe
                WeaponType.gun -> data.gun
                WeaponType.mace -> data.mace
                WeaponType.spear -> data.spear
                WeaponType.dagger -> data.dagger
                WeaponType.bow -> data.bow
                WeaponType.nature -> data.nature
                WeaponType.fire -> data.fire
                WeaponType.frost -> data.frost
                WeaponType.curse -> data.curse
                WeaponType.holy -> data.holy
            }
        }
    }

    Column(
        modifier = modifier.wrapContentHeight().fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
    ) {
        // Weapon types
        LazyVerticalGrid(
            modifier = Modifier.fillMaxWidth().wrapContentHeight(),
            columns = GridCells.Fixed(4),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            items(WeaponType.entries) { weaponType ->
                GearStylizedCard(
                    modifier = Modifier.height(48.dp).clickable {
                        selectedWeaponType.value = weaponType
                        onUpdateWeapon(
                            SelectedLoadoutType.WEAPON,
                            let {
                                val weaponGear = filteredSpells.skills.first()
                                return@let weaponGear.copy(
                                    activeBasicSpell = weaponGear.basicSpells.first(),
                                    activeCommonSpell = weaponGear.commonSpells.first(),
                                )
                            }
                        )
                    },
                    borderColor = if (loadout.weapon?.weaponType == weaponType) {
                        WarborneColorTheme.legendaryBorderStartColor
                    } else {
                        WarborneColorTheme.borderSkillColor
                    },
                    composable = {
                        WeaponSlotIcon(
                            modifier = Modifier.size(48.dp),
                            weaponType = weaponType
                        )
                    },
                )
            }
        }

        // Weapon Skills
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(filteredSpells.skills) { spell ->
                LoadoutWeaponGearIcon(
                    weaponGear = spell,
                    modifier = Modifier.size(if (isCompact()) 48.dp else 64.dp),
                    isSelected = false,
                    onClick = {
                        onUpdateWeapon(
                            SelectedLoadoutType.WEAPON,
                            spell.copy(
                                activeBasicSpell = loadout.weapon?.activeBasicSpell
                                    ?: spell.basicSpells.first(),
                                activeCommonSpell = loadout.weapon?.activeCommonSpell
                                    ?: spell.commonSpells.first()
                            )
                        )
                    })
            }
        }
        // Weapon basic
        WeaponSkillRowContainer(
            selectedLoadoutType = loadout.selectedLoadoutType,
            spellType = SpellType.basic,
            row = {
                LazyRow(
                    modifier = Modifier.padding(vertical = 4.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items(filteredSpells.basicSpells) {
                        LoadoutWeaponBasicIcon(
                            modifier = if (isCompact() || isMedium())
                                Modifier.size(32.dp) else Modifier.size(64.dp),
                            basicSpell = it,
                            isSelected = loadout.weapon?.activeBasicSpell?.spellId == it.spellId && loadout.selectedLoadoutType == SelectedLoadoutType.BASIC_ATTACK,
                            weaponType = selectedWeaponType.value,
                            onClick = {
                                onUpdateWeapon(
                                    SelectedLoadoutType.BASIC_ATTACK,
                                    loadout.weapon?.copy(
                                        activeBasicSpell = it
                                    ) ?: filteredSpells.skills.first().copy(
                                        activeBasicSpell = it,
                                        activeCommonSpell = filteredSpells.commonSpells.first()
                                    )
                                )
                            }
                        )
                    }
                }
            }
        )
        // Weapon common
        WeaponSkillRowContainer(
            selectedLoadoutType = loadout.selectedLoadoutType,
            spellType = SpellType.common,
            row = {
                LazyRow(
                    modifier = Modifier.padding(vertical = 4.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items(filteredSpells.commonSpells) {
                        LoadoutWeaponCommonIcon(
                            modifier = if (isCompact() || isMedium())
                                Modifier.size(32.dp) else Modifier.size(64.dp),
                            commonSpell = it,
                            isSelected = loadout.weapon?.activeCommonSpell?.spellId == it.spellId && loadout.selectedLoadoutType == SelectedLoadoutType.COMMON_SKILL,
                            weaponType = selectedWeaponType.value,
                            onClick = {
                                onUpdateWeapon(
                                    SelectedLoadoutType.COMMON_SKILL,
                                    loadout.weapon?.copy(
                                        activeCommonSpell = it
                                    ) ?: filteredSpells.skills.first().copy(
                                        activeBasicSpell = filteredSpells.basicSpells.first(),
                                        activeCommonSpell = it
                                    )
                                )
                            }
                        )
                    }
                }
            }
        )
        // Weapon skills
        WeaponSkillRowContainer(
            selectedLoadoutType = loadout.selectedLoadoutType,
            spellType = SpellType.skill,
            row = {
                LazyRow(
                    modifier = Modifier.padding(vertical = 4.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items(filteredSpells.skills) {
                        LoadoutWeaponSkillIcon(
                            modifier = if (isCompact() || isMedium())
                                Modifier.size(32.dp) else Modifier.size(64.dp),
                            spell = it,
                            isSelected = loadout.weapon?.spellId == it.spellId && loadout.selectedLoadoutType == SelectedLoadoutType.WEAPON,
                            weaponType = selectedWeaponType.value,
                            onClick = {
                                if (loadout.weapon?.weaponType != it.weaponType) {
                                    onUpdateWeapon(SelectedLoadoutType.WEAPON, it.copy(
                                        activeBasicSpell = loadout.weapon?.activeBasicSpell
                                            ?: it.basicSpells.first(),
                                        activeCommonSpell = loadout.weapon?.activeCommonSpell
                                            ?: it.commonSpells.first()
                                    ))
                                } else {
                                    onUpdateWeapon(
                                        SelectedLoadoutType.WEAPON,
                                        it.copy(
                                            activeBasicSpell = loadout.weapon.activeBasicSpell
                                                ?: it.basicSpells.first(),
                                            activeCommonSpell = loadout.weapon.activeCommonSpell
                                                ?: it.commonSpells.first()
                                        )
                                    )
                                }
                            }
                        )
                    }
                }
            }
        )
        // Weapon passive
        WeaponSkillRowContainer(
            selectedLoadoutType = loadout.selectedLoadoutType,
            spellType = SpellType.passive,
            row = {
                LazyRow(
                    modifier = Modifier.padding(vertical = 4.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    item {
                        LoadoutWeaponPassiveIcon(
                            modifier = if (isCompact() || isMedium())
                                Modifier.size(32.dp) else Modifier.size(64.dp),
                            passiveSpell = filteredSpells.passiveSpell,
                            isSelected = loadout.selectedLoadoutType == SelectedLoadoutType.PASSIVE,
                            weaponType = selectedWeaponType.value,
                            onClick = {
                                if (loadout.weapon != null)
                                    onUpdateWeapon(
                                        SelectedLoadoutType.PASSIVE,
                                        loadout.weapon
                                    )
                            }
                        )
                    }
                }
            }
        )
    }
}

@Composable
fun WeaponSkillRowContainer(
    selectedLoadoutType: SelectedLoadoutType,
    spellType: SpellType,
    row: @Composable () -> Unit
) {
    Box {
        Divider(
            modifier = Modifier.fillMaxWidth().height(2.dp).spellBorder(
                isSelected = when (spellType) {
                    SpellType.passive -> selectedLoadoutType == SelectedLoadoutType.PASSIVE
                    SpellType.basic -> selectedLoadoutType == SelectedLoadoutType.BASIC_ATTACK
                    SpellType.common -> selectedLoadoutType == SelectedLoadoutType.COMMON_SKILL
                    SpellType.skill -> selectedLoadoutType == SelectedLoadoutType.WEAPON
                },
                selectedBrush = WarborneColorTheme.weaponSpellsCardBrushSelected,
                unSelectedBrush = WarborneColorTheme.weaponSpellsCardBrushUnSelected,
                borderWidth = 2.dp
            ).align(Alignment.Center)
                .shadow(
                    elevation = 16.dp,
                    shape = RectangleShape,
                    ambientColor = WarborneColorTheme.legendaryBorderStartColor,
                    spotColor = WarborneColorTheme.legendaryBorderStartColor
                ),
        )
        row()
    }
}