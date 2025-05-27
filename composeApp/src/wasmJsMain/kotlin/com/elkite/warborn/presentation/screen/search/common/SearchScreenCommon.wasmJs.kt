package com.elkite.warborn.presentation.screen.search.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.layout.ThreePaneScaffoldPaneScope
import androidx.compose.material3.adaptive.navigation.ThreePaneScaffoldNavigator
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowWidthSizeClass
import com.elkite.warborn.domain.entities.gear.GearMainCategory
import com.elkite.warborn.presentation.screen.main.MainScreenModel
import com.elkite.warborn.presentation.widgets.drifter.DrifterIcon
import com.elkite.warborn.presentation.widgets.mod.ModImage
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
actual fun SearchScreenCommon(state: MainScreenModel.BuildScreenState.Success) {
    val scaffoldNavigator = rememberListDetailPaneScaffoldNavigator<GearMainCategory>()
    val coroutinescope = rememberCoroutineScope()


    ListDetailPaneScaffold(
        directive = scaffoldNavigator.scaffoldDirective,
        value = scaffoldNavigator.scaffoldValue,
        modifier = Modifier.fillMaxSize(),
        listPane = {
            GearCategoryPane(
                onClick = { category ->
                    coroutinescope.launch {
                        scaffoldNavigator.navigateTo(
                            pane = ListDetailPaneScaffoldRole.Detail,
                            contentKey = category
                        )
                    }
                }
            )
        },
        detailPane = {
            GearCategoryDetail(
                state = state,
                navigator = scaffoldNavigator,
                onClick = {
                    coroutinescope.launch {
                        scaffoldNavigator.navigateTo(
                            pane = ListDetailPaneScaffoldRole.List,
                            contentKey = null
                        )
                    }
                }
            )
        }
    )
}

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun ThreePaneScaffoldPaneScope.GearCategoryDetail(
    state: MainScreenModel.BuildScreenState.Success,
    navigator: ThreePaneScaffoldNavigator<GearMainCategory>,
    onClick: () -> Unit
) {
    val isCompact = currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.MEDIUM ||
            currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.COMPACT

    AnimatedPane {


        when (navigator.currentDestination?.contentKey) {
            GearMainCategory.DRIFTER -> {
                LazyVerticalGrid(
                    modifier = Modifier,
                    columns = GridCells.Fixed(3),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    items(state.drifters) { drifter ->
                        DrifterIcon(
                            drifterId = drifter.gameId
                        )
                    }
                }
            }

            GearMainCategory.WEAPON -> {}
            GearMainCategory.ARMOR -> {}
            GearMainCategory.MOD -> {
                LazyVerticalGrid(
                    modifier = Modifier,
                    columns = GridCells.Fixed(3),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    stickyHeader {
                        if (isCompact) {
                            Button(
                                modifier = Modifier.padding(16.dp),
                                onClick = {
                                    onClick()
                                }
                            ) {
                                GearStylizedText(
                                    text = "Back",
                                    modifier = Modifier.padding(8.dp)
                                )
                            }
                        }
                    }
                    items(state.mods) { drifter ->
                        ModImage(
                            mod = drifter
                        )
                    }
                }
            }
            null -> GearStylizedText(text = "Select a category")
        }
    }
}

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun ThreePaneScaffoldPaneScope.GearCategoryPane(
    onClick: (GearMainCategory) -> Unit,
) {
    AnimatedPane {
        LazyColumn(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(GearMainCategory.entries.toTypedArray()) { category ->
                GearStylizedText(
                    text = category.name,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                        .clickable {
                            onClick(category)
                        }
                )
            }
        }
    }
}