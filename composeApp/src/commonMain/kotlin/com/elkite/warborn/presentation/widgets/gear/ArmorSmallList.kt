package com.elkite.warborn.presentation.widgets.gear

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
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
import com.elkite.warborn.domain.entities.gear.GearStats
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.domain.entities.gear.LoadoutType
import com.elkite.warborn.domain.entities.gear.spell.Spell
import com.elkite.warborn.presentation.theme.WarborneTheme
import com.elkite.warborn.presentation.widgets.utils.GearStylizedCard
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText
import com.elkite.warborn.presentation.widgets.utils.GearStylizedTextTitle

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


    Column(modifier = modifier) {
        SingleChoiceSegmentedButtonRow(
            modifier = Modifier.fillMaxWidth().padding(bottom = 4.dp),
        ) {
            subcategoryOptions.forEachIndexed { index, label ->
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

        GearStylizedCard(
            modifier = Modifier.wrapContentHeight(),
            composable = {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    currentSpells.value.forEach { (title, spells) ->
                        Column(
                            modifier = Modifier.wrapContentHeight().fillMaxWidth().padding(16.dp),
                            verticalArrangement = Arrangement.Center,
                        ) {
                            GearStylizedTextTitle(
                                text = title.naming,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth().horizontalScroll(scrollState),
                                horizontalArrangement = Arrangement.SpaceBetween
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
            })
    }
}