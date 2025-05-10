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
import com.elkite.warborn.domain.entities.gear.Drifter
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.domain.entities.gear.LoadoutType
import com.elkite.warborn.domain.entities.spell.Spell
import com.elkite.warborn.domain.entities.spell.SpellType
import com.elkite.warborn.presentation.screen.build_loadout.BuildScreenModel
import com.elkite.warborn.presentation.widgets.drifter.DrifterCardList
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
    val drifters = screenModel.drifters.collectAsState()

    val showSubWeaponList = remember { mutableStateOf(false) }
    val currentWeaponType = remember { mutableStateOf(GearType.WEAPON) }
    val shouldShowBottomSheet = remember { mutableStateOf(false) }
    val shouldShowDrifters = remember { mutableStateOf(false) }

    LaunchedEffect(shouldShowBottomSheet.value) {
        if (shouldShowBottomSheet.value) {
            if (showSubWeaponList.value)
                showWeaponBottom(
                    bottomSheetNavigator,
                    GearType.entries.filter {
                        it !in listOf(
                            GearType.HEAD,
                            GearType.CHEST,
                            GearType.BOOTS,
                            GearType.WEAPON
                        )
                    }
                ) { gearType ->
                    showSubWeaponList.value = false
                    currentWeaponType.value = gearType
                    screenModel.updateSpellsList(gearType, SpellType.SKILL)
                    screenModel.updatePassive(gearType)
                    shouldShowBottomSheet.value = true

                }
            else if (shouldShowDrifters.value)
                showDriftersBottom(bottomSheetNavigator, drifters.value, screenModel)
            else
                showSpellBottom(bottomSheetNavigator, currentSpells, screenModel)
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
                    shouldShowBottomSheet = shouldShowBottomSheet,
                    shouldShowDrifters = shouldShowDrifters
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
    shouldShowBottomSheet: MutableState<Boolean>,
    shouldShowDrifters: MutableState<Boolean>
) {
    shouldShowDrifters.value = false
    showSubWeaponList.value = false

    when (loadoutType) {
        LoadoutType.HEAD -> updateAndShowBottomSheet(screenModel, GearType.HEAD, shouldShowBottomSheet)
        LoadoutType.CHEST -> updateAndShowBottomSheet(screenModel, GearType.CHEST, shouldShowBottomSheet)
        LoadoutType.BOOTS -> updateAndShowBottomSheet(screenModel, GearType.BOOTS, shouldShowBottomSheet)
        LoadoutType.WEAPON -> {
            showSubWeaponList.value = true
            updateAndShowBottomSheet(
                screenModel,
                GearType.WEAPON,
                shouldShowBottomSheet
            )
        }
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

        LoadoutType.DRIFTER -> {
            shouldShowDrifters.value = true
            updateAndShowBottomSheet(
                screenModel,
                GearType.DRIFTER,
                shouldShowBottomSheet
            )
        }
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

private fun showSpellBottom(
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

private fun showWeaponBottom(
    bottomSheetNavigator: BottomSheetNavigator,
    entries: List<GearType>,
    onClick: (GearType) -> Unit,
    ) {
    bottomSheetNavigator.show(
        SubCategoryListScreen(
            entries = entries,
            onClick = onClick
        )
    )
}

private fun showDriftersBottom(
    bottomSheetNavigator: BottomSheetNavigator,
    drifters: List<Drifter>,
    screenModel: BuildScreenModel
) {
    bottomSheetNavigator.show(
        DriftersScreen(
            drifters = drifters,
            onDrifterClick = { drifter ->
                screenModel.updateDrifter(drifter)
                bottomSheetNavigator.hide()
            }
        )
    )
}

private class SubCategoryListScreen(
    private val entries: List<GearType>,
    private val onClick: (GearType) -> Unit,
) : Screen {

    @Composable
    override fun Content() {
        SubCategoryList(
            entries = entries,
            onClick = onClick
        )
    }
}

private class DriftersScreen(
    private val drifters: List<Drifter>,
    private val onDrifterClick: (Drifter) -> Unit,
) : Screen {

    @Composable
    override fun Content() {
        DrifterCardList(
            drifters = drifters,
            onDrifterClick = onDrifterClick,
            columnCount = 1
        )
    }
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