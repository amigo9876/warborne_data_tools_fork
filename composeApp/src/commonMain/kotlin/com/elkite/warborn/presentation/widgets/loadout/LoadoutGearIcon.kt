package com.elkite.warborn.presentation.widgets.loadout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.common.Rarity
import com.elkite.warborn.domain.entities.gear.BootsGear
import com.elkite.warborn.domain.entities.gear.ChestGear
import com.elkite.warborn.domain.entities.gear.HeadGear
import com.elkite.warborn.domain.entities.gear.WeaponGear
import com.elkite.warborn.domain.entities.mod.IMod
import com.elkite.warborn.domain.entities.mod.ModType
import com.elkite.warborn.domain.entities.mod.WeaponMod
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.widgets.icons.BootsGearIcon
import com.elkite.warborn.presentation.widgets.icons.ChestGearIcon
import com.elkite.warborn.presentation.widgets.icons.HeadGearIcon
import com.elkite.warborn.presentation.widgets.icons.IconType
import com.elkite.warborn.presentation.widgets.icons.ModIcon
import com.elkite.warborn.presentation.widgets.icons.WeaponGearIcon

@Composable
fun LoadoutHeadGearIcon(
    headGear: HeadGear?,
    onClick: () -> Unit,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
) {
    HeadGearIcon(
        modifier = modifier.getModifierForRarity(headGear?.rarity, isSelected, onClick),
        headGear = headGear,
        iconType = IconType.ARMOR
    )
}

@Composable
fun LoadoutChestGearIcon(
    chestGear: ChestGear?,
    onClick: () -> Unit,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
) {

    ChestGearIcon(
        modifier = modifier.getModifierForRarity(chestGear?.rarity, isSelected, onClick),
        chestGear = chestGear,
        iconType = IconType.ARMOR
    )
}

@Composable
fun LoadoutBootsGearIcon(
    bootsGear: BootsGear?,
    onClick: () -> Unit,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
) {
    BootsGearIcon(
        modifier = modifier.getModifierForRarity(bootsGear?.rarity, isSelected, onClick),
        bootsGear = bootsGear,
        iconType = IconType.ARMOR
    )
}

@Composable
fun LoadoutWeaponGearIcon(
    weaponGear: WeaponGear?,
    onClick: () -> Unit,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
) {
    WeaponGearIcon(
        modifier = modifier.getModifierForRarity(weaponGear?.rarity, isSelected, onClick),
        weaponGear = weaponGear
    )
}

@Composable
fun LoadoutWeaponModIcon(
    mod: WeaponMod?,
    onClick: () -> Unit,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
) {
    val borderModifier = if (mod == null) {
        modifier.border(
            width = 1.dp,
            brush = if (isSelected) WarborneColorTheme.selectionBrush else WarborneColorTheme.commonBrush,
            shape = RoundedCornerShape(16.dp)
        ).background(Color.Black, shape = RoundedCornerShape(16.dp)).clickable { onClick() }
    } else modifier.border(
        width = 1.dp,
        brush = mod.rarity.getRarityBorder(isSelected) ,
        shape = RoundedCornerShape(16.dp)
    ).clickable { onClick() }

    ModIcon(
        modifier = borderModifier,
        modGameId = mod?.iconName,
        modType = ModType.WEAPON,
    )
}

@Composable
fun LoadoutArmorModIcon(
    mod: IMod?,
    onClick: () -> Unit,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
) {
    val borderModifier = if (mod == null) {
        modifier.border(
            width = 1.dp,
            brush = if (isSelected) WarborneColorTheme.selectionBrush else WarborneColorTheme.commonBrush,
            shape = RoundedCornerShape(16.dp)
        ).background(Color.Black, shape = RoundedCornerShape(16.dp)).clickable { onClick() }
    } else modifier.border(
        width = 1.dp,
        brush = mod.rarity.getRarityBorder(isSelected) ,
        shape = RoundedCornerShape(16.dp)
    ).clickable { onClick() }

    ModIcon(
        modifier = borderModifier,
        modGameId = mod?.iconName,
        modType = ModType.ARMOR,
    )
}

fun Modifier.getModifierForRarity(
    rarity: Rarity?,
    isSelected: Boolean = false,
    onClick: () -> Unit = {}
): Modifier {
    return rarity?.let {
        this.background(
            brush = rarity.getRarityBackground(),
            shape = RectangleShape
        ).border(
            width = if (isSelected) 2.dp else 1.dp,
            brush = rarity.getRarityBorder(isSelected),
            shape = RectangleShape
        ).clickable { onClick() }
    } ?: this.background(Color.Black).border(
        width = 2.dp,
        brush = rarity.getRarityBorder(isSelected),
        shape = RectangleShape
    ).clickable { onClick() }
}

fun Rarity?.getRarityBackground(): Brush {
    return when (this) {
        Rarity.legendary -> WarborneColorTheme.legendaryBrushBackground
        Rarity.epic -> WarborneColorTheme.epicBrushBackground
        Rarity.rare -> WarborneColorTheme.rareBrushBackground
        Rarity.uncommon -> WarborneColorTheme.uncommonBrushBackGround
        Rarity.common, null -> WarborneColorTheme.commonBrushBackground
    }
}

fun Rarity?.getRarityBorder(isSelected: Boolean): Brush {
    return if (isSelected) WarborneColorTheme.selectionBrush else {
        when (this) {
            Rarity.legendary -> WarborneColorTheme.legendaryBrush
            Rarity.epic -> WarborneColorTheme.epicBrush
            Rarity.rare -> WarborneColorTheme.rareBrush
            Rarity.uncommon -> WarborneColorTheme.uncommonBrush
            Rarity.common, null -> WarborneColorTheme.commonBrush
        }
    }
}