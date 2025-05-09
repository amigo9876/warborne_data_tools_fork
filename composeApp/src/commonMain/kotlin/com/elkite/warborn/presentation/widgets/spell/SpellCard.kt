package com.elkite.warborn.presentation.widgets.spell

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.spell.Spell
import com.elkite.warborn.util.IconMap
import org.jetbrains.compose.resources.painterResource


@Composable
fun SpellCardList(
    spells: List<Spell>,
    onSpellClick: (Spell) -> Unit,
) {
    Card {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            spells.map {
                SpellCard(onSpellClick, it)
            }
        }
    }
}

@Composable
fun SpellCard(
    onSpellClick: (Spell) -> Unit,
    spell: Spell
) {
    Card(modifier = Modifier.padding(8.dp).clickable {
        onSpellClick(spell)
    }) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row {
                Column {
                    Text(
                        text = spell.name,
                    )
                    Icon(
                        painter = painterResource(
                            IconMap.getSkillIcon(
                                spell.associatedGearType,
                                spell.id
                            )
                        ),
                        contentDescription = "Home",
                        modifier = Modifier.size(64.dp),
                        tint = Color.Unspecified
                    )
                    Spacer(modifier = Modifier.size(16.dp))

                }
                Spacer(modifier = Modifier.size(16.dp))
                spell.gearName?.let {
                    Column {
                        Text(spell.gearName)
                        Icon(
                            painter = painterResource(
                                IconMap.getArmorIcon(
                                    spell.associatedGearType,
                                    spell.gearName
                                )
                            ),
                            contentDescription = "Home",
                            modifier = Modifier.size(64.dp),
                            tint = Color.Unspecified
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = spell.description,
            )
        }
    }
}