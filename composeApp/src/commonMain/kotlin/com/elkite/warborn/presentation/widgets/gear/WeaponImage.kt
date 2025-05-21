package com.elkite.warborn.presentation.widgets.gear

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.presentation.theme.WarborneTheme
import com.elkite.warborn.util.IconMap
import org.jetbrains.compose.resources.painterResource

@Composable
fun WeaponImage(
    modifier: Modifier = Modifier.size(48.dp),
    gearType: GearType,
    isSelected: Boolean = false,
) {
        Icon(
            painter = painterResource(IconMap.getWeaponIcon(gearType)),
            contentDescription = "$gearType icon",
            modifier = modifier,
            tint = if (isSelected) WarborneTheme.legendaryBorderStartColor
                else WarborneTheme.textDescriptionColor
        )
}
