package com.elkite.warborn.presentation.widgets.gear

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.Gear
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.domain.entities.gear.Loadout
import com.elkite.warborn.domain.entities.gear.LoadoutType
import com.elkite.warborn.domain.entities.gear.spell.Spell
import com.elkite.warborn.domain.entities.gear.spell.SpellType
import com.elkite.warborn.presentation.widgets.loadout.LoadoutArmorIcon
import com.elkite.warborn.presentation.widgets.loadout.LoadoutSpellIcon
import com.elkite.warborn.presentation.widgets.utils.GearStylizedCard

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
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Top
    ) {
        LazyVerticalGrid(
            modifier = Modifier.wrapContentSize(),
            columns = GridCells.Fixed(4),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            items(spells.keys.toList()) { gearType ->
                GearStylizedCard(
                    modifier = Modifier.height(64.dp).clickable {
                        onCategoryClick(gearType)
                        selectedGearType.value = gearType
                        filteredSpells?.first()?.let {
                            onSpellClick(it)
                        }
                    },
                    composable = {
                        WeaponImage(
                            gearType = gearType,
                            isSelected = selectedGearType.value == gearType,
                            modifier = Modifier.size(64.dp).padding(8.dp),
                        )
                    },
                )

            }
        }

        Spacer(Modifier.size(4.dp))
        GearStylizedCard(
            modifier = Modifier.fillMaxWidth(),
            composable = {
                Column {
                    listOf(
                        SpellType.BASIC_ATTACK to LoadoutType.BASIC_ATTACK,
                        SpellType.COMMON_SKILL to LoadoutType.COMMON_SKILL,
                        SpellType.SKILL to LoadoutType.WEAPON
                    ).forEach { (spellType, loadoutType) ->
                        Row(modifier = Modifier.padding(16.dp).horizontalScroll(scrollState)) {
                            filteredSpells?.filter { it.type == spellType }?.forEach { spell ->
                                Column {
                                    LoadoutSpellIcon(
                                        loadoutType = loadoutType,
                                        spell = spell,
                                        onClick = {
                                            onCategoryClick(spell.associatedGearType)
                                            onSpellClick(spell)
                                        },
                                        isSelected = selectedGear.gameId == spell.gameId
                                    )
                                    Spacer(modifier = Modifier.size(8.dp))
                                    if (spellType == SpellType.SKILL)
                                        LoadoutArmorIcon(
                                            loadoutType = LoadoutType.WEAPON,
                                            gearName = spell.gearName,
                                            gearType = spell.associatedGearType,
                                            onClick = {
                                                onCategoryClick(spell.associatedGearType)
                                                onSpellClick(spell)
                                            }
                                        )
                                }
                                Spacer(modifier = Modifier.size(4.dp))
                            }
                        }
                    }
                    Row(modifier = Modifier.padding(16.dp)) {
                        filteredSpells?.firstOrNull { it.type == SpellType.PASSIVE }?.let { spell ->
                            LoadoutSpellIcon(
                                loadoutType = LoadoutType.PASSIVE,
                                spell = spell,
                                onClick = { onSpellClick(spell) },
                                isSelected = selectedGear.gameId == spell.gameId
                            )
                        }
                    }
                }
            },
        )
    }
}