package com.elkite.warborn.presentation.widgets.drifter

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.drifter.Drifter
import com.elkite.warborn.presentation.theme.WarborneTheme
import com.elkite.warborn.presentation.widgets.spell.SpellCardContent
import com.elkite.warborn.presentation.widgets.utils.GearStylizedCard
import com.elkite.warborn.presentation.widgets.utils.GearStylizedTextTitle


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
            .padding()
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
        composable = @Composable { DrifterCardContent(drifter) },
        onClick = {
            onDrifterClick(drifter)
        }
    )
}

@Composable
private fun DrifterCardContent(drifter: Drifter) {
    Column(
        modifier = Modifier.wrapContentSize().padding(all = 16.dp)
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
            modifier = Modifier.fillMaxWidth()
                .padding(top = 8.dp, bottom = 16.dp, start = 16.dp, end = 16.dp),
            color = WarborneTheme.borderSkillColor,
            thickness = 1.dp
        )
        SpellCardContent(
            spell = drifter.spell,
        )
        Divider(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 8.dp, bottom = 16.dp, start = 16.dp, end = 16.dp),
            color = WarborneTheme.borderSkillColor,
            thickness = 1.dp
        )
        SpellCardContent(
            spell = drifter.passive,
        )
    }
}


