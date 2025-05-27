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
import com.elkite.warborn.domain.entities.gear.Gear
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.domain.entities.gear.Loadout
import com.elkite.warborn.domain.entities.gear.LoadoutType
import com.elkite.warborn.domain.entities.gear.spell.Spell
import com.elkite.warborn.domain.entities.gear.spell.SpellType
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.theme.spellBorder
import com.elkite.warborn.presentation.widgets.loadout.LoadoutArmorIcon
import com.elkite.warborn.presentation.widgets.loadout.LoadoutSpellIcon
import com.elkite.warborn.presentation.widgets.utils.GearStylizedCard
import com.elkite.warborn.presentation.widgets.utils.isCompact

@Composable
fun WeaponSmallList(
    loadout: Loadout,
    spells: HashMap<GearType, List<Spell>>,
    selectedGear: Gear,
    onSpellClick: (Spell) -> Unit,
    onCategoryClick: (GearType) -> Unit,
    modifier: Modifier = Modifier,
) {
    val selectedGearType = remember {
        mutableStateOf(
            when (selectedGear) {
                is Spell -> {
                    if (selectedGear.associatedGearType == GearType.WEAPON)
                        selectedGear.associatedGearType
                    else
                        loadout.weapon?.associatedGearType ?: GearType.SWORD
                }

                else -> GearType.SWORD
            }
        )
    }
    val filteredSpells by remember {
        derivedStateOf {
            spells[selectedGearType.value]
        }
    }

    Column(
        modifier = modifier.wrapContentHeight().fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
    ) {
        LazyVerticalGrid(
            modifier = Modifier.fillMaxWidth().wrapContentHeight(),
            columns = GridCells.Fixed(4),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            items(spells.keys.toList()) { gearType ->
                GearStylizedCard(
                    modifier = Modifier.height(48.dp).clickable {
                        onCategoryClick(gearType)
                        selectedGearType.value = gearType
                        filteredSpells?.first()?.let {
                            onSpellClick(it)
                        }
                    },
                    borderColor = if (selectedGearType.value == gearType) {
                        WarborneColorTheme.legendaryBorderStartColor
                    } else {
                        WarborneColorTheme.borderSkillColor
                    },
                    composable = {
                        WeaponImage(
                            gearType = gearType,
                            isSelected = selectedGearType.value == gearType,
                            modifier = Modifier.size(48.dp),
                        )
                    },
                )
            }
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(filteredSpells?.filter { it.type == SpellType.SKILL }
                ?: emptyList()) { spell ->
                LoadoutArmorIcon(
                    modifier = Modifier.size(if (isCompact()) 48.dp else 64.dp),
                    loadoutType = LoadoutType.WEAPON,
                    gearName = spell.gearName,
                    gearType = spell.associatedGearType,
                    rarity = spell.rarity,
                    onClick = {
                        onCategoryClick(spell.associatedGearType)
                        onSpellClick(spell)
                    }
                )
            }
        }

        listOf(
            SpellType.BASIC_ATTACK to LoadoutType.BASIC_ATTACK,
            SpellType.COMMON_SKILL to LoadoutType.COMMON_SKILL,
            SpellType.SKILL to LoadoutType.WEAPON
        ).forEach { (spellType, loadoutType) ->
            Box {
                Divider(
                    modifier = Modifier.fillMaxWidth().height(2.dp).spellBorder(
                        isSelected = when (selectedGear) {
                            is Spell -> selectedGear.type == spellType
                            else -> false
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
                LazyRow(
                    modifier = Modifier.padding(vertical = 4.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items(filteredSpells?.filter { it.type == spellType } ?: emptyList()) { spell ->
                        Column {
                            LoadoutSpellIcon(
                                modifier = Modifier.size(if (isCompact()) 48.dp else 64.dp),
                                loadoutType = loadoutType,
                                spell = spell,
                                onClick = {
                                    onCategoryClick(spell.associatedGearType)
                                    onSpellClick(spell)
                                },
                                isSelected = selectedGear.gameId == spell.gameId
                            )
                        }
                    }
                }
            }
        }
        Box {
            Divider(
                modifier = Modifier.fillMaxWidth().height(2.dp).spellBorder(
                    isSelected = when (selectedGear) {
                        is Spell -> selectedGear.type == SpellType.PASSIVE
                        else -> false
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
            LazyRow(
                modifier = Modifier.padding(top = 4.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                filteredSpells?.filter { it.type == SpellType.PASSIVE }?.forEach { spell ->
                    item {
                        LoadoutSpellIcon(
                            modifier = Modifier.size(if (isCompact()) 48.dp else 64.dp),
                            loadoutType = LoadoutType.PASSIVE,
                            spell = spell,
                            onClick = { onSpellClick(spell) },
                            isSelected = selectedGear.gameId == spell.gameId
                        )
                    }
                }
            }
        }
    }
}