package com.elkite.warborn.presentation.screen.information

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.rememberNavigatorScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.elkite.warborn.presentation.screen.common.CommonScreenState
import com.elkite.warborn.presentation.screen.information.common.InformationScreenCommon
import com.elkite.warborn.presentation.screen.main.MainScreenModel

class InformationScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = navigator.rememberNavigatorScreenModel { MainScreenModel() }

        CommonScreenState(
            screenModel = screenModel,
            content = { successState ->
                InformationScreenCommon(
                    successState
                )
            }
        )
    }
}