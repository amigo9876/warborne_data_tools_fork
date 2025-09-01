package com.elkite.warborn.presentation.widgets.loadout

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.old.GearType
import com.elkite.warborn.domain.entities.old.LoadoutType
import com.elkite.warborn.domain.entities.old.Rarity
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.widgets.gear.ArmorImage

@Composable
fun LoadoutArmorIcon(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    loadoutType: LoadoutType,
    gearName: String?,
    gearType: GearType?,
    rarity: Rarity?,
    onClick: () -> Unit
) {
    val borderModifier =
        modifier.border(
            width = 3.dp,
            brush = if (isSelected) WarborneColorTheme.legendaryBrush else {
                when (rarity) {
                    Rarity.LEGENDARY -> WarborneColorTheme.legendaryBrush
                    Rarity.EPIC -> WarborneColorTheme.epicBrush
                    Rarity.RARE -> WarborneColorTheme.rareBrush
                    null -> WarborneColorTheme.legendaryBrush
                }
            },
            shape = RectangleShape
        ).clickable { onClick() }


    when (loadoutType) {
        LoadoutType.HEAD,
        LoadoutType.CHEST,
        LoadoutType.BOOTS,
        LoadoutType.WEAPON -> if (gearType != null && gearName != null) {
            ArmorImage(modifier = borderModifier, gearName = gearName, gearType = gearType, rarity = rarity)
        } else EmptyLoadout(isSelected, loadoutType, onClick)

        else -> {}
    }
}
