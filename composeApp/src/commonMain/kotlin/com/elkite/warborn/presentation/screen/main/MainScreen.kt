package com.elkite.warborn.presentation.screen.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import com.elkite.warborn.presentation.screen.main.common.MainContent
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText
import io.github.aakira.napier.Napier

object MainScreen : Screen {

    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel { MainScreenModel() }

        BuildScreenState(screenModel)
    }

    @Composable
    fun BuildScreenState(
        screenModel: MainScreenModel,
    ) {
        val pageState by screenModel.buildScreenState.collectAsState()

        when (pageState) {
            is MainScreenModel.BuildScreenState.Loading -> {
                Column {
                    CircularProgressIndicator()
                }
            }

            is MainScreenModel.BuildScreenState.Success -> {
                MainContent(
                    screenModel,
                    pageState as MainScreenModel.BuildScreenState.Success,
                )
            }

            is MainScreenModel.BuildScreenState.Error -> {
                val errorMessage = (pageState as MainScreenModel.BuildScreenState.Error).message
                Napier.e { errorMessage }
                Column {
                    GearStylizedText(text = errorMessage)
                }
            }
        }
    }
}

