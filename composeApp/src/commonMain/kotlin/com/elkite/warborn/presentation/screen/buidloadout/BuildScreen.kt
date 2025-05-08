package com.elkite.warborn.presentation.screen.buidloadout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.elkite.warborn.domain.entities.gear.Gear
import com.elkite.warborn.domain.entities.gear.Loadout
import com.elkite.warborn.domain.entities.spell.Spell

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
        val coroutineScope = rememberCoroutineScope()

        val loadout by screenModel.loadout.collectAsState()
        val spellsState by screenModel.spellsState.collectAsState()

        when (spellsState) {
            is BuildScreenModel.SpellsState.Loading -> {
                // Show a loading indicator
            }

            is BuildScreenModel.SpellsState.Success -> {
                SuccessScreen(
                    state = (spellsState as BuildScreenModel.SpellsState.Success),
                    onSpellClick = { spell ->
                       screenModel.updateLoadout(spell)
                    },
                    loadout = loadout,
                )
            }

            is BuildScreenModel.SpellsState.Error -> {
                val errorMessage = (spellsState as BuildScreenModel.SpellsState.Error).message
                // Show an error message
            }
        }
    }

    @Composable
    private fun SuccessScreen(
        loadout: Loadout,
        state: BuildScreenModel.SpellsState.Success,
        onSpellClick: (Spell) -> Unit,
    ) {
        val headVisibility = remember { mutableStateOf(false) }
        val chestVisibility = remember { mutableStateOf(false) }
        val bootsVisibility = remember { mutableStateOf(false) }

        val weaponVisibility = remember { mutableStateOf(false) }

        val swordVisibility = remember { mutableStateOf(false) }
        val gunVisibility = remember { mutableStateOf(false) }
        val axeVisibility = remember { mutableStateOf(false) }
        val maceVisibility = remember { mutableStateOf(false) }

        Row {
            LoadoutList(loadout, headVisibility, chestVisibility, bootsVisibility, weaponVisibility)

            Column {
                if (headVisibility.value)
                    SpellsList(state.head, headVisibility, onSpellClick)
                if (chestVisibility.value) {
                    SpellsList(state.chest, chestVisibility, onSpellClick)
                }
                if (bootsVisibility.value) {
                    SpellsList(state.boots, bootsVisibility, onSpellClick)
                }
                if (weaponVisibility.value) {
                    SpellsList(state.sword, swordVisibility, onSpellClick)
                    SpellsList(state.gun, gunVisibility, onSpellClick)
                    SpellsList(state.axe, axeVisibility, onSpellClick)
                    SpellsList(state.mace, maceVisibility, onSpellClick)
                }
            }
        }
    }


    @Composable
    private fun LoadoutList(
        loadout: Loadout,
        headVisibility: MutableState<Boolean>,
        chestVisibility: MutableState<Boolean>,
        bootsVisibility: MutableState<Boolean>,
        weaponVisibility: MutableState<Boolean>
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            LoadoutCard(headVisibility, Color.Red, loadout.head)
            Spacer(modifier = Modifier.size(16.dp))
            LoadoutCard(chestVisibility, Color.Blue, loadout.chest)
            Spacer(modifier = Modifier.size(16.dp))
            LoadoutCard(bootsVisibility, Color.Green, loadout.boots)
            Spacer(modifier = Modifier.size(16.dp))
            LoadoutCard(weaponVisibility, Color.Yellow, loadout.weapon)
        }
    }

    @Composable
    private fun LoadoutCard(visibility: MutableState<Boolean>, color: Color, gear: Gear?) {
        Box(modifier = Modifier.size(64.dp).clickable {
            visibility.value = !visibility.value
        }) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Home",
                modifier = Modifier.size(64.dp),
                tint = color
            )
            gear?.let {
                Text(gear.spell.name)
            }

        }
    }

    @Composable
    private fun ColumnScope.SpellsList(
        spells: List<Spell>,
        headVisibility: MutableState<Boolean>,
        onSpellClick: (Spell) -> Unit
    ) {
        Card {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                spells.map {
                    SpellCard( onSpellClick, headVisibility, it)
                }
            }
        }
    }

    @Composable
    private fun ColumnScope.SpellCard(
        onSpellClick: (Spell) -> Unit,
        headVisibility: MutableState<Boolean>,
        it: Spell
    ) {
        Card(modifier = Modifier.padding(8.dp).clickable {
            headVisibility.value = false
            onSpellClick(it)
        }) {
            Column {
                Row {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Home",
                        modifier = Modifier.size(64.dp)
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                    Text(
                        text = it.name,
                        modifier = Modifier.clickable { }
                    )

                }
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = it.description,
                )
            }
        }
    }
}