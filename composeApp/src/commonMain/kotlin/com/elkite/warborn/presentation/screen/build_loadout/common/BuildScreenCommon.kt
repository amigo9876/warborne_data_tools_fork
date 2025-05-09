package com.elkite.warborn.presentation.screen.build_loadout.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.domain.entities.gear.LoadoutType
import com.elkite.warborn.domain.entities.spell.SpellType
import com.elkite.warborn.presentation.screen.build_loadout.BuildScreenModel
import com.elkite.warborn.presentation.widgets.loadout.LoadoutCardList
import com.elkite.warborn.presentation.widgets.spell.SpellCardListGrid
import com.elkite.warborn.presentation.widgets.subcategory.SubCategoryList
import com.elkite.warborn.resources.CommonBg_New_Black
import com.elkite.warborn.resources.Res
import org.jetbrains.compose.resources.painterResource

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

    val showSubWeaponList = remember { mutableStateOf(false) }
    val currentWeaponType = remember { mutableStateOf(GearType.WEAPON) }

    Column(
        modifier = Modifier.fillMaxWidth().statusBarsPadding().paint(
            painterResource(Res.drawable.CommonBg_New_Black),
            contentScale = androidx.compose.ui.layout.ContentScale.FillBounds
        )
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            LoadoutCardList(modifier = Modifier.weight(1f), loadout) { loadoutType ->
                showSubWeaponList.value = false

                when (loadoutType) {
                    LoadoutType.HEAD -> screenModel.updateSpellsList(gearType = GearType.HEAD)
                    LoadoutType.CHEST -> screenModel.updateSpellsList(gearType = GearType.CHEST)
                    LoadoutType.BOOTS -> screenModel.updateSpellsList(gearType = GearType.BOOTS)
                    LoadoutType.WEAPON -> showSubWeaponList.value = true
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