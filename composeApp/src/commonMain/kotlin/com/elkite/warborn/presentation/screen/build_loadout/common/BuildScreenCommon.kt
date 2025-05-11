package com.elkite.warborn.presentation.screen.build_loadout.common

import ArmorSmallList
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.elkite.warborn.domain.entities.gear.Gear
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.domain.entities.gear.LoadoutType
import com.elkite.warborn.domain.entities.gear.drifter.Drifter
import com.elkite.warborn.domain.entities.gear.spell.Spell
import com.elkite.warborn.domain.entities.gear.spell.SpellType
import com.elkite.warborn.presentation.screen.build_loadout.BuildScreenModel
import com.elkite.warborn.presentation.widgets.drifter.DrifterCard
import com.elkite.warborn.presentation.widgets.drifter.DrifterSmallList
import com.elkite.warborn.presentation.widgets.gear.WeaponSmallList
import com.elkite.warborn.presentation.widgets.loadout.LoadoutCardList
import com.elkite.warborn.presentation.widgets.loadout_from_url.LoadoutFromUrl
import com.elkite.warborn.presentation.widgets.spell.SpellCardListGrid
import com.elkite.warborn.presentation.widgets.utils.ScreenScaffoldCommon

@Composable
fun BuildScreenContent(screenModel: BuildScreenModel, state: BuildScreenModel.SpellsState.Success) {

    val gearType = remember { mutableStateOf(GearType.DRIFTER) }
    val gear = remember { mutableStateOf<Gear>(state.drifters.first()) }
    val loadoutType = remember { mutableStateOf(LoadoutType.DRIFTER) }

    ScreenScaffoldCommon(
        modifier = Modifier.fillMaxSize(),
        first = {
            LoadoutColumn(screenModel, loadoutType, gearType, gear, state)
        },
        second = {
            ItemListColumn(gearType, state, gear, screenModel)
        },
        third = {
            DescriptionColumn(gear, loadoutType, screenModel, state)
        }
    )
}

@Composable
private fun LoadoutColumn(
    screenModel: BuildScreenModel,
    loadoutType: MutableState<LoadoutType>,
    gearType: MutableState<GearType>,
    gear: MutableState<Gear>,
    state: BuildScreenModel.SpellsState.Success
) {
    val loadout by screenModel.loadout.collectAsState()

    LoadoutFromUrl(screenModel, loadout)

    LoadoutCardList(
        modifier = Modifier.fillMaxSize(),
        loadout = loadout,
    ) { type ->
        loadoutType.value = type
        when (type) {
            LoadoutType.HEAD -> {
                gearType.value = GearType.HEAD
                gear.value = state.head.values.first().first()
            }

            LoadoutType.CHEST -> {
                gearType.value = GearType.CHEST
                gear.value = state.chest.values.first().first()
            }

            LoadoutType.BOOTS -> {
                gearType.value = GearType.BOOTS
                gear.value = state.boots.values.first().first()
            }

            LoadoutType.WEAPON -> {
                gearType.value = GearType.WEAPON
                gear.value = state.weapons.values.first().first()
            }

            LoadoutType.DRIFTER -> {
                gearType.value = GearType.DRIFTER
                gear.value = state.drifters.first()
            }

            LoadoutType.PASSIVE -> {
                gearType.value = GearType.WEAPON
                loadout.weapon?.associatedGearType?.let { gearType ->
                    state.weapons[gearType]?.first { it.type == SpellType.PASSIVE }?.let {
                        gear.value = it
                    }
                }
            }

            else -> {
                gearType.value = GearType.WEAPON
            }
        }
    }
}

@Composable
private fun ItemListColumn(
    gearType: MutableState<GearType>,
    state: BuildScreenModel.SpellsState.Success,
    gear: MutableState<Gear>,
    screenModel: BuildScreenModel
) {
    when (gearType.value) {
        GearType.WEAPON -> {
            WeaponSmallList(
                modifier = Modifier.fillMaxSize(),
                spells = state.weapons,
                onSpellClick = { spell ->
                    gear.value = spell
                    screenModel.updateLoadout(spell)
                    screenModel.updatePassive(spell.associatedGearType)
                }
            )
        }

        GearType.DRIFTER -> DrifterSmallList(
            drifters = state.drifters,
            onDrifterClick = { drifter: Drifter ->
                gear.value = drifter
                screenModel.updateDrifter(drifter)
            })

        else -> {
            ArmorSmallList(
                modifier = Modifier.fillMaxSize(),
                spells = when (gearType.value) {
                    GearType.HEAD -> state.head
                    GearType.CHEST -> state.chest
                    GearType.BOOTS -> state.boots
                    else -> HashMap()
                },
                gearType = gearType.value,
                onSpellClick = { spell ->
                    gear.value = spell
                    screenModel.updateLoadout(spell)
                }
            )
        }
    }
}

@Composable
private fun DescriptionColumn(
    gear: MutableState<Gear>,
    loadoutType: MutableState<LoadoutType>,
    screenModel: BuildScreenModel,
    state: BuildScreenModel.SpellsState.Success
) {
    if (gear.value is Spell) {
        val spells = filterSpells(loadoutType, screenModel, state, gear)

        SpellCardListGrid(
            spells = spells,
            onSpellClick = { spell ->
                screenModel.updateLoadout(spell)
                screenModel.updatePassive(spell.associatedGearType)
            }
        )
    } else if (gear.value is Drifter) {
        DrifterCard(
            drifter = gear.value as Drifter,
            onDrifterClick = { drifter ->
                screenModel.updateDrifter(drifter)
            }
        )
    }
}

private fun filterSpells(
    loadoutType: MutableState<LoadoutType>,
    screenModel: BuildScreenModel,
    state: BuildScreenModel.SpellsState.Success,
    gear: MutableState<Gear>
): List<Spell> {
    val spells = when (loadoutType.value) {
        LoadoutType.BASIC_ATTACK -> {
            val loadout = screenModel.loadout.value

            loadout.weapon?.associatedGearType?.let { gearType ->
                state.weapons[gearType]?.filter { it.type == SpellType.BASIC_ATTACK }
            } ?: listOf()
        }

        LoadoutType.COMMON_SKILL -> {
            val loadout = screenModel.loadout.value

            loadout.weapon?.associatedGearType?.let { gearType ->
                state.weapons[gearType]?.filter { it.type == SpellType.COMMON_SKILL }
            } ?: listOf()
        }

        LoadoutType.WEAPON -> {
            val loadout = screenModel.loadout.value

            loadout.weapon?.associatedGearType?.let { gearType ->
                state.weapons[gearType]?.filter { it.gameId == loadout.weapon.gameId }
            } ?: listOf()
        }

        else -> {
            listOf(gear.value as Spell)
        }
    }
    return spells
}