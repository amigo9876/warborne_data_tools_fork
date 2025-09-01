package com.elkite.warborn.presentation.widgets.loadout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.old.mods.Mod
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.widgets.tooltip.TooltipBox
import com.elkite.warborn.presentation.widgets.tooltip.TooltipState
import com.elkite.warborn.util.IconMap
import org.jetbrains.compose.resources.painterResource

@Composable
fun LoadoutModIconWithToolTip(
    tooltipState: TooltipState,
    isSelected: Boolean = false,
    modifier: Modifier = Modifier.size(48.dp),
    mod: Mod?,
    onClick: () -> Unit = {},
) {
    if (mod != null) {
    TooltipBox(
        tooltipState = tooltipState,
        gear = mod,
        modifier = modifier
    ) {
        LoadoutModIcon(
            isSelected = isSelected,
            modifier = modifier,
            mod = mod,
            onClick = onClick
        )
    }
    } else {
        LoadoutModIcon(
            isSelected = isSelected,
            modifier = modifier,
            mod = null,
            onClick = onClick
        )
    }
}

@Composable
fun LoadoutModIcon(
    isSelected: Boolean = false,
    modifier: Modifier = Modifier.size(48.dp),
    mod: Mod?,
    onClick: () -> Unit = {},
) {
    val borderModifier = if (isSelected) {
        modifier.border(
            width = 3.dp,
            brush = WarborneColorTheme.legendaryBrush,
            shape = RoundedCornerShape(16.dp)
        ).clip(RoundedCornerShape(16.dp)).clickable { onClick() }
    } else {
        modifier.border(
            width = 3.dp,
            color = WarborneColorTheme.borderSkillColor,
            shape = RoundedCornerShape(16.dp)
        ).clip(RoundedCornerShape(16.dp)).clickable { onClick() }
    }

    mod?.let {
        Image(
            modifier = borderModifier,
            painter = painterResource(
                IconMap.getModIcon(
                    it.gameId
                )
            ),
            contentDescription = null,
        )
    } ?: Box(
        modifier = borderModifier.background(Color.Black)
    )
}