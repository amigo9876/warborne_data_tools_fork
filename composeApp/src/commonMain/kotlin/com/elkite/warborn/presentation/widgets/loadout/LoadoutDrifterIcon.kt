package com.elkite.warborn.presentation.widgets.loadout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.old.LoadoutType
import com.elkite.warborn.domain.entities.old.drifter.Drifter
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.widgets.drifter.DrifterIcon
import com.elkite.warborn.resources.ParagonPortrait_None
import com.elkite.warborn.resources.Res
import org.jetbrains.compose.resources.painterResource

@Composable
fun LoadoutDrifterIcon(
    loadoutType: LoadoutType,
    drifter: Drifter?,
    onClick: (LoadoutType) -> Unit,
) {
    Row {
        Box(
            modifier = Modifier
                .size(64.dp)
                .border(
                    width = 2.dp,
                    brush = WarborneColorTheme.legendaryBrush,
                    shape = RectangleShape // You can change this to a different shape if needed
                )
                .background(Color.Black)
                .clickable {
                    onClick(loadoutType)
                }) {
            drifter?.let {
                DrifterIcon(
                    modifier = Modifier.size(64.dp),
                    drifterId = it.gameId
                )
            } ?: Image(
                painter = painterResource(Res.drawable.ParagonPortrait_None),
                contentDescription = null,
                modifier = Modifier.size(64.dp)
                    .clip(CutCornerShape(12.dp))
            )
        }
    }
}