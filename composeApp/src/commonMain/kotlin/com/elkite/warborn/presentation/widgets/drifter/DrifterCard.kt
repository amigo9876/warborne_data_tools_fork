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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.drifter.Drifter
import com.elkite.warborn.presentation.theme.WarborneTheme
import com.elkite.warborn.presentation.widgets.spell.SpellCardContent
import com.elkite.warborn.presentation.widgets.utils.AttributeList
import com.elkite.warborn.presentation.widgets.utils.GearStylizedCard
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText
import com.elkite.warborn.presentation.widgets.utils.GearStylizedTextTitle


@Composable
fun DrifterCardScrollable(
    modifier: Modifier = Modifier,
    drifter: Drifter,
    onDrifterClick: (Drifter) -> Unit,
) {
    Column(
        modifier = Modifier
            .width(600.dp)
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
                    brush = WarborneTheme.legendaryBrush,
                    shape = RectangleShape // You can change this to a different shape if needed
                ), drifterId = drifter.gameId
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
        LinksCard(drifter)
        SupportCard(drifter)
        SpellCardContent(
            spell = drifter.spell,
        )
        SpellCardContent(
            spell = drifter.passive,
        )
    }
}

@Composable
private fun LinksCard(drifter: Drifter) {
        Column(modifier = Modifier.fillMaxWidth().padding(top = 16.dp, start = 16.dp, end = 16.dp)) {
            GearStylizedTextTitle(text = "Links")
            Divider(
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 8.dp, bottom = 16.dp),
                color = WarborneTheme.borderSkillColor,
                thickness = 1.dp
            )
            drifter.links.forEach {
                Column {
                    GearStylizedTextTitle(
                        text = it.name,
                        style = MaterialTheme.typography.h5
                    )
                    Spacer(Modifier.size(8.dp))
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        it.driftersId.forEach {
                            DrifterIcon(
                                drifterId = it
                            )
                        }
                    }
                    Spacer(Modifier.size(8.dp))
                    GearStylizedText(
                        text = it.description,
                        color = WarborneTheme.textDescriptionColor,
                        style = MaterialTheme.typography.body1
                    )
                    Spacer(Modifier.size(16.dp))
                }
            }
        }
}

@Composable
private fun SupportCard(drifter: Drifter) {
    val attributes = listOf(
        drifter.supportBonus to drifter.supportBonusValue,
        drifter.supportMalus to drifter.supportMalusValue
    )
    val colors = listOf(
        WarborneTheme.textHealColor,
        WarborneTheme.textDamageColor,
    )

    Column(modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth()) {
        GearStylizedTextTitle(text = "Support")
        Divider(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 8.dp, bottom = 16.dp),
            color = WarborneTheme.borderSkillColor,
            thickness = 1.dp
        )
        AttributeList(attributes = attributes, colors = colors)
    }
}

@Composable
private fun DrifterBonusStats(drifter: Drifter) {
    val attributes = listOf(
        "Strength: " to drifter.strBonus,
        "Agility: " to drifter.dexBonus,
        "Intelligence: " to drifter.intBonus
    )
    val colors = listOf(
        WarborneTheme.strengthColor,
        WarborneTheme.dexterityColor,
        WarborneTheme.intelligenceColor
    )

    Column(modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth()) {
        AttributeList(attributes = attributes, colors = colors)
    }
}


