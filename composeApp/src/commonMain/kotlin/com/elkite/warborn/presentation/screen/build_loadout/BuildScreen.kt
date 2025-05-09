package com.elkite.warborn.presentation.screen.build_loadout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.elkite.warborn.presentation.screen.build_loadout.common.BuildScreenContent

class BuildScreen : Screen {
    override val key: String
        get() = "BuildScreen"

    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel { BuildScreenModel() }
        val navigator = LocalNavigator.currentOrThrow

        BuildScreenState(
            screenModel,
            navigator,
        )
    }

    @Composable
    fun BuildScreenState(
        screenModel: BuildScreenModel,
        navigator: Navigator,
    ) {
        val pageState by screenModel.spellsState.collectAsState()

        when (pageState) {
            is BuildScreenModel.SpellsState.Loading -> {

            }

            is BuildScreenModel.SpellsState.Success -> {
                BuildScreenContent(
                    screenModel,
                )
            }

            is BuildScreenModel.SpellsState.Error -> {
                val errorMessage = (pageState as BuildScreenModel.SpellsState.Error).message
                // Show an error message
            }
        }
    }
}