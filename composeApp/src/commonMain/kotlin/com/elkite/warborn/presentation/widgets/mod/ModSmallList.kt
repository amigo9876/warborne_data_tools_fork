package com.elkite.warborn.presentation.widgets.mod

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonColors
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.elkite.warborn.presentation.theme.WarborneTheme
import com.elkite.warborn.presentation.widgets.gear.WeaponImage
import com.elkite.warborn.presentation.widgets.utils.GearStylizedCard
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText
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
    val scrollState = rememberScrollState()

    LaunchedEffect(loadoutType) {
        selectedIndex.value = when (loadoutType) {
            LoadoutType.MOD_HEAD -> 1
            LoadoutType.MOD_CHEST -> 2
            LoadoutType.MOD_BOOTS -> 3
            else -> 0
        }
    }


    Column(modifier = modifier) {
        SingleChoiceSegmentedButtonRow(
            modifier = Modifier.fillMaxWidth().padding(bottom = 4.dp),
        ) {
            subcategoryOptions.forEachIndexed { index, label ->
                SegmentedButton(
                    onClick = { selectedIndex.value = index },
                    selected = index == selectedIndex.value,
                    label = { when (label) {
                        LoadoutType.MOD_WEAPON -> Image(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(Res.drawable.Com_Weapon_Sword),
                            contentDescription = null,

                        )
                        LoadoutType.MOD_HEAD -> Image(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(Res.drawable.Com_Head_Helmet),
                            contentDescription = null,

                            )
                        LoadoutType.MOD_CHEST -> Image(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(Res.drawable.Com_Clothes_Armor),
                            contentDescription = null,

                            )
                        LoadoutType.MOD_BOOTS -> Image(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(Res.drawable.Com_Shoes_Boots),
                            contentDescription = null,

                            )
                        else -> Icon(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(Res.drawable.error_emoji),
                            contentDescription = null,
                        )
                    } },
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

        GearStylizedCard(
            modifier = Modifier.wrapContentHeight(),
            composable = {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {

                    val modsAll = currentMods.value.filter { it.slot == ModSlot.ALL }
                    val rest = currentMods.value.filter { it.slot != ModSlot.ALL }

                    Column(
                        modifier = Modifier.wrapContentHeight().fillMaxWidth().padding(16.dp),
                        verticalArrangement = Arrangement.Center,
                    ) {
                        GearStylizedText(
                            text = ModSlot.ALL.name.lowercase().capitalize(),
                            modifier = Modifier.padding(bottom = 8.dp)
                        )

                        FlowRow(
                            modifier = Modifier.fillMaxWidth().horizontalScroll(scrollState),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            maxItemsInEachRow = 4
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
                        if (rest.isNotEmpty()) {
                            GearStylizedText(
                                text = "Others",
                                modifier = Modifier.padding(bottom = 8.dp)
                            )

                            FlowRow(
                                modifier = Modifier.fillMaxWidth().horizontalScroll(scrollState),
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                verticalArrangement = Arrangement.spacedBy(8.dp),
                                maxItemsInEachRow = 4
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
                            }
                        }
                    }
                }
            }
        )
    }
}