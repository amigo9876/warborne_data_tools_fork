package com.elkite.warborn.presentation.widgets.spell

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.spell.Spell
import com.elkite.warborn.domain.entities.gear.spell.SpellType
import com.elkite.warborn.presentation.widgets.gear.ArmorImage
import com.elkite.warborn.presentation.widgets.utils.MultiPatternHighlightedText

@Composable
fun SpellCardList(
    modifier: Modifier = Modifier,
    spells: List<Spell>,
    onSpellClick: (Spell) -> Unit,
) {
    LazyColumn(modifier) {
        items(spells) { spell ->
            SpellCard(onSpellClick, spell)
        }
    }
}

@Composable
fun SpellCardListGrid(
    modifier: Modifier = Modifier,
    spells: List<Spell>,
    onSpellClick: (Spell) -> Unit,
) {

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(1),
        verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier.background(color = Color.Transparent),
    ) {
        items(spells) { spell ->
            SpellCard(onSpellClick, spell)
        }
    }
}

@Composable
fun SpellCardListSmall(
    modifier: Modifier = Modifier,
    spells: List<Spell>,
    onSpellClick: (Spell) -> Unit,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier.background(color = Color.Transparent).padding(16.dp),
    ) {
        items(spells) { spell ->
            SpellCardSmall(onSpellClick = onSpellClick, spell = spell)
        }
    }
}

@Composable
fun SpellCardSmall(
    modifier: Modifier = Modifier,
    spell: Spell,
    onSpellClick: (Spell) -> Unit,
) {
    Card(
        modifier = modifier
            .border(
                2.dp,
                color = Color.LightGray,
                shape = MaterialTheme.shapes.small
            ).clickable {
                onSpellClick(spell)
            },
        backgroundColor = Color.Transparent,
    ) {
        Column(modifier = Modifier.wrapContentSize()) {
            Row(modifier = Modifier.padding(8.dp)) {
                SpellIcon(Modifier.size(64.dp), spell = spell)
                Spacer(modifier = Modifier.size(12.dp))
                Column(
                    verticalArrangement = Arrangement.Center
                ) {
                    SpellDescriptionSmall(spell)
                    if (spell.manaCost != "0" || spell.cooldown != "0" || spell.castingRange != "0") {
                        Spacer(modifier = Modifier.size(8.dp))
                        Divider(
                            modifier = Modifier.height(1.dp),
                            color = Color.LightGray
                        )
                    }
                    Row {
                        if (spell.manaCost != "0") {
                            SpellAttributeRow(label = "Mana", value = spell.manaCost)
                        }
                        if (spell.cooldown != "0") {
                            SpellAttributeRow(label = "Cd", value = "${spell.cooldown}s")
                        }
                        if (spell.castingRange != "0") {
                            SpellAttributeRow(label = "Range", value = "${spell.castingRange}m")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SpellCard(
    onSpellClick: (Spell) -> Unit,
    spell: Spell
) {
    Card(
        modifier = Modifier.padding(8.dp)
            .border(
                2.dp,
                color = Color.LightGray,
                shape = MaterialTheme.shapes.small
            ).clickable {
                onSpellClick(spell)
            },
        backgroundColor = Color.Transparent
    ) {
        Column(modifier = Modifier.wrapContentSize()) {
            Row {
                Column(Modifier.padding(top = 2.dp, bottom = 2.dp, start = 2.dp)) {
                    SpellIcon(Modifier.size(80.dp), spell = spell)
                    if (spell.type == SpellType.SKILL) {
                        Spacer(modifier = Modifier.size(8.dp))
                        ArmorImage(Modifier.size(80.dp), spell = spell)
                    }
                }
                Spacer(modifier = Modifier.size(16.dp))
                SpellDescription(spell)
            }
        }
    }
}

@Composable
fun SpellDescriptionSmall(
    spell: Spell
) {
    Column(
        modifier = Modifier
            .padding(0.dp)
            .fillMaxWidth()
            .background(Color.Transparent),
    ) {
        MultiPatternHighlightedText(
            baseTextStyle = MaterialTheme.typography.body2.copy(color = Color.LightGray),
            text = spell.description,
            patternsWithStyles = listOf(
                Regex("""\[Damage Rate: [^\]]+]""") to SpanStyle(
                    color = Color.Red,
                    fontWeight = FontWeight.Bold
                ),
                Regex("""\[Healing Rate: [^\]]+]""") to SpanStyle(
                    color = Color.Green,
                    fontWeight = FontWeight.Bold
                ),
                Regex("""\[Target-based Max HP [^\]]+]""") to SpanStyle(
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold
                )
            )
        )
    }
}

@Composable
fun SpellDescription(spell: Spell) {
    Column(
        modifier = Modifier
            .padding(8.dp),
    ) {
        Text(
            spell.name,
            style = MaterialTheme.typography.h6,
            color = Color.LightGray
        )
        Spacer(modifier = Modifier.size(8.dp))
        MultiPatternHighlightedText(
            baseTextStyle = MaterialTheme.typography.body1.copy(color = Color.LightGray),
            text = spell.description,
            patternsWithStyles = listOf(
                Regex("""\[Damage Rate: [^\]]+]""") to SpanStyle(
                    color = Color.Red,
                    fontWeight = FontWeight.Bold
                ),
                Regex("""\[Healing Rate: [^\]]+]""") to SpanStyle(
                    color = Color.Green,
                    fontWeight = FontWeight.Bold
                ),
                Regex("""\[Target-based Max HP [^\]]+]""") to SpanStyle(
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold
                )
            )
        )
        Spacer(modifier = Modifier.size(8.dp))
        Divider(
            Modifier.fillMaxWidth().height(1.dp),
            color = Color.LightGray
        )
        Row {
            if (spell.manaCost != "0") {
                SpellAttributeRow(label = "Mana Cost", value = spell.manaCost)
            }
            if (spell.cooldown != "0") {
                SpellAttributeRow(label = "Cooldown", value = "${spell.cooldown}s")
            }
            SpellAttributeRow(label = "Range", value = "${spell.castingRange}m")
            SpellAttributeRow(
                label = "",
                value = spell.requiredGearLevel.textValue
            )
        }
    }
}

@Composable
private fun SpellAttributeRow(label: String, value: String, color: Color = Color.LightGray) {
    Row {
        Text(
            buildAnnotatedString {
                append("$label: ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(value)
                }
            },
            style = MaterialTheme.typography.subtitle2,
            color = color
        )
        Spacer(modifier = Modifier.size(8.dp))
    }
}



