package com.elkite.warborn.presentation.widgets.gear

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.GearStats
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.domain.entities.gear.spell.Spell
import com.elkite.warborn.presentation.theme.WarborneTheme
import com.elkite.warborn.resources.Com_Clothes_Armor
import com.elkite.warborn.resources.Com_Head_Helmet
import com.elkite.warborn.resources.Com_Shoes_Boots
import com.elkite.warborn.resources.Res
import com.elkite.warborn.resources.error_emoji
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

@Composable
fun ArmorImage(
    modifier: Modifier = Modifier.size(48.dp),
    gearType: GearType,
    gearStats: GearStats
) {
    Icon(
        painter = painterResource(
            when (gearType) {
                GearType.HEAD -> Res.drawable.Com_Head_Helmet
                GearType.CHEST -> Res.drawable.Com_Clothes_Armor
                GearType.BOOTS -> Res.drawable.Com_Shoes_Boots
                else -> Res.drawable.error_emoji
            },
        ),
        tint = when (gearStats) {
            GearStats.STR -> WarborneTheme.strengthColor
            GearStats.AGI -> WarborneTheme.dexterityColor
            GearStats.INT -> WarborneTheme.intelligenceColor
        },
        contentDescription = null,
        modifier = modifier.border(
            width = 2.dp,
            color = when (gearStats) {
                GearStats.STR -> WarborneTheme.strengthColor
                GearStats.AGI -> WarborneTheme.dexterityColor
                GearStats.INT -> WarborneTheme.intelligenceColor
            }
        ),
    )
}

