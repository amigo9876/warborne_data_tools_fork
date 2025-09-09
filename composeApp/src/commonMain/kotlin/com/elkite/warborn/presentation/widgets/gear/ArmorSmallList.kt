package com.elkite.warborn.presentation.widgets.gear

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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Divider
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonColors
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.common.Category
import com.elkite.warborn.domain.entities.data.Data
import com.elkite.warborn.domain.entities.gear.ArmorSlot
import com.elkite.warborn.domain.entities.gear.BootsGear
import com.elkite.warborn.domain.entities.gear.ChestGear
import com.elkite.warborn.domain.entities.gear.HeadGear
import com.elkite.warborn.domain.entities.gear.IGear
import com.elkite.warborn.domain.entities.loadout.Loadout
import com.elkite.warborn.domain.entities.loadout.SelectedLoadoutType
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.widgets.loadout.LoadoutBootsGearIcon
import com.elkite.warborn.presentation.widgets.loadout.LoadoutChestGearIcon
import com.elkite.warborn.presentation.widgets.loadout.LoadoutHeadGearIcon
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText
import com.elkite.warborn.presentation.widgets.utils.isCompact
import com.elkite.warborn.presentation.widgets.utils.isMedium
import com.elkite.warborn.resources.Com_Clothes_Armor
import com.elkite.warborn.resources.Com_Head_Helmet
import com.elkite.warborn.resources.Com_Shoes_Boots
import com.elkite.warborn.resources.PropIcon_Agility
import com.elkite.warborn.resources.PropIcon_Intelligence
import com.elkite.warborn.resources.PropIcon_Strength
import com.elkite.warborn.resources.Res
import org.jetbrains.compose.resources.painterResource

@Composable
fun ArmorSmallList(
    modifier: Modifier = Modifier,
    data: Data,
    loadout: Loadout,
    onUpdateHeadGear: (HeadGear) -> Unit,
    onUpdateChestGear: (ChestGear) -> Unit,
    onUpdateBootsGear: (BootsGear) -> Unit
) {
    val subcategoryOptions = listOf(
        ArmorSlot.HEAD,
        ArmorSlot.CHEST,
        ArmorSlot.BOOTS
    )
    val selectedIndex = remember { mutableStateOf(0) }
    val currentSpells = derivedStateOf {
        when (subcategoryOptions[selectedIndex.value]) {
            ArmorSlot.HEAD -> data.armors.head
            ArmorSlot.CHEST -> data.armors.chest
            ArmorSlot.BOOTS -> data.armors.boots
        }
    }

    LaunchedEffect(loadout.selectedLoadoutType) {
        selectedIndex.value = when (loadout.selectedLoadoutType) {
            SelectedLoadoutType.HEAD -> 0
            SelectedLoadoutType.CHEST -> 1
            SelectedLoadoutType.BOOTS -> 2
            else -> 0
        }
    }

    Column(modifier = modifier.fillMaxWidth())
    {
        SingleChoiceSegmentedButtonRow(
            modifier = Modifier.padding(bottom = 8.dp),
        ) {
            subcategoryOptions.forEachIndexed { index, label ->
                SegmentedButton(
                    onClick = { selectedIndex.value = index },
                    selected = index == selectedIndex.value,
                    label = {
                        Image(
                            painter = painterResource(
                                when (label) {
                                    ArmorSlot.HEAD -> Res.drawable.Com_Head_Helmet
                                    ArmorSlot.CHEST -> Res.drawable.Com_Clothes_Armor
                                    ArmorSlot.BOOTS -> Res.drawable.Com_Shoes_Boots
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

        LazyColumn(
            modifier = Modifier.wrapContentSize(),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            item {
                ArmorRow(
                    list = currentSpells.value.str,
                    category = Category.STR,
                    loadout = loadout,
                    onUpdateBoots = onUpdateBootsGear,
                    onUpdateChestGear = onUpdateChestGear,
                    onUpdateHeadGear = onUpdateHeadGear
                )
            }
            item {
                ArmorRow(
                    list = currentSpells.value.dex,
                    category = Category.AGI,
                    loadout = loadout,
                    onUpdateBoots = onUpdateBootsGear,
                    onUpdateChestGear = onUpdateChestGear,
                    onUpdateHeadGear = onUpdateHeadGear
                )
            }
            item {
                ArmorRow(
                    list = currentSpells.value.int,
                    category = Category.INT,
                    loadout = loadout,
                    onUpdateBoots = onUpdateBootsGear,
                    onUpdateChestGear = onUpdateChestGear,
                    onUpdateHeadGear = onUpdateHeadGear
                )
            }
        }
    }
}

@Composable
private fun ArmorRow(
    list: List<IGear>,
    category: Category,
    loadout: Loadout,
    onUpdateBoots: (BootsGear) -> Unit,
    onUpdateChestGear: (ChestGear) -> Unit,
    onUpdateHeadGear: (HeadGear) -> Unit
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start,
        ) {
            Image(
                painter = painterResource(
                    when (category) {
                        Category.STR -> Res.drawable.PropIcon_Strength
                        Category.AGI -> Res.drawable.PropIcon_Agility
                        Category.INT -> Res.drawable.PropIcon_Intelligence
                    }
                ),
                contentDescription = null,
                modifier = Modifier.size(32.dp),
            )
            Spacer(Modifier.size(16.dp))
            GearStylizedText(
                text = category.naming,
            )
        }
        Divider(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 8.dp, bottom = 16.dp),
            color = WarborneColorTheme.borderSkillColor,
            thickness = 1.dp
        )
        FlowRow(
            modifier = Modifier.fillMaxWidth().horizontalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = if (isCompact() || isMedium()) Arrangement.spacedBy(
                4.dp
            ) else Arrangement.SpaceBetween,
            maxItemsInEachRow = if (isCompact() || isMedium())
                5 else 7
        ) {
            list.forEach { spell ->
                when (spell) {
                    is HeadGear -> {
                        LoadoutHeadGearIcon(
                            headGear = spell,
                            onClick = {
                                onUpdateHeadGear(spell)
                            },
                            modifier = if (isCompact() || isMedium())
                                Modifier.size(32.dp) else Modifier.size(64.dp),
                            isSelected = loadout.selectedLoadoutType == SelectedLoadoutType.HEAD &&
                                    loadout.head?.spellId == spell.spellId,
                        )
                    }
                    is ChestGear -> {
                        LoadoutChestGearIcon(
                            chestGear = spell,
                            onClick = {
                                onUpdateChestGear(spell)
                            },
                            modifier = if (isCompact() || isMedium())
                                Modifier.size(32.dp) else Modifier.size(64.dp),
                            isSelected = loadout.selectedLoadoutType == SelectedLoadoutType.CHEST &&
                                    loadout.chest?.spellId == spell.spellId

                        )
                    }
                    is BootsGear -> {
                        LoadoutBootsGearIcon(
                            bootsGear = spell,
                            onClick = {
                                onUpdateBoots(spell)
                            },
                            modifier = if (isCompact() || isMedium())
                                Modifier.size(32.dp) else Modifier.size(64.dp),
                            isSelected = loadout.selectedLoadoutType == SelectedLoadoutType.BOOTS &&
                                    loadout.boots?.spellId == spell.spellId
                        )
                    }
                }
            }
        }
    }
}