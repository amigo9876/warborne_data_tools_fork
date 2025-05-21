package com.elkite.warborn.presentation.widgets.loadout

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.domain.entities.gear.LoadoutType
import com.elkite.warborn.presentation.theme.WarborneTheme.borderSkillColor
import com.elkite.warborn.presentation.widgets.gear.ArmorImage

@Composable
fun LoadoutArmorIcon(
    loadoutType: LoadoutType,
    gearName: String?,
    gearType: GearType?,
    onClick: () -> Unit
) {
    when (loadoutType) {
        LoadoutType.HEAD,
        LoadoutType.CHEST,
        LoadoutType.BOOTS,
        LoadoutType.WEAPON -> if (gearType != null && gearName != null) {
            Box(
                modifier = Modifier.size(64.dp).border(
                    width = 2.dp,
                    color = borderSkillColor,
                    shape = CircleShape
                ).clickable {
                    onClick()
                }) {
                ArmorImage(modifier = Modifier.size(64.dp), gearName = gearName, gearType = gearType)
            }
        } else EmptyLoadout(loadoutType, onClick)

        else -> {}
    }
}
