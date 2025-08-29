package com.elkite.warborn.presentation.screen.main.common

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.Gear
import com.elkite.warborn.domain.entities.gear.LoadoutType
import com.elkite.warborn.domain.entities.gear.drifter.Drifter
import com.elkite.warborn.domain.entities.gear.mods.Mod
import com.elkite.warborn.domain.entities.gear.mods.ModSlot
import com.elkite.warborn.domain.entities.gear.mods.ModType
import com.elkite.warborn.domain.entities.gear.spell.Spell
import com.elkite.warborn.domain.entities.gear.spell.SpellType
import com.elkite.warborn.presentation.screen.main.DescriptionColumn
import com.elkite.warborn.presentation.screen.main.ItemListColumn
import com.elkite.warborn.presentation.screen.main.LoadoutColumn
import com.elkite.warborn.presentation.screen.main.MainScreenModel
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText
import com.elkite.warborn.presentation.widgets.utils.isMediumOrCompact
import com.elkite.warborn.util.IconMap
import org.jetbrains.compose.resources.painterResource

@Composable
actual fun MainContent(
    screenModel: MainScreenModel,
    state: MainScreenModel.BuildScreenState.Success
) {
    val gear = remember { mutableStateOf<Gear>(state.drifters.first()) }
    val loadoutType = remember { mutableStateOf(LoadoutType.DRIFTER) }
    val loadoutState = screenModel.loadout.collectAsState()
    val scrollableState = rememberScrollState()
    val isDescCompact = remember { mutableStateOf(true) }


    Box(modifier = Modifier.fillMaxSize()){

        Crossfade(
            targetState = loadoutState.value.drifter,
            animationSpec = tween()
        ) { drifter ->
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(IconMap.getDrifterFullBodyBg(drifter)),
                contentScale = Crop,
                alignment = Alignment.BottomCenter,
                alpha = 0.3f,
                contentDescription = null,
            )
        }

        GearStylizedText(
            text = "This app is not affiliated with or endorsed by QOOLAND",
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier.padding(16.dp).align(Alignment.BottomCenter)
        )

        FlowRow(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollableState),
            verticalArrangement = Arrangement.Top,
            horizontalArrangement = if (isMediumOrCompact()) Arrangement.SpaceAround else Arrangement.Start,
            maxItemsInEachRow = 3
        ) {
            LoadoutColumn(
                loadout = loadoutState.value,
                loadoutType = loadoutType.value,
                onLoadoutUrlUpdate = { url ->
                    screenModel.updateLoadoutFromUrl(url, state)
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

                        LoadoutType.MOD_WEAPON -> {
                            loadout.modWeapon
                                ?: state.mods.first { it.type == ModType.WEAPON && it.slot == ModSlot.ALL }
                        }

                        LoadoutType.MOD_HEAD -> {
                            loadout.modHead
                                ?: state.mods.first { it.type == ModType.ARMOR && it.slot == ModSlot.ALL }
                        }

                        LoadoutType.MOD_CHEST -> {
                            loadout.modChest
                                ?: state.mods.first { it.type == ModType.ARMOR && it.slot == ModSlot.CHEST }
                        }

                        LoadoutType.MOD_BOOTS -> {
                            loadout.modBoots
                                ?: state.mods.first { it.type == ModType.ARMOR && it.slot == ModSlot.BOOTS }
                        }
                    }
                },
            )
            ItemListColumn(
                state = state,
                loadout = loadoutState.value,
                selectedGear = gear.value,
                loadoutType = loadoutType.value,
                onUpdateGear = {
                    gear.value = it
                    if (it is Spell) {
                        loadoutType.value = it.getLoadoutType()
                    } else if (it is Drifter) {
                        loadoutType.value = LoadoutType.DRIFTER
                    } else if (it is Mod) {
                        loadoutType.value =
                            when (it.type) {
                                ModType.WEAPON -> LoadoutType.MOD_WEAPON
                                ModType.ARMOR -> when (it.slot) {
                                    ModSlot.CHEST -> LoadoutType.MOD_CHEST
                                    ModSlot.BOOTS -> LoadoutType.MOD_BOOTS
                                    else -> loadoutType.value
                                }
                            }
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
                onUpdateMod = { mod, loadoutType ->
                    when (loadoutType) {
                        LoadoutType.MOD_WEAPON -> screenModel.updateModWeapon(mod)
                        LoadoutType.MOD_HEAD -> screenModel.updateModHead(mod)
                        LoadoutType.MOD_CHEST -> screenModel.updateModChest(mod)
                        LoadoutType.MOD_BOOTS -> screenModel.updateModBoots(mod)
                        else -> {}
                    }
                },
                isDescCompact = isDescCompact.value,
                onCompactClick = {
                    isDescCompact.value = it
                }
            )
            DescriptionColumn(gear.value, isDescCompact = isDescCompact.value)
        }
    }
}