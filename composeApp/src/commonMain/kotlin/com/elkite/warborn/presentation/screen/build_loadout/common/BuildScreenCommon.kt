package com.elkite.warborn.presentation.screen.build_loadout.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonColors
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.Gear
import com.elkite.warborn.domain.entities.gear.GearMainCategory
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.domain.entities.gear.Loadout
import com.elkite.warborn.domain.entities.gear.LoadoutType
import com.elkite.warborn.domain.entities.gear.drifter.Drifter
import com.elkite.warborn.domain.entities.gear.spell.Spell
import com.elkite.warborn.domain.entities.gear.spell.SpellType
import com.elkite.warborn.presentation.screen.build_loadout.BuildScreenModel
import com.elkite.warborn.presentation.theme.WarborneTheme
import com.elkite.warborn.presentation.widgets.drifter.DrifterCardScrollable
import com.elkite.warborn.presentation.widgets.drifter.DrifterSmallList
import com.elkite.warborn.presentation.widgets.gear.ArmorSmallList
import com.elkite.warborn.presentation.widgets.gear.WeaponSmallList
import com.elkite.warborn.presentation.widgets.loadout.LoadoutCard
import com.elkite.warborn.presentation.widgets.loadout_from_url.LoadoutFromUrl
import com.elkite.warborn.presentation.widgets.spell.SpellCardListGrid
import com.elkite.warborn.presentation.widgets.utils.ClickableText
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText
import com.elkite.warborn.presentation.widgets.utils.ScreenScaffoldCommon

@Composable
fun BuildScreenContent(
    screenModel: BuildScreenModel,
    state: BuildScreenModel.BuildScreenState.Success
) {
    val gear = remember { mutableStateOf<Gear>(state.drifters.first()) }
    val loadoutType = remember { mutableStateOf(LoadoutType.DRIFTER) }
    val loadoutState = screenModel.loadout.collectAsState()

    ScreenScaffoldCommon(
        modifier = Modifier.fillMaxSize(),
        first = {
            Box(Modifier.fillMaxSize()) {
                LoadoutColumn(
                    loadout = loadoutState.value,
                    loadoutType = loadoutType.value,
                    onLoadoutUrlUpdate = { url ->
                        screenModel.updateLoadoutFromUrl(url)
                    },
                    onLoadoutClick = { type ->
                        val loadout = loadoutState.value

                        loadoutType.value = type
                        gear.value = when (type) {
                            LoadoutType.HEAD -> {
                                loadout.head ?: state.head.values.first().first()
                            }

                            LoadoutType.CHEST -> {
                                loadout.chest ?: state.chest.values.first().first()
                            }

                            LoadoutType.BOOTS -> {
                                loadout.boots ?: state.boots.values.first().first()
                            }

                            LoadoutType.WEAPON -> {
                                loadout.weapon ?: state.weapons.values.first()
                                    .first { it.type == SpellType.SKILL }
                            }

                            LoadoutType.DRIFTER -> {
                                loadout.drifter ?: state.drifters.first()
                            }

                            LoadoutType.BASIC_ATTACK -> {
                                loadout.basicAttack ?: state.weapons.values.first()
                                    .first { it.type == SpellType.BASIC_ATTACK }
                            }

                            LoadoutType.COMMON_SKILL -> {
                                loadout.commonSkill ?: state.weapons.values.first()
                                    .first { it.type == SpellType.COMMON_SKILL }
                            }

                            LoadoutType.PASSIVE -> {
                                loadout.passive ?: state.weapons.values.first()
                                    .first { it.type == SpellType.PASSIVE }
                            }
                        }
                    })

                Column(
                    Modifier.align(Alignment.BottomStart).padding(16.dp)
                ) {
                    Row {
                        GearStylizedText(text = "Discord : ")
                        ClickableText("https://discord.gg/H8GJZyc59e")
                    }
                    GearStylizedText(
                        text = "Last data update: ${state.lastDataUpdate}"
                    )
                }
            }
        },
        second = {
            ItemListColumn(
                state = state,
                loadout = loadoutState.value,
                selectedGear = gear.value,
                loadoutType = loadoutType.value,
                onUpdateGear = {
                    gear.value = it
                    if (it is Spell) {
                        loadoutType.value = it.getLoadoutType()
                    } else {
                        loadoutType.value = LoadoutType.DRIFTER
                    }
                },
                onUpdateLoadout = {
                    screenModel.updateLoadout(it)
                },
                onUpdateDrifter = {
                    screenModel.updateDrifter(it)
                },
                onUpdatePassive = {
                    screenModel.updatePassive(it)
                },
            )
        },
        third = {
            DescriptionColumn(gear.value)
        }
    )
}

@Composable
private fun LoadoutColumn(
    loadout: Loadout,
    loadoutType: LoadoutType,
    onLoadoutUrlUpdate: (String) -> Unit,
    onLoadoutClick: (LoadoutType) -> Unit,
) {
    LoadoutFromUrl(loadout = loadout, onLoadoutUrlUpdate = onLoadoutUrlUpdate)

    LoadoutCard(
        modifier = Modifier.wrapContentSize(),
        loadout = loadout,
        selectedLoadout = loadoutType,
        onClick = onLoadoutClick,
    )
}

@Composable
private fun ItemListColumn(
    state: BuildScreenModel.BuildScreenState.Success,
    loadout: Loadout,
    loadoutType: LoadoutType,
    selectedGear: Gear,
    onUpdateGear: (Gear) -> Unit,
    onUpdateLoadout: (Spell) -> Unit,
    onUpdateDrifter: (Drifter) -> Unit,
    onUpdatePassive: (GearType) -> Unit,
) {

    val categoryOptions = listOf(
        GearMainCategory.DRIFTER,
        GearMainCategory.WEAPON,
        GearMainCategory.ARMOR
    )
    val selectedIndex = remember { mutableStateOf(0) }

    LaunchedEffect(loadoutType) {
        selectedIndex.value = when (loadoutType) {
            LoadoutType.HEAD, LoadoutType.CHEST, LoadoutType.BOOTS -> 2
            LoadoutType.DRIFTER -> 0
            else -> 1
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(top = 16.dp, start = 16.dp, end = 16.dp),
    ) {
        SingleChoiceSegmentedButtonRow(
            modifier = Modifier.fillMaxWidth(),
        ) {
            categoryOptions.forEachIndexed { index, label ->
                SegmentedButton(
                    onClick = { selectedIndex.value = index },
                    selected = index == selectedIndex.value,
                    label = { GearStylizedText(text = label.name) },
                    shape = RectangleShape,
                    colors = SegmentedButtonColors(
                        activeBorderColor = WarborneTheme.textDescriptionColor,
                        activeContainerColor = WarborneTheme.textBackgroundColor,
                        activeContentColor = WarborneTheme.textDescriptionColor,
                        inactiveBorderColor = WarborneTheme.borderSkillColor,
                        inactiveContainerColor = WarborneTheme.textBackgroundColor,
                        inactiveContentColor = WarborneTheme.textDescriptionColor,
                        disabledActiveContainerColor = WarborneTheme.textBackgroundColor,
                        disabledActiveContentColor = WarborneTheme.textBackgroundColor,
                        disabledActiveBorderColor = WarborneTheme.textBackgroundColor,
                        disabledInactiveContainerColor = WarborneTheme.textBackgroundColor,
                        disabledInactiveContentColor = WarborneTheme.textBackgroundColor,
                        disabledInactiveBorderColor = WarborneTheme.textBackgroundColor,
                    )
                )
            }
        }
        when (categoryOptions[selectedIndex.value]) {
            GearMainCategory.ARMOR -> {
                ArmorSmallList(
                    modifier = Modifier.fillMaxSize().padding(top = 0.dp),
                    loadoutType = loadoutType,
                    spellsHead = state.head,
                    spellsChest = state.chest,
                    spellsBoots = state.boots,
                    onSpellClick = { spell ->
                        onUpdateGear(spell)
                        onUpdateLoadout(spell)
                    }
                )
            }

            GearMainCategory.WEAPON -> {
                WeaponSmallList(
                    modifier = Modifier.fillMaxSize().padding(top = 4.dp),
                    loadout = loadout,
                    selectedGear = selectedGear,
                    spells = state.weapons,
                    onSpellClick = { spell ->
                        onUpdateGear(spell)
                        onUpdateLoadout(spell)
                    },
                    onCategoryClick = { gearType ->
                        state.weapons[gearType]?.first()?.let {
                            onUpdateGear(it)
                        }
                        onUpdatePassive(gearType)
                    },
                )
            }

            GearMainCategory.DRIFTER -> {
                DrifterSmallList(
                    modifier = Modifier.fillMaxWidth().padding(top = 4.dp),
                    drifters = state.drifters,
                    onDrifterClick = { drifter: Drifter ->
                        onUpdateGear(drifter)
                        onUpdateDrifter(drifter)
                    })
            }
        }

    }
}

@Composable
private fun DescriptionColumn(
    gear: Gear,
) {
    if (gear is Spell) {
        SpellCardListGrid(
            spells = listOf(gear),
            onSpellClick = { spell ->
            }
        )
    } else if (gear is Drifter) {
        DrifterCardScrollable(
            drifter = gear,
            onDrifterClick = { drifter ->
            }
        )
    }
}