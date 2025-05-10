package com.elkite.warborn.presentation.widgets.spell

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.Drifter
import com.elkite.warborn.domain.entities.spell.Spell
import com.elkite.warborn.util.IconMap
import org.jetbrains.compose.resources.painterResource

@Composable
fun SpellIcon(
    modifier: Modifier = Modifier.size(48.dp),
    spell: Spell
) {
    Image(
        painter = painterResource(
            IconMap.getSkillIcon(
                spell.associatedGearType,
                spell.id
            )
        ),
        contentDescription = "Spell's Icon",
        modifier = modifier,
    )
}

@Composable
fun SpellIconDrifter(
    modifier: Modifier = Modifier.size(48.dp),
    drifter: Drifter
) {
    Image(
        painter = painterResource(
            IconMap.getDrifterSpell(
                drifter
            )
        ),
        contentDescription = "Spell's Icon",
        modifier = modifier,
    )
}

@Composable
fun SpellPassiveDrifter(
    modifier: Modifier = Modifier.size(48.dp),
    drifter: Drifter
) {
    Image(
        painter = painterResource(
            IconMap.getDrifterPassive(
                drifter
            )
        ),
        contentDescription = "Spell's Icon",
        modifier = modifier,
    )
}