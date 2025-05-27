package com.elkite.warborn.presentation.widgets.gear

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.util.IconMap
import org.jetbrains.compose.resources.painterResource

@Composable
fun WeaponImage(
    modifier: Modifier = Modifier.size(48.dp),
    gearType: GearType,
    isSelected: Boolean = false,
) {
        Image(
            painter = painterResource(IconMap.getWeaponIcon(gearType)),
            contentDescription = "$gearType icon",
            modifier = modifier,
            colorFilter = if (isSelected) ColorFilter.tint(WarborneColorTheme.legendaryBorderStartColor)
            else ColorFilter.tint(WarborneColorTheme.textDescriptionColor),
        )
}
