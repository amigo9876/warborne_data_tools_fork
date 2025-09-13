package com.elkite.warborn.presentation.widgets.consumable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.consumable.Consumable
import com.elkite.warborn.presentation.widgets.icons.ConsumableIcon
import com.elkite.warborn.presentation.widgets.utils.GearStylizedCard
import com.elkite.warborn.presentation.widgets.utils.isCompact
import com.elkite.warborn.presentation.widgets.utils.isMedium

@Composable
fun ConsumableSmallList(
    modifier: Modifier = Modifier,
    consumables: List<Consumable>,
    onConsumableClick: (Consumable) -> Unit
) {
    LazyVerticalGrid(
        modifier = modifier.fillMaxWidth(),
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items(consumables) { conso ->
            ConsumableSmallItem(
                consumable = conso,
                onConsumableClick = onConsumableClick,
            )
        }
    }
}

@Composable
private fun ConsumableSmallItem(
    consumable: Consumable,
    onConsumableClick: (Consumable) -> Unit,
) {
    if (!isCompact() && !isMedium())
        GearStylizedCard(
            modifier = Modifier.clickable {
                onConsumableClick(consumable)
            },
            composable = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center

                ) {
                    ConsumableIcon(
                        modifier = Modifier.size(64.dp),
                        consumableGameId = consumable.iconName,
                    )
                }
            }
        )
    else
        GearStylizedCard(
            modifier = Modifier.clickable {
                onConsumableClick(consumable)
            },
            composable = {
                ConsumableIcon(
                    modifier = Modifier.size(64.dp),
                    consumableGameId = consumable.iconName,
                )
            }
        )
}
