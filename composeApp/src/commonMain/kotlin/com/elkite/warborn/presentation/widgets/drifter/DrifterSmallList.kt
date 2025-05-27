package com.elkite.warborn.presentation.widgets.drifter

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.drifter.Drifter
import com.elkite.warborn.presentation.widgets.utils.GearStylizedCard
import com.elkite.warborn.presentation.widgets.utils.GearStylizedTextTitle
import com.elkite.warborn.presentation.widgets.utils.isCompact
import com.elkite.warborn.presentation.widgets.utils.isMedium

@Composable
fun DrifterSmallList(
    drifters: List<Drifter>,
    onDrifterClick: (Drifter) -> Unit,
    columnCount: Int = 3,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        modifier = modifier.fillMaxWidth(),
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
    if (!isCompact() && !isMedium())
        GearStylizedCard(
            modifier = Modifier.clickable {
                onDrifterClick(drifter)
            },
            composable = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    DrifterIcon(
                        modifier = Modifier.size(64.dp),
                        drifterId = drifter.gameId,
                    )
                    GearStylizedTextTitle(
                        text = drifter.name.capitalize(),
                        style = MaterialTheme.typography.body1,
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                }
            }
        )
    else
        GearStylizedCard(
            modifier = Modifier.clickable {
                onDrifterClick(drifter)
            },
            composable = {
                DrifterIcon(
                    modifier = Modifier.size(64.dp),
                    drifterId = drifter.gameId,
                )
            }
        )
}