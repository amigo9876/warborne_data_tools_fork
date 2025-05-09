package com.elkite.warborn.presentation.screen.main

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.TabDisposable
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.elkite.warborn.presentation.screen.main.common.MainContent
import com.elkite.warborn.presentation.tab.HomeTab
import com.elkite.warborn.presentation.tab.SecondTab

object MainScreen : Screen {

    @Composable
    override fun Content() {
        TabNavigator(
            HomeTab,
            tabDisposable = {
                TabDisposable(
                    navigator = it,
                    tabs = listOf(HomeTab, SecondTab)
                )
            }
        ) {
            MainContent()
        }
    }
}

