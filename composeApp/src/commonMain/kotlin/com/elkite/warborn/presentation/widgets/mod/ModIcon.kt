package com.elkite.warborn.presentation.widgets.mod

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
import com.elkite.warborn.domain.entities.gear.mods.Mod
import com.elkite.warborn.presentation.theme.WarborneTheme
import com.elkite.warborn.util.IconMap
import org.jetbrains.compose.resources.painterResource

@Composable
fun ModImage(
    modifier: Modifier = Modifier.size(48.dp),
    mod: Mod?,
    onClick: () -> Unit = {},
) {
    mod?.let {
        Image(
            modifier = modifier.border(
                width = 3.dp,
                color = WarborneTheme.borderSkillColor,
                shape = RoundedCornerShape(16.dp)
            ).clip(RoundedCornerShape(16.dp)).clickable { onClick() },
            painter = painterResource(
                IconMap.getModIcon(
                    it.gameId
                )
            ),
            contentDescription = null,
        )
    } ?: Box(
        modifier = modifier.border(
            width = 3.dp,
            color = WarborneTheme.borderSkillColor,
            shape = RoundedCornerShape(16.dp)
        ).clip(RoundedCornerShape(16.dp)).background(Color.Black).clickable { onClick() })
}