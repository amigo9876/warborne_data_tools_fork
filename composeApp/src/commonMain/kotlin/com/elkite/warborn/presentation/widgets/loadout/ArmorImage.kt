package com.elkite.warborn.presentation.widgets.loadout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.spell.Spell
import com.elkite.warborn.util.IconMap
import org.jetbrains.compose.resources.painterResource

@Composable
fun ArmorImage(
    modifier: Modifier = Modifier.size(48.dp),
    spell: Spell
) {
    spell.gearName?.let {
        Image(
            painter = painterResource(
                IconMap.getArmorIcon(
                    spell.associatedGearType,
                    spell.gearName
                )
            ),
            contentDescription = "Gear's Icon",
            modifier = modifier,
        )
    }
}
