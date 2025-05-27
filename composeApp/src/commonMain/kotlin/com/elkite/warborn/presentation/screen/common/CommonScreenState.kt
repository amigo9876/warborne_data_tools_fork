package com.elkite.warborn.presentation.screen.common

import androidx.compose.foundation.layout.Column
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.elkite.warborn.presentation.screen.main.MainScreenModel
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText
import io.github.aakira.napier.Napier

@Composable
fun CommonScreenState(
    screenModel: MainScreenModel,
    content: @Composable (MainScreenModel.BuildScreenState.Success) -> Unit,
) {
    val pageState by screenModel.buildScreenState.collectAsState()

    when (pageState) {
        is MainScreenModel.BuildScreenState.Loading -> {
            Column {
                CircularProgressIndicator()
            }
        }

        is MainScreenModel.BuildScreenState.Success -> {
           content(pageState as MainScreenModel.BuildScreenState.Success)
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