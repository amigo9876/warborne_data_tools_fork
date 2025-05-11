package com.elkite.warborn.presentation.widgets.drifter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.drifter.Drifter
import com.elkite.warborn.presentation.widgets.gear.GearStylizedRow

@Composable
fun DrifterSmallList(
    drifters: List<Drifter>,
    onDrifterClick: (Drifter) -> Unit,
    columnCount: Int = 3,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        modifier = modifier.padding(16.dp),
        columns = GridCells.Fixed(columnCount),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items(drifters) { drifter ->
            DrifterSmallListItem(
                drifter = drifter,
                onDrifterClick = onDrifterClick,
            )
        }
    }
}

@Composable
private fun DrifterSmallListItem(
    drifter: Drifter,
    onDrifterClick: (Drifter) -> Unit,
) {

    GearStylizedRow(
        rowOnClick = {
            onDrifterClick(drifter)
        },
        text = drifter.name,
        composable = {
            DrifterIcon(
                modifier = Modifier.size(64.dp),
                drifter = drifter,
            )
        }
    )
}