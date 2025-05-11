package com.elkite.warborn.presentation.widgets.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
actual fun ScreenScaffoldCommon(
    modifier: Modifier,
    first: @Composable () -> Unit,
    second: @Composable () -> Unit,
    third: @Composable () -> Unit
) {
    ScreenScaffoldSplitLarge(
        modifier = modifier,
        first = first,
        second = second,
        third = third
    ))
}