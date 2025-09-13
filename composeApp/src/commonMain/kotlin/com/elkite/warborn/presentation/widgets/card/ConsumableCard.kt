package com.elkite.warborn.presentation.widgets.card


import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.consumable.Consumable
import com.elkite.warborn.presentation.widgets.card.common.Description
import com.elkite.warborn.presentation.widgets.card.common.HeaderCard
import com.elkite.warborn.presentation.widgets.icons.ConsumableIcon

@Composable
fun ColumnScope.ConsumableCard(
    modifier: Modifier = Modifier,
    consumable: Consumable?
) {
    if (consumable == null) return
    HeaderCard(
        title = consumable.name,
        subtitle = consumable.category.name.lowercase().capitalize(),
        rarity = consumable.rarity,
        icon = {
            ConsumableIcon(
                consumableGameId = consumable.iconName,
                modifier = modifier.size(64.dp)
            )
        }
    )
    Description(consumable.description)
}