package com.elkite.warborn.presentation.widgets.loadout

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.domain.entities.gear.LoadoutType
import com.elkite.warborn.domain.entities.gear.Rarity
import com.elkite.warborn.presentation.theme.WarborneTheme
import com.elkite.warborn.presentation.widgets.gear.ArmorImage

@Composable
fun LoadoutArmorIcon(
    isSelected: Boolean = false,
    loadoutType: LoadoutType,
    gearName: String?,
    gearType: GearType?,
    rarity: Rarity?,
    onClick: () -> Unit
) {
    val modifier =
        Modifier.border(
            width = 3.dp,
            brush = if (isSelected) WarborneTheme.legendaryBrush else {
                when (rarity) {
                    Rarity.LEGENDARY -> WarborneTheme.legendaryBrush
                    Rarity.EPIC -> WarborneTheme.epicBrush
                    Rarity.RARE -> WarborneTheme.rareBrush
                    null -> WarborneTheme.legendaryBrush
                }
            },
            shape = RectangleShape
        ).clickable { onClick() }


    when (loadoutType) {
        LoadoutType.HEAD,
        LoadoutType.CHEST,
        LoadoutType.BOOTS,
        LoadoutType.WEAPON -> if (gearType != null && gearName != null) {
            ArmorImage(modifier = modifier, gearName = gearName, gearType = gearType, rarity = rarity)
        } else EmptyLoadout(isSelected, loadoutType, onClick)

        else -> {}
    }
}
