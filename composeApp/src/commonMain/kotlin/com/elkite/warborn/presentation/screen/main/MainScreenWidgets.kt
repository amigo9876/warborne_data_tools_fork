package com.elkite.warborn.presentation.screen.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonColors
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.Gear
import com.elkite.warborn.domain.entities.gear.GearMainCategory
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.domain.entities.gear.Loadout
import com.elkite.warborn.domain.entities.gear.LoadoutType
import com.elkite.warborn.domain.entities.gear.drifter.Drifter
import com.elkite.warborn.domain.entities.gear.mods.Mod
import com.elkite.warborn.domain.entities.gear.spell.Spell
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.widgets.drifter.DrifterCardScrollable
import com.elkite.warborn.presentation.widgets.drifter.DrifterSmallList
import com.elkite.warborn.presentation.widgets.gear.ArmorSmallList
import com.elkite.warborn.presentation.widgets.gear.WeaponSmallList
import com.elkite.warborn.presentation.widgets.loadout.LoadoutCard
import com.elkite.warborn.presentation.widgets.loadout_from_url.LoadoutFromUrl
import com.elkite.warborn.presentation.widgets.mod.ModCardList
import com.elkite.warborn.presentation.widgets.mod.ModSmallList
import com.elkite.warborn.presentation.widgets.spell.SpellCardList
import com.elkite.warborn.presentation.widgets.utils.ClickableText
import com.elkite.warborn.presentation.widgets.utils.CopyButton
import com.elkite.warborn.presentation.widgets.utils.GearStylizedCard
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText
import com.elkite.warborn.presentation.widgets.utils.isCompact
import com.elkite.warborn.presentation.widgets.utils.isMedium
import com.elkite.warborn.resources.Com_Head_Helmet
import com.elkite.warborn.resources.Com_Weapon_Sword
import com.elkite.warborn.resources.Common_ParagonWarehouse
import com.elkite.warborn.resources.ItemIcon_MODCore
import com.elkite.warborn.resources.Res
import org.jetbrains.compose.resources.painterResource

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
            CopyButton(
                modifier = Modifier.padding(start = 8.dp),
                textToCopy = loadout.toQueryParams(),
                buttonText = {
                    GearStylizedText(text = "Copy Loadout")
                }
            )
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
    onUpdateMod: (Mod, LoadoutType) -> Unit
) {

    val modifier =
        if (isCompact())
            Modifier.sizeIn(maxWidth = 450.dp, minHeight = 700.dp, maxHeight = 1000.dp)
                .wrapContentSize()
        else if (isMedium())
            Modifier.sizeIn(maxWidth = 450.dp, minHeight = 700.dp, maxHeight = 1000.dp)
                .wrapContentSize()
        else
            Modifier.sizeIn(
                minWidth = 450.dp,
                maxWidth = 600.dp,
                minHeight = 700.dp,
                maxHeight = 1000.dp
            ).wrapContentSize()

    val categoryOptions = listOf(
        GearMainCategory.DRIFTER,
        GearMainCategory.WEAPON,
        GearMainCategory.ARMOR,
        GearMainCategory.MOD
    )
    val selectedIndex = remember { mutableStateOf(0) }

    LaunchedEffect(loadoutType) {
        selectedIndex.value = when (loadoutType) {
            LoadoutType.MOD_WEAPON, LoadoutType.MOD_HEAD, LoadoutType.MOD_CHEST, LoadoutType.MOD_BOOTS -> 3
            LoadoutType.HEAD, LoadoutType.CHEST, LoadoutType.BOOTS -> 2
            LoadoutType.DRIFTER -> 0
            else -> 1
        }
    }

    Column(
        modifier = modifier.padding(top = 12.dp, start = 16.dp, end = 16.dp).fillMaxHeight(),
        verticalArrangement = Arrangement.Top
    ) {
        GearStylizedCard {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Top
            ) {
                SingleChoiceSegmentedButtonRow(
                    modifier = Modifier.wrapContentSize().padding(bottom = 8.dp),
                ) {
                    categoryOptions.forEachIndexed { index, label ->
                        SegmentedButton(
                            onClick = { selectedIndex.value = index },
                            selected = index == selectedIndex.value,
                            label = {
                                Image(
                                    painter = painterResource(
                                        when (label) {
                                            GearMainCategory.ARMOR -> Res.drawable.Com_Head_Helmet
                                            GearMainCategory.WEAPON -> Res.drawable.Com_Weapon_Sword
                                            GearMainCategory.DRIFTER -> Res.drawable.Common_ParagonWarehouse
                                            GearMainCategory.MOD -> Res.drawable.ItemIcon_MODCore
                                        }
                                    ),
                                    colorFilter = ColorFilter.tint(Color.White),
                                    contentDescription = null,
                                    modifier = Modifier.size(32.dp)
                                )
                            },
                            shape = RectangleShape,
                            colors = SegmentedButtonColors(
                                activeBorderColor = WarborneColorTheme.borderSkillHightlightColor,
                                activeContainerColor = WarborneColorTheme.textBackgroundColor,
                                activeContentColor = WarborneColorTheme.textDescriptionColor,
                                inactiveBorderColor = WarborneColorTheme.borderSkillColor,
                                inactiveContainerColor = WarborneColorTheme.textBackgroundColor,
                                inactiveContentColor = WarborneColorTheme.borderSkillColor,
                                disabledActiveContainerColor = WarborneColorTheme.textBackgroundColor,
                                disabledActiveContentColor = WarborneColorTheme.textBackgroundColor,
                                disabledActiveBorderColor = WarborneColorTheme.textBackgroundColor,
                                disabledInactiveContainerColor = WarborneColorTheme.textBackgroundColor,
                                disabledInactiveContentColor = WarborneColorTheme.textBackgroundColor,
                                disabledInactiveBorderColor = WarborneColorTheme.textBackgroundColor,
                            )
                        )
                    }
                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    when (categoryOptions[selectedIndex.value]) {
                        GearMainCategory.ARMOR -> {
                            Box(Modifier.wrapContentHeight()) {
                                ArmorSmallList(
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
                        }

                        GearMainCategory.WEAPON -> {
                            WeaponSmallList(
                                modifier = Modifier,
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
                                modifier = Modifier,
                                drifters = state.drifters,
                                onDrifterClick = { drifter: Drifter ->
                                    onUpdateGear(drifter)
                                    onUpdateDrifter(drifter)
                                })
                        }

                        GearMainCategory.MOD -> {
                            ModSmallList(
                                modifier = Modifier,
                                loadoutType = loadoutType,
                                mods = state.mods,
                                onModClick = { mod, loadoutType ->
                                    onUpdateGear(mod)
                                    onUpdateMod(mod, loadoutType)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DescriptionColumn(
    gear: Gear,
    onLoadoutClick: () -> Unit = {}
) {
    if (gear is Spell) {
        SpellCardList(
            spells = listOf(gear),
            onSpellClick = { spell ->
                onLoadoutClick()
            }
        )
    } else if (gear is Drifter) {
        DrifterCardScrollable(
            drifter = gear,
            onDrifterClick = { drifter ->
                onLoadoutClick()
            }
        )
    } else if (gear is Mod) {
        ModCardList(
            mods = listOf(gear),
            onModClick = { mod ->
                onLoadoutClick()
            }
        )
    }
}