package com.elkite.warborn.presentation.screen.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonColors
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.elkite.warborn.presentation.theme.WarborneTheme
import com.elkite.warborn.presentation.widgets.drifter.DrifterCardScrollable
import com.elkite.warborn.presentation.widgets.drifter.DrifterSmallList
import com.elkite.warborn.presentation.widgets.gear.ArmorSmallList
import com.elkite.warborn.presentation.widgets.gear.WeaponSmallList
import com.elkite.warborn.presentation.widgets.loadout.LoadoutCard
import com.elkite.warborn.presentation.widgets.loadout_from_url.LoadoutFromUrl
import com.elkite.warborn.presentation.widgets.spell.SpellCardList
import com.elkite.warborn.presentation.widgets.utils.ClickableText
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText

@Composable
fun LoadoutColumn(
    loadout: Loadout,
    loadoutType: LoadoutType,
    onLoadoutUrlUpdate: (String) -> Unit,
    onLoadoutClick: (LoadoutType) -> Unit,
) {
    LoadoutFromUrl(loadout = loadout, onLoadoutUrlUpdate = onLoadoutUrlUpdate)

    Column {
        LoadoutCard(
            modifier = Modifier.wrapContentSize(),
            loadout = loadout,
            selectedLoadout = loadoutType,
            onClick = onLoadoutClick,
        )
        Column(modifier = Modifier.padding(16.dp)) {
            Row {
                GearStylizedText(text = "Discord : ")
                ClickableText("https://discord.gg/H8GJZyc59e")
            }
        }
    }
}

@Composable
fun ItemListColumn(
    state: MainScreenModel.BuildScreenState.Success,
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
        modifier = Modifier.width(600.dp).wrapContentSize().padding(top = 12.dp, start = 16.dp, end = 16.dp),
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
                    modifier = Modifier.sizeIn(minWidth = 600.dp, minHeight = 600.dp, maxWidth = 800.dp, maxHeight = 800.dp).padding(top = 0.dp),
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
                    modifier = Modifier.sizeIn(minWidth = 600.dp, minHeight = 700.dp, maxWidth = 800.dp, maxHeight = 800.dp).padding(top = 4.dp),
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
                    modifier = Modifier.sizeIn(minWidth = 600.dp, minHeight = 700.dp, maxWidth = 800.dp, maxHeight = 800.dp).padding(top = 4.dp),
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
fun DescriptionColumn(
    gear: Gear,
) {
    if (gear is Spell) {
        SpellCardList(
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