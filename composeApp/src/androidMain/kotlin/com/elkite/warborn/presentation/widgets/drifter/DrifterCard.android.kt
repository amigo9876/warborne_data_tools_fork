package com.elkite.warborn.presentation.widgets.drifter

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.elkite.warborn.domain.entities.gear.drifter.Drifter

@Composable
actual fun DrifterCardList(
    modifier: Modifier,
    drifters: List<Drifter>,
    onDrifterClick: (Drifter) -> Unit,
    columnCount: Int
) {
    DrifterCardListCommon(
        modifier = modifier,
        drifters = drifters,
        onDrifterClick = onDrifterClick,
        columnCount = columnCount
    )
}