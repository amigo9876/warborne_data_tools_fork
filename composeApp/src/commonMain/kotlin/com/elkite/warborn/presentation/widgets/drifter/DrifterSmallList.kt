package com.elkite.warborn.presentation.widgets.drifter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.drifter.Drifter
import com.elkite.warborn.presentation.widgets.utils.GearStylizedCardRow

@Composable
fun DrifterSmallList(
    drifters: List<Drifter>,
    onDrifterClick: (Drifter) -> Unit,
    columnCount: Int = 3,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        modifier = modifier,
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

    GearStylizedCardRow(
        onClick = {
            onDrifterClick(drifter)
        },
        text = drifter.name,
        composable = {
            DrifterIcon(
                modifier = Modifier.size(64.dp),
                drifterId = drifter.gameId,
            )
        }
    )
}