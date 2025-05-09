package com.elkite.warborn.presentation.screen.main.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.NavigationRail
import androidx.compose.material.NavigationRailItem
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import com.elkite.warborn.presentation.tab.HomeTab
import com.elkite.warborn.presentation.tab.SecondTab

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

@Composable
private fun TabNavigationRailItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    NavigationRailItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        icon = {
            tab.options.icon?.let { icon ->
                Icon(painter = icon, contentDescription = tab.options.title)
            }
        }
    )
}

@Composable
private fun BottomNavigationComponent() {
    BottomNavigation {
        TabNavigationItem(HomeTab)
        TabNavigationItem(SecondTab)
    }
}


@Composable
fun MainContentWeb() {
    Scaffold(
        content = { paddingValues ->
            Row(Modifier.padding(paddingValues)) {
                NavigationRail {
                    TabNavigationRailItem(HomeTab)
                    TabNavigationRailItem(SecondTab)
                }
                Column(Modifier.weight(1f)) {
                    CurrentTab()
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainContentMobile() {
    Scaffold(
        content = { paddingValues ->

            BottomSheetNavigator {
                Column(Modifier.padding(paddingValues)) {
                    CurrentTab()
                }
            }
        },
        bottomBar = { BottomNavigationComponent() }
    )
}

@Composable
expect fun MainContent()