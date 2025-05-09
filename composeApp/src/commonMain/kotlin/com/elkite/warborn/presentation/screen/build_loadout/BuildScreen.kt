package com.elkite.warborn.presentation.screen.build_loadout

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.domain.entities.gear.LoadoutType
import com.elkite.warborn.domain.entities.spell.SpellType
import com.elkite.warborn.presentation.widgets.loadout.LoadoutCardList
import com.elkite.warborn.presentation.widgets.spell.SpellCardList
import com.elkite.warborn.util.IconMap
import org.jetbrains.compose.resources.painterResource

class BuildScreen : Screen {
    override val key: String
        get() = "BuildScreen"

    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel { BuildScreenModel() }
        val navigator = LocalNavigator.currentOrThrow

        BuildScreenContent(
            screenModel,
            navigator,
        )
    }

    @Composable
    fun BuildScreenContent(
        screenModel: BuildScreenModel,
        navigator: Navigator,
    ) {
        val pageState by screenModel.spellsState.collectAsState()

        when (pageState) {
            is BuildScreenModel.SpellsState.Loading -> {
                // Show a loading indicator
            }

            is BuildScreenModel.SpellsState.Success -> {
                SuccessScreen(screenModel)
            }

            is BuildScreenModel.SpellsState.Error -> {
                val errorMessage = (pageState as BuildScreenModel.SpellsState.Error).message
                // Show an error message
            }
        }
    }

    @Composable
    private fun SuccessScreen(
        screenModel: BuildScreenModel
    ) {
        val currentSpells by screenModel.currentSpells.collectAsState()
        val loadout by screenModel.loadout.collectAsState()

        val showSubWeaponList = remember { mutableStateOf(false) }
        val currentWeaponType = remember { mutableStateOf(GearType.WEAPON) }

        Row(modifier = Modifier.background(color = Color.DarkGray).fillMaxSize()) {
            LoadoutCardList(loadout, onClick = { loadoutType ->
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
            })

            Column {
                SpellCardList(
                    currentSpells,
                    onSpellClick = {
                        screenModel.updateLoadout(it)
                        screenModel.resetSpellsList()
                    },
                )
                Spacer(modifier = Modifier.size(16.dp))

                if (showSubWeaponList.value) {
                    WeaponTypeList(
                        onClick = { gearType ->
                            showSubWeaponList.value = false
                            currentWeaponType.value = gearType
                            screenModel.updateSpellsList(gearType, SpellType.SKILL)
                            screenModel.updatePassive(gearType)
                        }
                    )
                }
            }

        }
    }

    @Composable
    private fun WeaponTypeList(
        onClick: (GearType) -> Unit,
    ) {
        Column {
            Card {
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    GearType.entries.filter { it !in listOf(GearType.HEAD, GearType.CHEST, GearType.BOOTS, GearType.WEAPON) }
                        .forEach { gearType ->
                            Card(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .clickable {
                                        onClick(gearType)
                                    }
                            ) {
                                Icon(
                                    painter = painterResource(IconMap.getWeaponIcon(gearType)),
                                    contentDescription = "Home",
                                    modifier = Modifier.size(64.dp),
                                    tint = Color.Unspecified
                                )
                            }
                        }
                }
            }
        }
    }
}