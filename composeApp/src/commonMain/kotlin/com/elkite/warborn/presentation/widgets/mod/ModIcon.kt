package com.elkite.warborn.presentation.widgets.mod

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.mods.Mod
import com.elkite.warborn.util.IconMap
import org.jetbrains.compose.resources.painterResource

@Composable
fun ModImage(
    modifier: Modifier = Modifier.size(64.dp),
    mod: Mod,
    onClick: () -> Unit = {},
) {
    Image(
        modifier = modifier.clip(RoundedCornerShape(16.dp)).clickable { onClick() },
        painter = painterResource(
            IconMap.getModIcon(
                mod.gameId
            )
        ),
        contentDescription = null,
    )
}