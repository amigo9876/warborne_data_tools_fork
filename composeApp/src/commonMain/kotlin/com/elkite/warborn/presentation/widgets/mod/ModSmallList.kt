package com.elkite.warborn.presentation.widgets.mod

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonColors
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.domain.entities.gear.LoadoutType
import com.elkite.warborn.domain.entities.gear.mods.Mod
import com.elkite.warborn.domain.entities.gear.mods.ModSlot
import com.elkite.warborn.domain.entities.gear.mods.ModType
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.widgets.gear.WeaponImage
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText
import com.elkite.warborn.presentation.widgets.utils.isCompact
import com.elkite.warborn.presentation.widgets.utils.isMedium
import com.elkite.warborn.resources.Com_Clothes_Armor
import com.elkite.warborn.resources.Com_Head_Helmet
import com.elkite.warborn.resources.Com_Shoes_Boots
import com.elkite.warborn.resources.Com_Weapon_Sword
import com.elkite.warborn.resources.Res
import com.elkite.warborn.resources.error_emoji
import org.jetbrains.compose.resources.painterResource

@Composable
fun ModSmallList(
    modifier: Modifier = Modifier,
    loadoutType: LoadoutType,
    mods: List<Mod>,
    onModClick: (Mod, LoadoutType) -> Unit,
) {
    val subcategoryOptions = listOf(
        LoadoutType.MOD_WEAPON,
        LoadoutType.MOD_HEAD,
        LoadoutType.MOD_CHEST,
        LoadoutType.MOD_BOOTS
    )
    val selectedIndex = remember { mutableStateOf(0) }
    val currentMods = derivedStateOf {
        when (subcategoryOptions[selectedIndex.value]) {
            LoadoutType.MOD_WEAPON -> mods.filter { it.type == ModType.WEAPON }
            LoadoutType.MOD_HEAD -> mods.filter { it.type == ModType.ARMOR && it.slot == ModSlot.ALL }
            LoadoutType.MOD_CHEST -> mods.filter { it.type == ModType.ARMOR && it.slot != ModSlot.BOOTS }
            LoadoutType.MOD_BOOTS -> mods.filter { it.type == ModType.ARMOR && it.slot != ModSlot.CHEST }
            else -> emptyList()
        }
    }
    val modsAll = currentMods.value.filter { it.slot == ModSlot.ALL }
    val rest = currentMods.value.filter { it.slot != ModSlot.ALL }

    LaunchedEffect(loadoutType) {
        selectedIndex.value = when (loadoutType) {
            LoadoutType.MOD_HEAD -> 1
            LoadoutType.MOD_CHEST -> 2
            LoadoutType.MOD_BOOTS -> 3
            else -> 0
        }
    }


    Column(modifier = modifier.fillMaxWidth()) {
        SingleChoiceSegmentedButtonRow(
            modifier = Modifier.padding(bottom = 8.dp),
        ) {
            subcategoryOptions.forEachIndexed { index, label ->
                SegmentedButton(
                    onClick = { selectedIndex.value = index },
                    selected = index == selectedIndex.value,
                    label = {
                        when (label) {
                            LoadoutType.MOD_WEAPON -> Image(
                                modifier = Modifier.size(32.dp),
                                painter = painterResource(Res.drawable.Com_Weapon_Sword),
                                contentDescription = null,

                                )

                            LoadoutType.MOD_HEAD -> Image(
                                modifier = Modifier.size(32.dp),
                                painter = painterResource(Res.drawable.Com_Head_Helmet),
                                contentDescription = null,

                                )

                            LoadoutType.MOD_CHEST -> Image(
                                modifier = Modifier.size(32.dp),
                                painter = painterResource(Res.drawable.Com_Clothes_Armor),
                                contentDescription = null,

                                )

                            LoadoutType.MOD_BOOTS -> Image(
                                modifier = Modifier.size(32.dp),
                                painter = painterResource(Res.drawable.Com_Shoes_Boots),
                                contentDescription = null,

                                )

                            else -> Icon(
                                modifier = Modifier.size(32.dp),
                                painter = painterResource(Res.drawable.error_emoji),
                                contentDescription = null,
                            )
                        }
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


        LazyColumn(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            item {
                GearStylizedText(
                    text = ModSlot.ALL.name.lowercase().capitalize(),
                )
                Divider(
                    modifier = Modifier.fillMaxWidth()
                        .padding(top = 8.dp, bottom = 16.dp),
                    color = WarborneColorTheme.borderSkillColor,
                    thickness = 1.dp
                )

                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    horizontalArrangement = if (isCompact() || isMedium()) Arrangement.spacedBy(4.dp) else Arrangement.SpaceBetween,
                    maxItemsInEachRow = if (isCompact() || isMedium()) 5 else 7
                ) {
                    modsAll.map {
                        ModImage(
                            mod = it,
                            onClick = {
                                onModClick(it, subcategoryOptions[selectedIndex.value])
                            }
                        )
                    }

                }
            }
            if (rest.isNotEmpty()) {
                item {
                    Spacer(modifier = Modifier.size(16.dp))
                    GearStylizedText(
                        text = "Others",
                    )
                    Divider(
                        modifier = Modifier.fillMaxWidth()
                            .padding(top = 8.dp, bottom = 16.dp),
                        color = WarborneColorTheme.borderSkillColor,
                        thickness = 1.dp
                    )
                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                        horizontalArrangement = if (isCompact() || isMedium()) Arrangement.spacedBy(4.dp) else Arrangement.SpaceEvenly,
                        maxItemsInEachRow = if (isCompact() || isMedium()) 3 else 4
                    ) {
                        rest.map {
                            if (it.type == ModType.ARMOR)
                                ModImage(
                                    mod = it,
                                    onClick = {
                                        onModClick(it, subcategoryOptions[selectedIndex.value])
                                    }
                                )
                            else
                                WeaponExclusiveMod(
                                    it,
                                    onModClick,
                                    subcategoryOptions,
                                    selectedIndex
                                )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun WeaponExclusiveMod(
    it: Mod,
    onModClick: (Mod, LoadoutType) -> Unit,
    subcategoryOptions: List<LoadoutType>,
    selectedIndex: MutableState<Int>
) {
    Row {
        WeaponImage(
            gearType = when (it.slot) {
                ModSlot.AXE -> GearType.AXE
                ModSlot.GUN -> GearType.GUN
                ModSlot.SWORD -> GearType.SWORD
                ModSlot.MACE -> GearType.MACE
                ModSlot.BOW -> GearType.BOW
                ModSlot.DAGGER -> GearType.DAGGER
                ModSlot.SPEAR -> GearType.SPEAR
                ModSlot.NATURE -> GearType.NATURE
                ModSlot.FIRE -> GearType.FIRE
                ModSlot.ICE -> GearType.FROST
                ModSlot.CURSE -> GearType.CURSE
                ModSlot.HOLY -> GearType.HOLY
                else -> GearType.SWORD
            }
        )
        Spacer(Modifier.size(8.dp))
        ModImage(
            mod = it,
            onClick = {
                onModClick(it, subcategoryOptions[selectedIndex.value])
            }
        )
    }
}