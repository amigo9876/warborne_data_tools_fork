package com.elkite.warborn.presentation.widgets.gear

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.domain.entities.gear.spell.Spell
import com.elkite.warborn.domain.entities.gear.spell.SpellType
import com.elkite.warborn.presentation.widgets.utils.GearStylizedCardRow

@Composable
fun WeaponSmallList(
    spells: HashMap<GearType, List<Spell>>,
    onSpellClick: (Spell) -> Unit,
    columnCount: Int = 1,
    modifier: Modifier = Modifier,
) {
    val selectedGearType = remember { mutableStateOf(GearType.SWORD) }

    val filteredSpells by remember {
        derivedStateOf {
            spells[selectedGearType.value]?.filter { spell ->
                spell.type == SpellType.SKILL
            }
        }
    }

    Row(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        LazyVerticalGrid(
            modifier = modifier.weight(1f),
            columns = GridCells.Fixed(columnCount),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            items(spells.keys.toList()) { gearType ->
                WeaponCategorySmallListItem(
                    gearType = gearType,
                    onCategoryClick = {
                        selectedGearType.value = gearType
                        filteredSpells?.first()?.let {
                            onSpellClick(it)
                        }
                    },
                )
            }
        }

        Spacer(Modifier.size(8.dp))

        LazyVerticalGrid(
            modifier = modifier.weight(1f),
            columns = GridCells.Fixed(columnCount),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            items(items = filteredSpells ?: listOf()) { spell ->
                WeaponSmallListItem(
                    spell = spell,
                    onSpellClick = onSpellClick,
                )
            }
        }
    }
}


@Composable
private fun WeaponCategorySmallListItem(
    gearType: GearType,
    onCategoryClick: (GearType) -> Unit,
) {
    GearStylizedCardRow(
        onClick = {
            onCategoryClick(gearType)
        },
        text = gearType.name,
        composable = {
            WeaponImage(
                gearType = gearType,
                modifier = Modifier.size(64.dp)
            )
        }
    )
}

@Composable
private fun WeaponSmallListItem(
    spell: Spell,
    onSpellClick: (Spell) -> Unit,
) {
    GearStylizedCardRow(
        onClick = {
            onSpellClick(spell)
        },
        text = spell.gearName ?: "",
        composable = {
            ArmorImage(
                spell = spell,
                modifier = Modifier.size(64.dp)
            )
        }
    )
}