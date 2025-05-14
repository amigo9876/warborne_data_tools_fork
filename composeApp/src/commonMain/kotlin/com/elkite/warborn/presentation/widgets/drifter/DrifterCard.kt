package com.elkite.warborn.presentation.widgets.drifter

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.drifter.Drifter
import com.elkite.warborn.presentation.theme.WarborneTheme
import com.elkite.warborn.presentation.widgets.spell.SpellCardContent
import com.elkite.warborn.presentation.widgets.utils.GearStylizedCard
import com.elkite.warborn.presentation.widgets.utils.GearStylizedTextTitle

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
fun DrifterCardScrollable(
    modifier: Modifier = Modifier,
    drifter: Drifter,
    onDrifterClick: (Drifter) -> Unit,
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(Modifier.size(16.dp))
        DrifterCard(
            modifier = modifier,
            drifter = drifter,
            onDrifterClick = onDrifterClick,
        )
        Spacer(Modifier.size(32.dp))
    }
}


@Composable
fun DrifterCard(
    modifier: Modifier = Modifier,
    drifter: Drifter,
    onDrifterClick: (Drifter) -> Unit,
) {

    GearStylizedCard(
        modifier = modifier,
        composable = @Composable {DrifterCardContent(drifter) },
        onClick = {
            onDrifterClick(drifter)
        }
    )

//    Card(
//        modifier = modifier
//            .border(
//                1.dp,
//                color = WarborneTheme.borderSkillColor,
//            )
//            .clickable {
//                onDrifterClick(drifter)
//            },
//    ) {
//        Box(
//            modifier = Modifier
//                .background(color = WarborneTheme.textBackgroundColor) // Background color
//                .paint(
//                    painter = painterResource(Res.drawable.skin_image_tabBg),
//                    contentScale = ContentScale.FillBounds, // Ensures the vector scales proportionally to fill the area
//                    alignment = Alignment.Center,
//                    alpha = 0.15f
//                ).wrapContentSize()
//        ) {
//                DrifterCardContent(drifter)
//            }
//        }
    }

@Composable
private fun DrifterCardContent(drifter: Drifter) {
    //    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.wrapContentSize().padding(16.dp)
//            .verticalScroll(scrollState)
    ) {
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            DrifterIcon(
                Modifier.size(64.dp).border(
                    width = 1.dp,
                    brush = Brush.linearGradient(
                        colors = listOf(
                            WarborneTheme.drifterBorderStartColor,
                            WarborneTheme.drifterBorderMiddleColor,
                            WarborneTheme.drifterBorderEndColor
                        )
                    ),
                    shape = RectangleShape // You can change this to a different shape if needed
                ), drifter = drifter
            )
            Spacer(Modifier.size(16.dp))
            GearStylizedTextTitle(text = drifter.name)
        }
        Divider(
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp, bottom = 16.dp, start = 16.dp, end = 16.dp),
            color = WarborneTheme.borderSkillColor,
            thickness = 1.dp
        )
        SpellCardContent(
            spell = drifter.spell,
        )
        Divider(
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp, bottom = 16.dp, start = 16.dp, end = 16.dp),
            color = WarborneTheme.borderSkillColor,
            thickness = 1.dp
        )
        SpellCardContent(
            spell = drifter.passive,
        )
    }
}
//}

//        Column(modifier = Modifier.padding(8.dp)) {
//            Row {
//                DrifterIcon(drifter = drifter)
//                Spacer(Modifier.size(8.dp))
//                Text(
//                    text = drifter.name,
//                    style = MaterialTheme.typography.h6,
//                    color = Color.LightGray
//                )
//            }
//            Spacer(Modifier.size(8.dp))
//            Row {
//                SpellIconDrifter(drifter = drifter)
//                Spacer(Modifier.size(8.dp))
//                SpellDescription(spell = drifter.spell)
//            }
//            Spacer(Modifier.size(8.dp))
//            Row {
//                SpellPassiveDrifter(drifter = drifter)
//                Spacer(Modifier.size(8.dp))
//                SpellDescription(spell = drifter.passive)
//            }
//        }
//    }
//}


