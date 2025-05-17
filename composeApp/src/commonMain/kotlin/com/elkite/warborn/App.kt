package com.elkite.warborn

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.NavigationRail
import androidx.compose.material.NavigationRailItem
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabDisposable
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.elkite.warborn.presentation.tab.HomeTab
import com.elkite.warborn.presentation.tab.SecondTab
import com.elkite.warborn.presentation.theme.WarborneTheme
import com.elkite.warborn.resources.Enhancement_img_bg_2
import com.elkite.warborn.resources.Res
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    Napier.base(DebugAntilog())

    MaterialTheme {
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
                    Row(Modifier.padding(paddingValues)) {
                        NavigationRail(
                            backgroundColor = WarborneTheme.textBackgroundColor
                        ) {
                            TabNavigationRailItem(HomeTab)
                            TabNavigationRailItem(SecondTab)
                        }
                        Column(
                            modifier = Modifier.fillMaxSize()
                                .paint(
                                    painterResource(Res.drawable.Enhancement_img_bg_2),
                                    contentScale = androidx.compose.ui.layout.ContentScale.FillBounds
                                ).padding(paddingValues)
                        ) {
                            CurrentTab()
                        }
                    }
                })
        }
    }
}

@Composable
fun TabNavigationRailItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    NavigationRailItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        icon = {
            tab.options.icon?.let { icon ->
                Icon(painter = icon, contentDescription = tab.options.title)
            }
        },
        unselectedContentColor = WarborneTheme.textDescriptionColor,
        selectedContentColor = WarborneTheme.textShieldColor
    )
}
