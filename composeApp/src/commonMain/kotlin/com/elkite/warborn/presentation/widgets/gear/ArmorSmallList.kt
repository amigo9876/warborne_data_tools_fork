package com.elkite.warborn.presentation.widgets.gear

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.items
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
import com.elkite.warborn.domain.entities.old.GearStats
import com.elkite.warborn.domain.entities.old.GearType
import com.elkite.warborn.domain.entities.old.LoadoutType
import com.elkite.warborn.domain.entities.old.spell.Spell
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText
import com.elkite.warborn.presentation.widgets.utils.isCompact
import com.elkite.warborn.presentation.widgets.utils.isMedium
import com.elkite.warborn.resources.Com_Clothes_Armor
import com.elkite.warborn.resources.Com_Head_Helmet
import com.elkite.warborn.resources.Com_Shoes_Boots
import com.elkite.warborn.resources.Com_Weapon_Sword
import com.elkite.warborn.resources.PropIcon_Agility
import com.elkite.warborn.resources.PropIcon_Intelligence
import com.elkite.warborn.resources.PropIcon_Strength
import com.elkite.warborn.resources.Res
import org.jetbrains.compose.resources.painterResource

@Composable
fun ArmorSmallList(
    modifier: Modifier = Modifier,
    loadoutType: LoadoutType,
    spellsHead: HashMap<GearStats, List<Spell>>,
    spellsChest: HashMap<GearStats, List<Spell>>,
    spellsBoots: HashMap<GearStats, List<Spell>>,
    onSpellClick: (Spell) -> Unit,
) {
    val subcategoryOptions = listOf(
        GearType.HEAD,
        GearType.CHEST,
        GearType.BOOTS
    )
    val selectedIndex = remember { mutableStateOf(0) }

    val currentSpells = derivedStateOf {
        when (subcategoryOptions[selectedIndex.value]) {
            GearType.HEAD -> spellsHead
            GearType.CHEST -> spellsChest
            GearType.BOOTS -> spellsBoots
            else -> emptyMap()
        }
    }
    val scrollState = rememberScrollState()

    LaunchedEffect(loadoutType) {
        selectedIndex.value = when (loadoutType) {
            LoadoutType.HEAD -> 0
            LoadoutType.CHEST -> 1
            LoadoutType.BOOTS -> 2
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
                                    GearType.HEAD -> Res.drawable.Com_Head_Helmet
                                    GearType.CHEST -> Res.drawable.Com_Clothes_Armor
                                    GearType.BOOTS -> Res.drawable.Com_Shoes_Boots
                                    else -> Res.drawable.Com_Weapon_Sword
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
                items(currentSpells.value.entries.toList()) { (title, spells) ->
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
                                   when (title) {
                                       GearStats.STR -> Res.drawable.PropIcon_Strength
                                        GearStats.AGI -> Res.drawable.PropIcon_Agility
                                        GearStats.INT -> Res.drawable.PropIcon_Intelligence
                                   }
                                ),
                                contentDescription = null,
                                modifier = Modifier.size(32.dp),
                            )
                            Spacer(Modifier.size(16.dp))
                            GearStylizedText(
                                text = title.naming,
                            )
                        }
                        Divider(
                            modifier = Modifier.fillMaxWidth()
                                .padding(top = 8.dp, bottom = 16.dp),
                            color = WarborneColorTheme.borderSkillColor,
                            thickness = 1.dp
                        )
                        FlowRow (
                            modifier = Modifier.fillMaxWidth().horizontalScroll(scrollState),
                            verticalArrangement = Arrangement.spacedBy(4.dp),
                            horizontalArrangement = if (isCompact() || isMedium()) Arrangement.spacedBy(4.dp) else Arrangement.SpaceBetween,
                            maxItemsInEachRow = if (isCompact() || isMedium())
                            5 else 7
                        ) {
                            spells.forEach { spell ->
                                ArmorImage(
                                    gearType = spell.associatedGearType,
                                    gearName = spell.gearName,
                                    rarity = spell.rarity,
                                    modifier = Modifier
                                        .size(64.dp)
                                        .clickable { onSpellClick(spell) }
                                )
                            }
                        }
                    }
                }
        }
    }
}