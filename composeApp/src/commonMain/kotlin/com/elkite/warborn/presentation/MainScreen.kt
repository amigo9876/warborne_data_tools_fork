package com.elkite.warborn.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabDisposable
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.elkite.warborn.presentation.tab.HomeTab
import com.elkite.warborn.presentation.tab.SecondTab
import io.github.aakira.napier.Napier

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
            Scaffold(
                content = { paddingValues ->
                    Napier.e { "Content" }

                    Column(Modifier.padding(paddingValues)) {
                        CurrentTab()
                    }
                },
                bottomBar = { BottomNavigationComponent() }
            )
        }
    }

    @Composable
    private fun BottomNavigationComponent() {
        BottomNavigation {
            TabNavigationItem(HomeTab)
            TabNavigationItem(SecondTab)
        }
    }

    @Composable
    private fun RowScope.TabNavigationItem(tab: Tab) {
        val tabNavigator = LocalTabNavigator.current

        BottomNavigationItem(
            selected = tabNavigator.current == tab,
            onClick = { tabNavigator.current = tab },
            icon = {
                tab.options.icon?.let { icon ->
                    Icon(painter = icon, contentDescription = tab.options.title)
                }
            }
        )
    }

}