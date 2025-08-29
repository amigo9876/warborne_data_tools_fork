package com.elkite.warborn.presentation.screen.patch.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.Gear
import com.elkite.warborn.domain.entities.gear.drifter.Drifter
import com.elkite.warborn.domain.entities.gear.mods.Mod
import com.elkite.warborn.domain.entities.gear.spell.Spell
import com.elkite.warborn.presentation.screen.main.MainScreenModel
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.theme.onHover
import com.elkite.warborn.presentation.widgets.drifter.DrifterCard
import com.elkite.warborn.presentation.widgets.mod.ModCard
import com.elkite.warborn.presentation.widgets.mod.ModImage
import com.elkite.warborn.presentation.widgets.patch_balance.BalanceStatus
import com.elkite.warborn.presentation.widgets.spell.SpellCard
import com.elkite.warborn.presentation.widgets.spell.SpellIcon
import com.elkite.warborn.presentation.widgets.utils.GearStylizedCard
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText
import com.elkite.warborn.presentation.widgets.utils.GearStylizedTextTitle


@Composable
actual fun PatchScreenCommon(state: MainScreenModel.BuildScreenState.Success) {
    val patchDate = "June 6, 2025 02:46:00 AM"

    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Column(modifier = Modifier.wrapContentWidth()) {
            GearStylizedTextTitle(
                text = "Patch Notes",
            )
            Divider(
                modifier = Modifier.width(200.dp).padding(top = 8.dp, bottom = 16.dp),
                color = WarborneColorTheme.borderSkillColor,
                thickness = 1.dp
            )
        }


        val hoveredGear = remember { mutableStateOf<Gear?>(null) }

        GearStylizedText(
            text = "Latest patch date: $patchDate",
        )
        Spacer(Modifier.size(8.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.Top
            ) {
                BalanceColumn(
                    state = state,
                    balanceStatus = BalanceStatus.buff,
                    predicate = { it.balance.lastUpdate == patchDate && it.balance.status == BalanceStatus.buff },
                    onHover = { gear ->
                        hoveredGear.value = gear
                    },
                )
                BalanceColumn(
                    state = state,
                    balanceStatus = BalanceStatus.nerf,
                    predicate = { it.balance.lastUpdate == patchDate && it.balance.status == BalanceStatus.nerf },
                    onHover = { gear ->
                        hoveredGear.value = gear
                    })
                BalanceColumn(
                    state = state,
                    balanceStatus = BalanceStatus.balance,
                    predicate = { it.balance.lastUpdate == patchDate && it.balance.status == BalanceStatus.balance },
                    onHover = { gear ->
                        hoveredGear.value = gear
                    },
                )
            }
            hoveredGear.value?.let {
                Column(
                    modifier = Modifier.wrapContentHeight().width(500.dp)
                        .padding(horizontal = 16.dp)
                ) {
                    when (it) {
                        is Spell -> {
                            SpellCard(
                                spell = it,
                                onSpellClick = {},
                                isCompact = false,
                            )
                        }

                        is Drifter -> {
                            DrifterCard(
                                drifter = it,
                                onDrifterClick = {},
                                isCompact = false,
                            )
                        }

                        is Mod -> {
                            ModCard(
                                mod = it,
                                onModClick = {}
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun BalanceColumn(
    state: MainScreenModel.BuildScreenState.Success,
    balanceStatus: BalanceStatus,
    predicate: (Gear) -> Boolean,
    onHover: (Gear) -> Unit,
) {
    GearStylizedCard {
        Column(
            modifier = Modifier.padding(16.dp),
        ) {
            GearStylizedText(
                text = when (balanceStatus) {
                    BalanceStatus.buff -> "Buffs"
                    BalanceStatus.nerf -> "Nerfs"
                    BalanceStatus.balance -> "Changes"
                },
                color = when (balanceStatus) {
                    BalanceStatus.buff -> WarborneColorTheme.dexterityColor
                    BalanceStatus.nerf -> WarborneColorTheme.strengthColor
                    BalanceStatus.balance -> WarborneColorTheme.legendaryBorderMidColor
                },
                style = MaterialTheme.typography.h5.copy(
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace
                )
            )
            Spacer(Modifier.size(8.dp))

            val drifters = state.drifters.flatMap {
                listOf(it.spell, it.passive)
            }.filter { predicate(it) }
            val mods = state.mods.filter { predicate(it) }
            val spells = state.weapons.values.flatten().filter { predicate(it) }

            Row(modifier = Modifier.fillMaxHeight(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                if (drifters.isNotEmpty()) {
                    LazyColumn(Modifier.width(64.dp)) {
                        items(drifters) {
                            SpellIcon(
                                spellType = it.type,
                                id = it.gameId,
                                gearType = it.associatedGearType,
                                modifier = Modifier.size(64.dp)
                                    .onHover(gear = it, onHover = onHover)
                            )
                            Spacer(Modifier.size(8.dp))
                        }
                    }
                }
                if (spells.isNotEmpty()) {
                    LazyColumn(Modifier.width(64.dp)) {
                        items(spells) {
                            SpellIcon(
                                spellType = it.type,
                                id = it.gameId,
                                gearType = it.associatedGearType,
                                modifier = Modifier.size(64.dp)
                                    .onHover(gear = it, onHover = onHover)
                            )
                            Spacer(Modifier.size(8.dp))
                        }
                    }
                }
                if (mods.isNotEmpty()) {
                    LazyColumn(Modifier.width(64.dp)) {
                        items(mods) {
                            ModImage(
                                mod = it,
                                modifier = Modifier.size(64.dp)
                                    .onHover(gear = it, onHover = onHover)
                            )
                            Spacer(Modifier.size(8.dp))
                        }
                    }
                }
            }
        }
    }
}