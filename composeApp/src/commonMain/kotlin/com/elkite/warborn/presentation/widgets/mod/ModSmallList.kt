package com.elkite.warborn.presentation.widgets.mod

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import com.elkite.warborn.domain.entities.common.ModCategory
import com.elkite.warborn.domain.entities.data.DataMods
import com.elkite.warborn.domain.entities.data.WeaponType
import com.elkite.warborn.domain.entities.loadout.SelectedLoadoutType
import com.elkite.warborn.domain.entities.mod.IMod
import com.elkite.warborn.domain.entities.mod.ModSlot
import com.elkite.warborn.domain.entities.mod.ModType
import com.elkite.warborn.domain.entities.mod.WeaponMod
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.widgets.icons.ModIcon
import com.elkite.warborn.presentation.widgets.icons.WeaponSlotIcon
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText
import com.elkite.warborn.presentation.widgets.utils.isCompact
import com.elkite.warborn.presentation.widgets.utils.isMedium
import com.elkite.warborn.resources.Com_Clothes_Armor
import com.elkite.warborn.resources.Com_Head_Helmet
import com.elkite.warborn.resources.Com_Shoes_Boots
import com.elkite.warborn.resources.Com_Weapon_Sword
import com.elkite.warborn.resources.Res
import org.jetbrains.compose.resources.painterResource

@Composable
fun ModSmallList(
    modifier: Modifier = Modifier,
    selectedLoadoutType: SelectedLoadoutType,
    data: DataMods,
    onModClick: (ModCategory, IMod) -> Unit,
) {
    val subcategoryOptions = listOf(
        ModCategory.WEAPON,
        ModCategory.HEAD,
        ModCategory.CHEST,
        ModCategory.BOOTS,
    )
    val selectedIndex = remember { mutableStateOf(0) }
    val currentMods = derivedStateOf {
        when (subcategoryOptions[selectedIndex.value]) {
           ModCategory.WEAPON -> data.weapons
           ModCategory.HEAD-> data.armors.filter { it.slot == ModSlot.HEAD || it.slot == ModSlot.UNIVERSAL }
           ModCategory.CHEST -> data.armors.filter { it.slot == ModSlot.CHEST || it.slot == ModSlot.UNIVERSAL }
           ModCategory.BOOTS -> data.armors.filter { it.slot == ModSlot.BOOTS || it.slot == ModSlot.UNIVERSAL }
        }
    }
    val modsAll = currentMods.value.filter { it.slot == ModSlot.UNIVERSAL }
    val rest = currentMods.value.filter { it.slot != ModSlot.UNIVERSAL }

    LaunchedEffect(selectedLoadoutType) {
        selectedIndex.value = when (selectedLoadoutType) {
            SelectedLoadoutType.MOD_HEAD -> 1
            SelectedLoadoutType.MOD_CHEST -> 2
            SelectedLoadoutType.MOD_BOOTS -> 3
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
                            ModCategory.WEAPON -> Image(
                                modifier = Modifier.size(32.dp),
                                painter = painterResource(Res.drawable.Com_Weapon_Sword),
                                contentDescription = null,

                                )
                            ModCategory.HEAD -> Image(
                                modifier = Modifier.size(32.dp),
                                painter = painterResource(Res.drawable.Com_Head_Helmet),
                                contentDescription = null,

                                )
                            ModCategory.CHEST -> Image(
                                modifier = Modifier.size(32.dp),
                                painter = painterResource(Res.drawable.Com_Clothes_Armor),
                                contentDescription = null,

                                )
                            ModCategory.BOOTS -> Image(
                                modifier = Modifier.size(32.dp),
                                painter = painterResource(Res.drawable.Com_Shoes_Boots),
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
                    text = ModSlot.UNIVERSAL.name.lowercase().lowercase().capitalize(),
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
                        ModIcon(
                            modGameId = it.iconName,
                            modifier = Modifier.size(64.dp).clickable {
                                onModClick(subcategoryOptions[selectedIndex.value], it)
                            },
                            modType = it.type
                        )
                    }

                }
            }
            if (rest.isNotEmpty()) {
                item {
                    Spacer(modifier = Modifier.size(16.dp))
                    GearStylizedText(
                        text = subcategoryOptions[selectedIndex.value].name.lowercase().capitalize()
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
                                ModIcon(
                                    modGameId = it.iconName,
                                    modifier = Modifier.size(64.dp).clickable {
                                        onModClick(subcategoryOptions[selectedIndex.value], it)
                                    },
                                    modType = it.type
                                )
                            else
                                WeaponExclusiveMod(
                                    it as WeaponMod,
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
    it: WeaponMod,
    onModClick: (ModCategory, IMod) -> Unit,
    subcategoryOptions: List<ModCategory>,
    selectedIndex: MutableState<Int>
) {
    Row {
        WeaponSlotIcon(
            weaponType = when (it.slot) {
                ModSlot.AXE -> WeaponType.axe
                ModSlot.GUN -> WeaponType.gun
                ModSlot.SWORD -> WeaponType.sword
                ModSlot.MACE -> WeaponType.mace
                ModSlot.BOW -> WeaponType.bow
                ModSlot.DAGGER -> WeaponType.dagger
                ModSlot.SPEAR -> WeaponType.spear
                ModSlot.NATURE -> WeaponType.nature
                ModSlot.FIRE -> WeaponType.fire
                ModSlot.ICE -> WeaponType.frost
                ModSlot.CURSE -> WeaponType.curse
                ModSlot.HOLY -> WeaponType.holy
                else -> WeaponType.sword
            }
        )
        Spacer(Modifier.size(8.dp))
        ModIcon(
            modGameId = it.iconName,
            modifier = Modifier.size(64.dp).clickable {
                onModClick(subcategoryOptions[selectedIndex.value], it)
            },
            modType = it.type
        )
    }
}