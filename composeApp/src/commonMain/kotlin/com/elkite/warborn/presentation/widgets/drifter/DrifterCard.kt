package com.elkite.warborn.presentation.widgets.drifter

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.drifter.Drifter
import com.elkite.warborn.presentation.widgets.spell.SpellDescription
import com.elkite.warborn.presentation.widgets.spell.SpellIconDrifter
import com.elkite.warborn.presentation.widgets.spell.SpellPassiveDrifter

@Composable
expect fun DrifterCardList(
    modifier: Modifier,
    drifters: List<Drifter>,
    onDrifterClick: (Drifter) -> Unit,
    columnCount: Int
)

@Composable
fun DrifterCardListCommon(
    modifier: Modifier = Modifier,
    drifters: List<Drifter>,
    onDrifterClick: (Drifter) -> Unit,
    columnCount: Int = 1,
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(columnCount),
        verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier.background(color = Color.Transparent),
    ) {
        items(drifters) { drifter ->
            DrifterCard(drifter = drifter, onDrifterClick = onDrifterClick)
        }
    }
}

@Composable
fun DrifterCard(
    modifier: Modifier = Modifier,
    drifter: Drifter,
    onDrifterClick: (Drifter) -> Unit,
) {
    Card(
        modifier = modifier.padding(8.dp)
            .border(
                2.dp,
                color = Color.LightGray,
                shape = MaterialTheme.shapes.small
            ).clickable {
                onDrifterClick(drifter)
            },
        backgroundColor = Color.Transparent
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Row {
                DrifterIcon(drifter = drifter)
                Spacer(Modifier.size(8.dp))
                Text(
                    text = drifter.name,
                    style = MaterialTheme.typography.h6,
                    color = Color.LightGray
                )
            }
            Spacer(Modifier.size(8.dp))
            Row {
                SpellIconDrifter(drifter = drifter)
                Spacer(Modifier.size(8.dp))
                SpellDescription(spell = drifter.spell)
            }
            Spacer(Modifier.size(8.dp))
            Row {
                SpellPassiveDrifter(drifter = drifter)
                Spacer(Modifier.size(8.dp))
                SpellDescription(spell = drifter.passive)
            }
        }
    }
}


