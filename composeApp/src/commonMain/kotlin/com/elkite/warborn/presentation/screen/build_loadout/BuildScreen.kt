package com.elkite.warborn.presentation.screen.build_loadout

import androidx.compose.foundation.layout.Column
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import com.elkite.warborn.presentation.screen.build_loadout.common.BuildScreenContent
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText
import io.github.aakira.napier.Napier

class BuildScreen : Screen {
    override val key: String
        get() = "BuildScreen"

    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel { BuildScreenModel() }

        BuildScreenState(
            screenModel,
        )
    }

    @Composable
    fun BuildScreenState(
        screenModel: BuildScreenModel,
    ) {
        val pageState by screenModel.buildScreenState.collectAsState()

        when (pageState) {
            is BuildScreenModel.BuildScreenState.Loading -> {
                Column {
                    CircularProgressIndicator()
                }
            }

            is BuildScreenModel.BuildScreenState.Success -> {
                BuildScreenContent(
                    screenModel,
                    pageState as BuildScreenModel.BuildScreenState.Success,
                )
            }

            is BuildScreenModel.BuildScreenState.Error -> {
                val errorMessage = (pageState as BuildScreenModel.BuildScreenState.Error).message
                Napier.e { errorMessage }
                // Show an error message
                Column {
                    GearStylizedText(text = errorMessage)
                }
            }
        }
    }
}