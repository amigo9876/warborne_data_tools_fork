package com.elkite.warborn.presentation.screen.build_loadout.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.domain.entities.gear.LoadoutType
import com.elkite.warborn.domain.entities.spell.SpellType
import com.elkite.warborn.presentation.screen.build_loadout.BuildScreenModel
import com.elkite.warborn.presentation.widgets.drifter.DrifterCardList
import com.elkite.warborn.presentation.widgets.loadout.LoadoutCardList
import com.elkite.warborn.presentation.widgets.loadout_from_url.LoadoutFromUrl
import com.elkite.warborn.presentation.widgets.spell.SpellCardListGrid
import com.elkite.warborn.presentation.widgets.spell.SpellCardListSmall
import com.elkite.warborn.presentation.widgets.subcategory.SubCategoryList

@Composable
expect fun BuildScreenContent(
    screenModel: BuildScreenModel
)

@Composable
fun BuildScreenContentLarge(
    screenModel: BuildScreenModel
) {
    val currentSpells by screenModel.currentSpells.collectAsState()
    val loadout by screenModel.loadout.collectAsState()
    val drifters by screenModel.drifters.collectAsState()

    val showSubWeaponList = remember { mutableStateOf(false) }
    val currentWeaponType = remember { mutableStateOf(GearType.WEAPON) }
    val showDrifters = remember { mutableStateOf(false) }

    LoadoutFromUrl(screenModel, loadout)


    Column {
        Row(modifier = Modifier.fillMaxSize()) {
            LoadoutCardList(modifier = Modifier.weight(1f), loadout) { loadoutType ->
                showSubWeaponList.value = false
                showDrifters.value = false

                when (loadoutType) {
                    LoadoutType.HEAD -> screenModel.updateSpellsList(gearType = GearType.HEAD)
                    LoadoutType.CHEST -> screenModel.updateSpellsList(gearType = GearType.CHEST)
                    LoadoutType.BOOTS -> screenModel.updateSpellsList(gearType = GearType.BOOTS)
                    LoadoutType.WEAPON -> {
                        screenModel.updateSpellsList(gearType = GearType.WEAPON)
                        showSubWeaponList.value = true
                    }
                    LoadoutType.DRIFTER -> {
                        screenModel.updateSpellsList(gearType = GearType.DRIFTER)
                        showDrifters.value = true
                    }
                    LoadoutType.PASSIVE -> screenModel.updateSpellsList(
                        gearType = currentWeaponType.value,
                        spellType = SpellType.PASSIVE
                    )

                    LoadoutType.COMMON_SKILL -> screenModel.updateSpellsList(
                        gearType = currentWeaponType.value,
                        spellType = SpellType.COMMON_SKILL
                    )

                    LoadoutType.BASIC_ATTACK -> screenModel.updateSpellsList(
                        gearType = currentWeaponType.value,
                        spellType = SpellType.BASIC_ATTACK
                    )
                }
            }
            Spacer(modifier = Modifier.size(16.dp))
            if (showSubWeaponList.value)
                SubCategoryList(
                    entries = GearType.entries.filter {
                        it !in listOf(
                            GearType.HEAD,
                            GearType.CHEST,
                            GearType.BOOTS,
                            GearType.WEAPON
                        )
                    },
                    onClick = { gearType ->
                        showSubWeaponList.value = false
                        currentWeaponType.value = gearType
                        screenModel.updateSpellsList(gearType, SpellType.SKILL)
                        screenModel.updatePassive(gearType)
                    }
                )
            Spacer(modifier = Modifier.size(16.dp))
            if (!showSubWeaponList.value  && !showDrifters.value && currentSpells.isEmpty()) {
                SpellCardListSmall(
                    modifier = Modifier.weight(1f),
                    spells = loadout.getSpells(),
                    onSpellClick = { }
                )
                Spacer(Modifier.weight(1f))
            }
            else if (showDrifters.value) {
                DrifterCardList(
                    modifier = Modifier.weight(2f),
                    drifters = drifters,
                    onDrifterClick = { drifter ->
                        showDrifters.value = false
                        screenModel.updateDrifter(drifter)
                    }
                )
            } else {
                SpellCardListGrid(
                    modifier = Modifier.weight(2f),
                    spells = currentSpells,
                    onSpellClick = { spell ->
                        screenModel.updateLoadout(spell)
                        screenModel.resetSpellsList()
                    })
            }
        }
    }
}