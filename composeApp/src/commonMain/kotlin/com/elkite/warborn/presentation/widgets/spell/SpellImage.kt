package com.elkite.warborn.presentation.widgets.spell

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.old.GearType
import com.elkite.warborn.domain.entities.old.spell.SpellType
import com.elkite.warborn.util.IconMap
import org.jetbrains.compose.resources.painterResource

@Composable
fun SpellIcon(
    modifier: Modifier = Modifier.size(48.dp),
    gearType: GearType,
    spellType: SpellType,
    id: String
) {
    if (gearType == GearType.DRIFTER) {
        return if (spellType == SpellType.PASSIVE) {
            SpellPassiveDrifter(modifier, id)
        } else {
            SpellIconDrifter(modifier, id)
        }
    } else {
        Image(
            painter = painterResource(
                IconMap.getSkillIcon(
                    gearType,
                    id
                )
            ),
            contentDescription = "Spell's Icon",
            modifier = modifier,
        )
    }
}

@Composable
fun SpellIconDrifter(
    modifier: Modifier = Modifier.size(48.dp),
    id: String
) {
    Image(
        painter = painterResource(
            IconMap.getDrifterSpell(
                id
            )
        ),
        contentDescription = "Spell's Icon",
        modifier = modifier,
    )
}

@Composable
fun SpellPassiveDrifter(
    modifier: Modifier = Modifier.size(48.dp),
    id: String
) {
    Image(
        painter = painterResource(
            IconMap.getDrifterPassive(
                id
            )
        ),
        contentDescription = "Spell's Icon",
        modifier = modifier,
    )
}