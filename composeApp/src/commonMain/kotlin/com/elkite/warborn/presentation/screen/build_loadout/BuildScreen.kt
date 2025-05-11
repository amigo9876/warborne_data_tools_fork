package com.elkite.warborn.presentation.screen.build_loadout

import androidx.compose.foundation.layout.Column
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.elkite.warborn.presentation.screen.build_loadout.common.BuildScreenContent
import io.github.aakira.napier.Napier

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
                Column {
                    CircularProgressIndicator()
                }
            }

            is BuildScreenModel.SpellsState.Success -> {
//                BuildScreenContent(
//                    screenModel,
//                )

                BuildScreenContent(
                    screenModel,
                    pageState as BuildScreenModel.SpellsState.Success,
                )
            }

            is BuildScreenModel.SpellsState.Error -> {
                val errorMessage = (pageState as BuildScreenModel.SpellsState.Error).message
                Napier.e { errorMessage }
                // Show an error message
                Column {
                    Text(errorMessage)
                }
            }
        }
    }
}