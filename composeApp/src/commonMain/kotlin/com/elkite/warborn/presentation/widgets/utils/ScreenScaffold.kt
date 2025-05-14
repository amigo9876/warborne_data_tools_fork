package com.elkite.warborn.presentation.widgets.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator

@Composable
fun ScreenScaffoldSplitLarge(
    modifier: Modifier = Modifier,
    first: @Composable () -> Unit,
    second: @Composable () -> Unit,
    third: @Composable () -> Unit
) {
    Box {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            GearStylizedText(
                text = "This app is not affiliated with or endorsed by QOOLAND",
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(Modifier.size(16.dp))
        }

        Column {
            Row {
                Column(modifier = Modifier.weight(1f)) {
                    first()
                }
                Spacer(modifier = Modifier.size(16.dp))
                Column(modifier = Modifier.weight(1f)) {
                    second()
                }
                Spacer(modifier = Modifier.size(16.dp))
                Column(modifier = Modifier.weight(1f)) {
                    third()
                }
            }
        }
    }
}

@Composable
fun ScreenScaffoldSplitSmall(
    modifier: Modifier = Modifier,
    first: @Composable () -> Unit,
    second: @Composable () -> Unit,
    third: @Composable () -> Unit
) {
    val bottomSheetNavigator = LocalBottomSheetNavigator.current

    Row(modifier = modifier) {
        Column(modifier = Modifier.weight(1f)) {
            first()
        }
    }
}

private class ScreenScaffoldSplitSmallBottomSheet(
    val composable: @Composable () -> Unit,
) : Screen {

    @Composable
    override fun Content() {
        composable()
    }

}