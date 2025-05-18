package com.elkite.warborn.presentation.widgets.drifter

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.drifter.Drifter
import com.elkite.warborn.presentation.theme.WarborneTheme
import com.elkite.warborn.presentation.widgets.spell.SpellCardContent
import com.elkite.warborn.presentation.widgets.utils.GearStylizedCard
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText
import com.elkite.warborn.presentation.widgets.utils.GearStylizedTextTitle


@Composable
fun DrifterCardScrollable(
    modifier: Modifier = Modifier,
    drifter: Drifter,
    onDrifterClick: (Drifter) -> Unit,
) {
//    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .width(600.dp)
//            .verticalScroll(scrollState)
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
        modifier = modifier.clickable { onDrifterClick(drifter) },
        composable = @Composable { DrifterCardContent(drifter) },
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
        DrifterBonusStats(drifter)

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

@Composable
private fun DrifterBonusStats(drifter: Drifter) {
    Column(modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth()) {
        GearStylizedText(text = "Bonus stats per mastery level")
        Spacer(Modifier.size(8.dp))

        listOf(
            Triple("Strength: ", drifter.strBonus, WarborneTheme.strengthColor),
            Triple("Agility: ", drifter.dexBonus, WarborneTheme.dexterityColor),
            Triple("Intelligence: ", drifter.intBonus, WarborneTheme.intelligenceColor)
        ).forEach { (label, value, color) ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                GearStylizedText(color = color, text = label)
                GearStylizedText(
                    text = value,
                    color = WarborneTheme.textHealColor,
                    style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
                )
            }
            Spacer(Modifier.size(8.dp))
        }
    }
}


