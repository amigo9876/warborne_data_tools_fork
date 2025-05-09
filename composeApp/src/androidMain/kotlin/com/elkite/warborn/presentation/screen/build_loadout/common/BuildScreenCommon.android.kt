package com.elkite.warborn.presentation.screen.build_loadout.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.domain.entities.gear.LoadoutType
import com.elkite.warborn.domain.entities.spell.Spell
import com.elkite.warborn.domain.entities.spell.SpellType
import com.elkite.warborn.presentation.screen.build_loadout.BuildScreenModel
import com.elkite.warborn.presentation.widgets.loadout.LoadoutCardList
import com.elkite.warborn.presentation.widgets.spell.SpellCardList
import com.elkite.warborn.presentation.widgets.subcategory.SubCategoryList
import com.elkite.warborn.resources.CommonBg_New_Black
import com.elkite.warborn.resources.Res
import org.jetbrains.compose.resources.painterResource

@Composable
actual fun BuildScreenContent(screenModel: BuildScreenModel) {
    val currentSpells by screenModel.currentSpells.collectAsState()
    val loadout by screenModel.loadout.collectAsState()
    val bottomSheetNavigator = LocalBottomSheetNavigator.current

    val showSubWeaponList = remember { mutableStateOf(false) }
    val currentWeaponType = remember { mutableStateOf(GearType.WEAPON) }
    val shouldShowBottomSheet = remember { mutableStateOf(false) }

    LaunchedEffect(currentSpells, shouldShowBottomSheet.value) {
        if (shouldShowBottomSheet.value) {
            showBottomSheet(bottomSheetNavigator, currentSpells, screenModel)
            shouldShowBottomSheet.value = false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .paint(
                painterResource(Res.drawable.CommonBg_New_Black),
                contentScale = androidx.compose.ui.layout.ContentScale.FillBounds
            )
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            LoadoutCardList(loadout = loadout) { loadoutType ->
                handleLoadoutClick(
                    loadoutType = loadoutType,
                    screenModel = screenModel,
                    currentWeaponType = currentWeaponType,
                    showSubWeaponList = showSubWeaponList,
                    shouldShowBottomSheet = shouldShowBottomSheet
                )
            }
            Spacer(modifier = Modifier.size(16.dp))
            if (showSubWeaponList.value) {
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
                        shouldShowBottomSheet.value = true
                    }
                )
            }
        }
    }
}

private fun handleLoadoutClick(
    loadoutType: LoadoutType,
    screenModel: BuildScreenModel,
    currentWeaponType: MutableState<GearType>,
    showSubWeaponList: MutableState<Boolean>,
    shouldShowBottomSheet: MutableState<Boolean>
) {
    when (loadoutType) {
        LoadoutType.HEAD -> updateAndShowBottomSheet(screenModel, GearType.HEAD, shouldShowBottomSheet)
        LoadoutType.CHEST -> updateAndShowBottomSheet(screenModel, GearType.CHEST, shouldShowBottomSheet)
        LoadoutType.BOOTS -> updateAndShowBottomSheet(screenModel, GearType.BOOTS, shouldShowBottomSheet)
        LoadoutType.WEAPON -> showSubWeaponList.value = true
        LoadoutType.PASSIVE -> updateAndShowBottomSheet(
            screenModel,
            currentWeaponType.value,
            shouldShowBottomSheet,
            SpellType.PASSIVE
        )
        LoadoutType.COMMON_SKILL -> updateAndShowBottomSheet(
            screenModel,
            currentWeaponType.value,
            shouldShowBottomSheet,
            SpellType.COMMON_SKILL
        )
        LoadoutType.BASIC_ATTACK -> updateAndShowBottomSheet(
            screenModel,
            currentWeaponType.value,
            shouldShowBottomSheet,
            SpellType.BASIC_ATTACK
        )
    }
}

private fun updateAndShowBottomSheet(
    screenModel: BuildScreenModel,
    gearType: GearType,
    shouldShowBottomSheet: MutableState<Boolean>,
    spellType: SpellType? = null
) {
    screenModel.updateSpellsList(gearType, spellType)
    shouldShowBottomSheet.value = true
}

private fun showBottomSheet(
    bottomSheetNavigator: BottomSheetNavigator,
    currentSpells: List<Spell>,
    screenModel: BuildScreenModel
) {
    bottomSheetNavigator.show(
        SpellsScreen(
            spells = currentSpells,
            onSpellClick = { spell ->
                screenModel.updateLoadout(spell)
                bottomSheetNavigator.hide()
            }
        )
    )
}

private class SpellsScreen(
    private val spells: List<Spell>,
    private val onSpellClick: (Spell) -> Unit,
) : Screen {

    @Composable
    override fun Content() {
        SpellCardList(
            spells = spells,
            onSpellClick = onSpellClick
        )
    }
}